package ovh.crow.guesswho;

import android.app.Application;

import org.greenrobot.greendao.database.Database;
import ovh.crow.guesswho.DaoMaster.DevOpenHelper;

/**
 * Created by Frederik Mazur Andersen on 20-03-2017.
 */

public class App extends Application {

    //Encrypted db?
    public static final boolean ENCRYPTED = false;

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DevOpenHelper helper = new DevOpenHelper(this, ENCRYPTED ? "guesswho-db-encrypted" : "guesswho-db");
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
