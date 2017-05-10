package ovh.crow.guesswho;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import org.greenrobot.greendao.query.Query;

import java.util.List;
import java.util.Random;

public class SelectPlayerActivity extends AppCompatActivity {

    private Query<Person> personQuery;
    private PersonDao personDao;
    private List<Person> persons;
    private Person selectedPerson;

    private SensorManager mSensorManager;
    private float mAccel; // acceleration apart from gravity
    private float mAccelCurrent; // current acceleration including gravity
    private float mAccelLast; // last acceleration including gravity

    final static int TIME_INTERVAL = 200;       // 200 milliseconds
    private long lastUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_player);

        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        personDao = daoSession.getPersonDao();
        personQuery = personDao.queryBuilder().orderAsc(PersonDao.Properties.Name).build();
        persons = personQuery.list();

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels, height = dm.heightPixels;
        getWindow().setLayout((int)(width*0.8),(int)(height*0.65));

        Random randNumber = new Random();
        selectedPerson = persons.get(randNumber.nextInt((personQuery.list().size())));

        Context mContext = getApplicationContext();
        int resID = mContext.getResources().getIdentifier(selectedPerson.getImgName(), "drawable", mContext.getPackageName());

        ImageView personImg = (ImageView) findViewById(R.id.iv_selected_player);
        personImg.setImageResource(resID);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensorManager.registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
        mAccel = 0.00f;
        mAccelCurrent = SensorManager.GRAVITY_EARTH;
        mAccelLast = SensorManager.GRAVITY_EARTH;

        lastUpdate = System.currentTimeMillis();
    }

    public void onSelectPlayer(View view) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result",selectedPerson.getId());
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }

    private final SensorEventListener mSensorListener = new SensorEventListener() {

        public void onSensorChanged(SensorEvent se) {
            float x = se.values[0];
            float y = se.values[1];
            float z = se.values[2];
            mAccelLast = mAccelCurrent;
            mAccelCurrent = (float) Math.sqrt((double) (x*x + y*y + z*z));
            float delta = mAccelCurrent - mAccelLast;
            mAccel = mAccel * 0.9f + delta; // perform low-cut filter

            if (mAccel > 8) {
                
                long curTime = System.currentTimeMillis();
                long diffTime = (curTime - lastUpdate);

                if (diffTime > TIME_INTERVAL) {
                    lastUpdate = curTime;
                    handleShakeEvent();
                }
            }
        }

        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        mSensorManager.unregisterListener(mSensorListener);
        super.onPause();
    }

    private void handleShakeEvent(){
        Random randNumber = new Random();
        selectedPerson = persons.get(randNumber.nextInt((personQuery.list().size())));

        easterEgg();

        Context mContext = getApplicationContext();
        int resID = mContext.getResources().getIdentifier(selectedPerson.getImgName(), "drawable", mContext.getPackageName());

        ImageView personImg = (ImageView) findViewById(R.id.iv_selected_player);
        personImg.setImageResource(resID);

        Log.d("SHAKE", "Shake");
    }

    private void easterEgg() {
        if (selectedPerson.getName().equals("Marcellus")) {
            Toast.makeText(getApplicationContext(), "Does he look like i bitch to you?", Toast.LENGTH_SHORT).show();
        }
        else if (selectedPerson.getName().equals("Jules")) {
            Toast.makeText(getApplicationContext(), "Say what again, I dare you, I double dare you motherfucker!", Toast.LENGTH_SHORT).show();
        }
    }

}
