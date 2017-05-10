package ovh.crow.guesswho;

import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import org.greenrobot.greendao.query.Query;
import org.w3c.dom.Attr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Delayed;

public class PlayingActivity extends AppCompatActivity {

    static final int REQUESTCODE_PERSON = 101;

    PortraitAdapter portraitAdapter;
    GridView gridView;

    private PersonDao personDao;
    private AreasDao areasDao;
    private AttributeDao attributeDao;
    private Query<Person> personQuery;
    private App btSD;
    private GameData gameData = new GameData();
    private String tempData;
    private BufferedReader bufferedreader;
    private BufferedWriter bufferedwriter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);

        //get data
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        personDao = daoSession.getPersonDao();
        areasDao = daoSession.getAreasDao();
        attributeDao = daoSession.getAttributeDao();
        btSD = (App) getApplication();

        personQuery = personDao.queryBuilder().orderAsc(PersonDao.Properties.Name).build();

        setupViews();
        setInOutStreams();
        gameData.setMyTurn(btSD.getGameStarter());

        selectPlayer();

        new ReceiveQuestion(bufferedreader).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    private void selectPlayer() {
        Intent intent = new Intent(this, SelectPlayerActivity.class);
        intent.setType("Long");
        startActivityForResult(intent, REQUESTCODE_PERSON);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUESTCODE_PERSON) {
            if (resultCode == RESULT_OK) {
                Long personID = data.getLongExtra("result", 1);
                List<Person> persons = personQuery.list();
                for (Person p : persons) {
                    if (p.getId().equals(personID)) {
                        gameData.setSelectedPerson(p);
                        break;}
                }
            }
            if (resultCode == RESULT_CANCELED) {
                selectPlayer();
            }
        }
    }

    private void setInOutStreams(){
        BluetoothSocket socket;
        if (btSD.getGameStarter()) {
            socket = btSD.getBtClientSocket();
        } else {
            socket = btSD.getBtServerSocket();
        }

        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            System.out.println("Could not create in- and output stream");
            return;
        }

        bufferedreader = new BufferedReader(new InputStreamReader(inputStream));
        bufferedwriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        System.out.println("Created in- and output stream");
    }

    private void setupViews() {
        //get view
        gridView = (GridView) findViewById(R.id.boardView);

        //make adapter
        List<Person> persons = personQuery.list();
        portraitAdapter = new PortraitAdapter(this, R.layout.image_board_view);
        portraitAdapter.addAll(persons);
        gridView.setAdapter(portraitAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                portraitAdapter.toggle(position);
            }
        });

        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Person p = (Person) adapterView.getAdapter().getItem(i);
                gameData.setPerID(p.getId());

                Context mContext = getApplicationContext();
                int resID = mContext.getResources().getIdentifier(p.getImgName(), "drawable", mContext.getPackageName());
                ImageView personImg = new ImageView(adapterView.getContext());
                personImg.setImageResource(resID);

                AlertDialog.Builder personGuess = new AlertDialog.Builder(adapterView.getContext());
                personGuess.setMessage("Make a guess on this person?")
                        .setPositiveButton("Guess", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                longPressGuess();
                                dialogInterface.dismiss();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .setView(personImg)
                        .setTitle("Guess:")
                        .setCancelable(false)
                        .create();
                personGuess.show();
                return true;
            }
        });

        //button
        final Button btn = (Button) findViewById(R.id.askBtn);
        btn.setEnabled(false);

        //Spinners
        Spinner spinArea = (Spinner) findViewById(R.id.spinnerArea);
        final Spinner spinAttribute = (Spinner) findViewById(R.id.spinnerAttribute);
        spinAttribute.setEnabled(false);

        //get data
        final List<Areas> areas = areasDao.queryBuilder().orderAsc(AreasDao.Properties.Name).list();
        AreaAdapter areaAdapter = new AreaAdapter(getApplicationContext(), R.layout.spinner_item);
        areaAdapter.addAll(areas);
        spinArea.setAdapter(areaAdapter);

        //set onSelectedHandler
        spinArea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //get attributes
                Areas sArea = (Areas) parent.getSelectedItem();

                List<Attribute> attributes = sArea.getAttributes();
                AttributeAdapter attributeAdapter = new AttributeAdapter(getApplicationContext(), R.layout.spinner_item);
                attributeAdapter.addAll(attributes);
                spinAttribute.setAdapter(attributeAdapter);
                spinAttribute.setEnabled(true);
                btn.setEnabled(true);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void interpretReceivedJSON(){
        //Toast.makeText(getApplicationContext(), "Flag = " + gameData.getFlagIn(), Toast.LENGTH_LONG).show();

        if (gameData.getFlagIn() == gameData.FLAG_QUESTION) {
            gameData.setFlagOut(gameData.FLAG_ANSWER);
            answerQuestionFromOpponent();
        }
        else if (gameData.getFlagIn() == gameData.FLAG_ANSWER) {
            updateAfterReceivedAnswer();
        }
        else if (gameData.getFlagIn() == gameData.FLAG_GUESS) {
            gameData.setFlagOut(gameData.FLAG_ANSWER);
            answerPersonGuess();
        }
        else if (gameData.getFlagIn() == gameData.FLAG_GUESS_ANSWER) {
            checkPersonGuess();
        }
        else {
            System.out.println("Incoming flag error = -1");
        }
    }

    public void updateAfterReceivedAnswer() {
        // TODO: 05/05/2017 Remove all players with attribute:
        Attribute a = attributeDao.load(gameData.getAttID());

        System.out.println("Gamedata: " + gameData.DEBUGtoJSON());

        String s = "";
        if (gameData.getQuestAnswer()) {
            s = "Your opponent has ";
        }
        else if (!gameData.getQuestAnswer()) {
            s = "Your opponent does not have ";
        }

        AlertDialog.Builder answerDialog = new AlertDialog.Builder(this);
        answerDialog.setMessage(s + a.getModifier().getName() + " " + a.getArea().getName())
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .setTitle("Answer:")
                .setCancelable(false)
                .create();
        answerDialog.show();

        final Button btn = (Button) findViewById(R.id.askBtn);
        btn.setEnabled(true);

        gameData.flipMyTurn();

        /*
        List<Person> persons = personQuery.list();
        for (Person p : persons)
        {
            List<Attribute> attributes = p.getAttributesWithThisPerson();
            for (Attribute a : attributes)
            {
                if (mAttribute.equals(a)) {
                    // TODO: 05/05/2017 make image gray or something..
                }
            }
        }
        */
    }

    public void answerPersonGuess() {
        gameData.flipMyTurn();
        gameData.setQuestAnswer(gameData.getSelectedPerson().getId().equals(gameData.getPerID()));
        gameData.setFlagOut(gameData.FLAG_GUESS_ANSWER);
        new SendBTQuestion(bufferedwriter).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, gameData.toJSON());
        if (gameData.getQuestAnswer()) {
            AlertDialog.Builder personGuess = new AlertDialog.Builder(this);
            personGuess.setMessage("You lose... You made " + gameData.getNoGuess() + " guess's.")
                    .setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            newGame();
                            dialogInterface.dismiss();
                        }
                    })
                    .setCancelable(false)
                    .setTitle("Game over!")
                    .create();
            personGuess.show();
        } else {
            AlertDialog.Builder personGuess = new AlertDialog.Builder(this);
            personGuess.setMessage("Your opponent guessed wrong.")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
                    .setCancelable(false)
                    .setTitle("Phew..")
                    .create();
            personGuess.show();
        }

        final Button btn = (Button) findViewById(R.id.askBtn);
        btn.setEnabled(true);
    }

    public void answerQuestionFromOpponent(){
        checkReceivedQuestion();

        Attribute a = attributeDao.load(gameData.getAttID());

        // Get image of selected person.
        Context mContext = getApplicationContext();
        int resID = mContext.getResources().getIdentifier(gameData.getSelectedPerson().getImgName(), "drawable", mContext.getPackageName());
        ImageView personImg = new ImageView(this);
        personImg.setImageResource(resID);

        final AlertDialog.Builder answerDialog = new AlertDialog.Builder(this);
        answerDialog.setMessage("Your opponent ask if your character has " + a.getModifier().getName() + " " + a.getArea().getName())
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (gameData.getQuestAnswer()) {
                            gameData.flipMyTurn();
                            new SendBTQuestion(bufferedwriter).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, gameData.toJSON());
                            dialogInterface.dismiss();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Don't lie..", Toast.LENGTH_SHORT).show();
                            answerQuestionFromOpponent();
                        }
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (!gameData.getQuestAnswer()) {
                            gameData.flipMyTurn();
                            new SendBTQuestion(bufferedwriter).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, gameData.toJSON());
                            dialogInterface.dismiss();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Don't lie..", Toast.LENGTH_SHORT).show();
                            answerQuestionFromOpponent();
                        }
                    }
                })
                .setCancelable(false)
                .setView(personImg)
                .setTitle("Question:")
                .create();
        answerDialog.show();
    }

    private void checkReceivedQuestion() {
        List<Attribute> attri = gameData.getSelectedPerson().getAttributesWithThisPerson();
        gameData.setQuestAnswer(false);
        for (Attribute a : attri)
        {
            if (a.getId().equals(gameData.getAttID()))
            {
                gameData.setQuestAnswer(true);
            }
        }
    }

    public void checkPersonGuess() {
        gameData.flipMyTurn();
        if (gameData.getQuestAnswer()) {
            AlertDialog.Builder personGuess = new AlertDialog.Builder(this);
            personGuess.setMessage("Congratulations! You won with " + gameData.getNoGuess() + " guess's.")
                    .setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            newGame();
                            dialogInterface.dismiss();
                        }
                    })
                    .setTitle("You Win!")
                    .setCancelable(false)
                    .create();
            personGuess.show();
        } else {
            AlertDialog.Builder personGuess = new AlertDialog.Builder(this);
            personGuess.setMessage("Hmm.. So he's not that person..")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
                    .setTitle("Wrong guess")
                    .setCancelable(false)
                    .create();
            personGuess.show();
        }

        final Button btn = (Button) findViewById(R.id.askBtn);
        btn.setEnabled(true);
    }

    public void longPressGuess() {
        gameData.addGuess();
        if (!gameData.getMyTurn()) {
            Toast.makeText(getApplicationContext(),"It's not your turn..", Toast.LENGTH_SHORT).show();
        } else {
            gameData.setFlagOut(gameData.FLAG_GUESS);

            final Button btn = (Button) findViewById(R.id.askBtn);
            btn.setEnabled(false);

            new SendBTQuestion(bufferedwriter).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, gameData.toJSON());
        }
    }

    public void onSendQuestion(View view) {
        gameData.addGuess();
        if (!gameData.getMyTurn()) {
            Toast.makeText(getApplicationContext(),"It's not your turn..", Toast.LENGTH_SHORT).show();
        } else {
            Spinner attr = (Spinner) findViewById(R.id.spinnerAttribute);
            Attribute mAttribute = (Attribute) attr.getSelectedItem();

            gameData.setFlagOut(gameData.FLAG_QUESTION);
            gameData.setAttID(mAttribute.getId());

            final Button btn = (Button) findViewById(R.id.askBtn);
            btn.setEnabled(false);

            Toast.makeText(getApplicationContext(), "Question send..." , Toast.LENGTH_SHORT).show();

            new SendBTQuestion(bufferedwriter).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, gameData.toJSON());
        }
    }

    private void newGame () {
        gameData.resetData();
        gameData.setMyTurn(btSD.getGameStarter());
        setupViews();
        selectPlayer();
        new ReceiveQuestion(bufferedreader).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    public void onShowMyPlayer(View view) {
        // Get image of selected person.
        Context mContext = getApplicationContext();
        int resID = mContext.getResources().getIdentifier(gameData.getSelectedPerson().getImgName(), "drawable", mContext.getPackageName());
        ImageView personImg = new ImageView(this);
        personImg.setImageResource(resID);

        AlertDialog.Builder answerDialog = new AlertDialog.Builder(this);
        answerDialog.setMessage("This is your character")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .setView(personImg)
                .setTitle("Your player")
                .setCancelable(false)
                .create();
        answerDialog.show();
    }

    public void onShowGameStats(View view) {
        AlertDialog.Builder answerDialog = new AlertDialog.Builder(this);
        answerDialog.setMessage("you have currently made " + gameData.getNoGuess() + " guess's.")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .setTitle("Game stats")
                .setCancelable(false)
                .create();
        answerDialog.show();
    }

    /**
     * Constructor takes the Buffered writer used to write.
     * The Execute takes the String to send.
     */
    private class SendBTQuestion extends AsyncTask<String, Void, Void> {
        private BufferedWriter bufferedwriter = null;

        public SendBTQuestion(BufferedWriter writer){
            bufferedwriter = writer;
        }

        @Override
        protected Void doInBackground(String... params) {
            try {
                bufferedwriter.write(params[0]);
                System.out.println("Outgoing: " + params[0]);
                bufferedwriter.newLine();
                bufferedwriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Send successfully.");
            return null;
        }
    }

    /**
     * Constructor takes the Buffered reader used to read.
     * The class sets the data variable with the result from the read.
     */
    private class ReceiveQuestion extends AsyncTask<Void, Void, String> {
        private BufferedReader bufferedreader = null;

        public ReceiveQuestion(BufferedReader reader){
            bufferedreader = reader;
        }

        @Override
        protected String doInBackground(Void... params) {
            String result = null;
            System.out.println("Listening for incomming JSON");
            try {
                result = bufferedreader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            tempData = s;
            System.out.println("Incomming: " + tempData);
            gameData.fromJSON(s);
            interpretReceivedJSON();
            // Start new async task:
            new ReceiveQuestion(bufferedreader).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }
    }
}
