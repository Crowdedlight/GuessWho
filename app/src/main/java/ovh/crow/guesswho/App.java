package ovh.crow.guesswho;

import android.app.Application;
import android.bluetooth.BluetoothSocket;

import org.greenrobot.greendao.database.Database;
import ovh.crow.guesswho.DaoMaster.DevOpenHelper;

/**
 * Created by Frederik Mazur Andersen on 20-03-2017.
 */

public class App extends Application {

    private DaoSession daoSession;
    private DevOpenHelper helper;

    private BluetoothSocket btServerSocket;
    private BluetoothSocket btClientSocket;
    private String btServerMac;
    private String btClientMac;

    private boolean gameStarter;        // True = player 1 (first to guess). false = player 2

    @Override
    public void onCreate() {
        super.onCreate();

        helper = new DevOpenHelper(this, "guesswho-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public String getBtServerMac() {
        return btServerMac;
    }
    public String getBtClientMac() {
        return btClientMac;
    }
    public BluetoothSocket getBtServerSocket() {
        return btServerSocket;
    }
    public BluetoothSocket getBtClientSocket() { return btClientSocket; }
    public void setBtServerMac(String btServerMac) {
        this.btServerMac = btServerMac;
    }
    public void setBtClientMac(String btClientMac) {
        this.btClientMac = btClientMac;
    }
    public void setBtServerSocket(BluetoothSocket btSSocket) { this.btServerSocket = btSSocket; }
    public void setBtClientSocket(BluetoothSocket btCSocket) { this.btClientSocket = btCSocket; }

    public DaoSession getDaoSession() {
        return daoSession;
    }
    public DevOpenHelper getHelper() {
        return helper;
    }

    public void setGameStarter(boolean b) { this.gameStarter = b; }
    public boolean getGameStarter() { return gameStarter; }
}
