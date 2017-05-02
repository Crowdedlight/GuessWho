package ovh.crow.guesswho;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

import static android.content.ContentValues.TAG;
import static android.provider.Telephony.Carriers.NAME;

public class JoinGameActivity extends AppCompatActivity {

    /* Show available devices. (Peripheral) */

    private BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_game);

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
                        Toast.makeText(JoinGameActivity.this, "Connection called with index: " + j, Toast.LENGTH_SHORT).show();
                        ConnectThread newConnection = new ConnectThread(temp);
                        newConnection.run();
                    }
                    j++;
                }
            }
        });
    }

    private class ConnectThread extends Thread {
        private final BluetoothSocket mmSocket;
        private final BluetoothDevice mmDevice;
        private UUID RFCOMM = UUID.fromString("00000000-0000-0000-0000-000123456789");

        public ConnectThread(BluetoothDevice device) {
            // Use a temporary object that is later assigned to mmSocket
            // because mmSocket is final.
            BluetoothSocket tmp = null;
            mmDevice = device;

            try {
                // Get a BluetoothSocket to connect with the given BluetoothDevice.
                // MY_UUID is the app's UUID string, also used in the server code.
                tmp = device.createRfcommSocketToServiceRecord(RFCOMM);
            } catch (IOException e) {
                Log.e(TAG, "Socket's create() method failed", e);
            }
            mmSocket = tmp;
        }

        public void run() {
            // Cancel discovery because it otherwise slows down the connection.
            mBluetoothAdapter.cancelDiscovery();

            try {
                // Connect to the remote device through the socket. This call blocks
                // until it succeeds or throws an exception.
                mmSocket.connect();
            } catch (IOException connectException) {
                // Unable to connect; close the socket and return.
                try {
                    mmSocket.close();
                } catch (IOException closeException) {
                    Log.e(TAG, "Could not close the client socket", closeException);
                }
            }

            // The connection attempt succeeded. Perform work associated with
            // the connection in a separate thread.

            Intent intent = new Intent(ovh.crow.guesswho.JoinGameActivity.this, ConnectedActivity.class);
            startActivity(intent);

            //MyBluetoothService();
            //manageMyConnectedSocket(mmSocket);
        }

        // Closes the client socket and causes the thread to finish.
        public void cancel() {
            try {
                mmSocket.close();
            } catch (IOException e) {
                Log.e(TAG, "Could not close the client socket", e);
            }
        }
    }
}
