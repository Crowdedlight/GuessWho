package ovh.crow.guesswho;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Spinner;

import org.greenrobot.greendao.query.Query;

import java.util.List;

public class PlayingActivity extends AppCompatActivity {

    PortraitAdapter portraitAdapter;
    GridView gridView;

    private PersonDao personDao;
    private AreasDao areasDao;
    private Query<Person> personQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);

        //get data
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        personDao = daoSession.getPersonDao();
        areasDao = daoSession.getAreasDao();

        personQuery = personDao.queryBuilder().orderAsc(PersonDao.Properties.Name).build();

        setupViews();
    }

    private void setupViews() {
        //get view
        gridView = (GridView) findViewById(R.id.boardView);

        //make adapter
        List<Person> persons = personQuery.list();
        portraitAdapter = new PortraitAdapter(this, R.layout.image_board_view);
        portraitAdapter.addAll(persons);
        gridView.setAdapter(portraitAdapter);

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

    public void SendQuestion(View view) {
        //TODO get data from spinners and send question
    }
}
