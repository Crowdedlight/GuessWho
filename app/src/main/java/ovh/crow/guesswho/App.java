package ovh.crow.guesswho;

import android.app.Application;

import org.greenrobot.greendao.database.Database;
import ovh.crow.guesswho.DaoMaster.DevOpenHelper;

/**
 * Created by Frederik Mazur Andersen on 20-03-2017.
 */

public class App extends Application {

    private DaoSession daoSession;
    private DevOpenHelper helper;

    @Override
    public void onCreate() {
        super.onCreate();

        helper = new DevOpenHelper(this, "guesswho-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
    public DevOpenHelper getHelper() {
        return helper;
    }
}
