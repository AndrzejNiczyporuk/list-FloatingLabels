package pl.lo3.list;

import android.app.Application;
import android.content.Context;

public class MyApp extends Application {
    public static Integer MAXENTRIES=5; // max entries set to Add. This will be changed with SQLAdapter

    private static Context mContext;

    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getAppContext() {
        return mContext;
    }
}
