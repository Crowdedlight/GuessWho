package ovh.crow.guesswho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.greenrobot.greendao.database.Database;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseSeeder.seedDatabase(getBaseContext());

        //for debug reasons
        Intent intent = new Intent(MainActivity.this, PlayingActivity.class);
        startActivity(intent);
    }
}
