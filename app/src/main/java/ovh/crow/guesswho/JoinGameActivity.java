package ovh.crow.guesswho;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

public class JoinGameActivity extends AppCompatActivity {

    /* Show available devices. (Peripheral) */

    private BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

    private String connectedMAC;
    private App btSD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_game);

        btSD = (App) getApplication();

        // See if there are paired devices:
        final Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
        String[] btDeviceNames = new String[pairedDevices.size()];
        if (pairedDevices.size() > 0) {
            // There are paired devices. Get the name of each paired device.
            Iterator<BluetoothDevice> btIter = pairedDevices.iterator();
            for (int i = 0 ; i < pairedDevices.size() ; i++) {
                btDeviceNames[i] = btIter.next().getName();
            }
        }
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.bluetooth_names, btDeviceNames);

        ListView listView = (ListView) findViewById(R.id.lv_bt_devices);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int j = 0;
                for (BluetoothDevice temp : pairedDevices) {
                    if (i == j) {
                        //Toast.makeText(JoinGameActivity.this, "Connection called with index: " + j, Toast.LENGTH_SHORT).show();
                        connectedMAC = temp.getAddress();
                        new ConnectATConnection(connectedMAC).execute();
                        break;
                    }
                    j++;
                }
            }
        });
    }

    public void startGame(){
        Intent playingActivity = new Intent(this, PlayingActivity.class);
        playingActivity.putExtra("device",connectedMAC);
        startActivity(playingActivity);
    }

    private class ConnectATConnection extends AsyncTask<Void, Void, BluetoothSocket> {

        private UUID RFCOMM_UUID = UUID.fromString("00000000-0000-0000-0000-000123456789");
        private BluetoothAdapter mBluetoothAdapter;
        private BluetoothSocket mmSocket;
        private final BluetoothDevice mmDevice;

        public ConnectATConnection(String mac){
            mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            BluetoothSocket tmp = null;
            mmDevice = mBluetoothAdapter.getRemoteDevice(mac);
            try {
                tmp = mmDevice.createInsecureRfcommSocketToServiceRecord(RFCOMM_UUID);
            } catch (IOException e){}
            mmSocket = tmp;
        }
        @Override
        protected BluetoothSocket  doInBackground(Void... params) {
            mBluetoothAdapter.cancelDiscovery();
            try {
                mmSocket.connect();
                return mmSocket;
            } catch(IOException connectException){
                System.out.println("Unable to connect to server");
                try{
                    mmSocket.close();
                } catch (IOException closeException){

                }
                return null;
            }
        }
        @Override
        protected void onPostExecute(BluetoothSocket socket) {
            btSD.setBtServerSocket(socket);
            btSD.setBtServerMac(socket.getRemoteDevice().getAddress());
            btSD.setBtClientMac(mBluetoothAdapter.getAddress());
            btSD.setGameStarter(false);
            startGame();
        }
    }
}
