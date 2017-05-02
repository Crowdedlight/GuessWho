package ovh.crow.guesswho;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.Set;
import java.util.UUID;

public class NewGameActivity extends AppCompatActivity {

    /* Makes the app visible to others. (Server) */

    BluetoothAdapter adapter;
    BluetoothSocket btSocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);


        Intent discoverableIntent =
                new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
        startActivity(discoverableIntent);

        //AcceptThread newConnection = new AcceptThread();
        //newConnection.run();

    }


    private class AcceptThread extends Thread {
        private BluetoothAdapter madapter;
        private final BluetoothServerSocket mmServerSocket;
        private UUID RFCOMM = UUID.fromString("00000000-0000-0000-0000-000123456789");
        private String BT_NAME = "BLUETOOTH_GAME_GUESS_WHO";

        public AcceptThread() {
            // Use a temporary object that is later assigned to mmServerSocket
            // because mmServerSocket is final.
            BluetoothServerSocket tmp = null;
            try {
                // MY_UUID is the app's UUID string, also used by the client code.
                tmp = madapter.listenUsingRfcommWithServiceRecord(BT_NAME, RFCOMM);
            } catch (IOException e) {
                System.out.println("No connection");
            }
            mmServerSocket = tmp;
        }

        public void run() {
            BluetoothSocket socket = null;
            // Keep listening until exception occurs or a socket is returned.
            while (true) {
                try {
                    socket = mmServerSocket.accept();
                } catch (IOException e) {
                    System.out.println("Socket's accept() method failed");
                    break;
                }

                if (socket != null) {
                    // A connection was accepted. Perform work associated with
                    // the connection in a separate thread.
                    //MyBluetoothService();
                    Intent intent = new Intent(ovh.crow.guesswho.NewGameActivity.this, ConnectedActivity.class);
                    startActivity(intent);
                    /*
                    try {
                        mmServerSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                    */
                }
            }
        }

        // Closes the connect socket and causes the thread to finish.
        public void cancel() {
            try {
                mmServerSocket.close();
            } catch (IOException e) {
                System.out.println("Could not close the connect socket");
            }
        }
    }


    /*
    private class BTConnection  {
        private BluetoothAdapter madapter;
        private UUID RFCOMM = UUID.fromString("00000000-0000-0000-0000-000123456789");
        private String BT_NAME = "BLUETOOTH_GAME_GUESS_WHO";
        private BluetoothServerSocket mserverSocket;

        public BTConnection() {
            madapter = BluetoothAdapter.getDefaultAdapter();
            BluetoothServerSocket temp = null;
            try {
                temp = madapter.listenUsingRfcommWithServiceRecord(BT_NAME, RFCOMM);
            } catch (IOException e) {
                System.out.println("No connection");
            }
            mserverSocket = temp;
        }

        public void ConnectThread(BluetoothDevice device) {
            BluetoothSocket tmp = null;
            mmDevice = device;
            try {

                tmp = device.createRfcommSocketToServiceRecord(RFCOMM);
            } catch (IOException e) {
                System.out.println("No connection");
            }
            mmSocket = tmp;
        }

        public void run() {
            madapter.cancelDiscovery();
            BluetoothSocket socket = null;

            while (true) {
                try {
                    System.out.println("Server is listening");
                    socket = mserverSocket.accept();
                } catch (IOException e) {

                }
                if (socket != null) {
                    System.out.println("Connection to device with mac address: " +
                            socket.getRemoteDevice().getAddress() + " has been created!");
                    break;
                }
            }
        }

        // Closes the connect socket and causes the thread to finish.
        public void cancel() {
            try {
                mserverSocket.close();
            } catch (IOException e) {
            }
        }

    }
    */
}
