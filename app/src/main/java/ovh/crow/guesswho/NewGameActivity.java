package ovh.crow.guesswho;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.util.UUID;

public class NewGameActivity extends AppCompatActivity {

    /* Makes the app visible to others. (Server) */

    private App btSD = new App();
    BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

        btSD = (App)getApplication();

        Intent discoverableIntent =
                new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
        startActivity(discoverableIntent);

        new NewATConnection().execute();
    }

    public void startGame(){
        Intent playingActivity = new Intent(this, PlayingActivity.class);
        startActivity(playingActivity);
    }

    private class NewATConnection extends AsyncTask<String, Void, BluetoothSocket> {

        private UUID RFCOMM_UUID = UUID.fromString("00000000-0000-0000-0000-000123456789");
        private String BT_NAME = "BLUETOOTH_GAME_GUESS_WHO";
        private BluetoothAdapter mAdapter;
        private BluetoothServerSocket mmServerSocket;

        public NewATConnection() {
            mAdapter = BluetoothAdapter.getDefaultAdapter();
            BluetoothServerSocket tmp = null;
            try {
                tmp = mAdapter.listenUsingRfcommWithServiceRecord(BT_NAME, RFCOMM_UUID);
            } catch (IOException e) {
            }
            mmServerSocket = tmp;
        }
        @Override
        protected BluetoothSocket doInBackground(String... params) {
            mAdapter.cancelDiscovery();
            BluetoothSocket socket = null;
            while (socket == null) {
                try {
                    System.out.println("Server is listening");
                    socket = mmServerSocket.accept();
                } catch (IOException e) {
                    break;
                }
                if (socket != null) {
                    System.out.println("Connection to device with mac address: " + socket.getRemoteDevice().getAddress() + " has been created!");
                    return socket;
                }
            }
            return null;
        }
        @Override
        protected void onPostExecute(BluetoothSocket socket) {
            btSD.setBtClientSocket(socket);
            btSD.setBtClientMac(socket.getRemoteDevice().getAddress());
            btSD.setBtServerMac(adapter.getAddress());
            btSD.setGameStarter(true);
            startGame();
        }
    }
}
