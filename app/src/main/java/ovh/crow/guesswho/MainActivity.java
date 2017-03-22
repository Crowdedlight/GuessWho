package ovh.crow.guesswho;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final static int REQUEST_ENABLE_BT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Bluetooth check.
        First check if device supports Bluetooth
        Then check if Bluetooth is enabled.
         */
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            // Device does not support Bluetooth
            setContentView(R.layout.exit);
        }
        else if (!mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }

    }


    protected void onNewGame(View view){

    }

    protected void onJoinGame(View view){

    }

    protected void onExit(View view){
        finish();
        System.exit(0);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        if (requestCode == RESULT_OK)
        {
            // Bluetooth enabled

            Context context = getApplicationContext();
            CharSequence text = "Bluetooth enabled";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else if (requestCode == RESULT_CANCELED)
        {
            // Bluetooth disabled

            Context context = getApplicationContext();
            CharSequence text = "Bluetooth disabled";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

}
