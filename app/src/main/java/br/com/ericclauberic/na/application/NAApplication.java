package br.com.ericclauberic.na.application;

import android.app.Application;

import com.facebook.stetho.Stetho;

import br.com.ericclauberic.na.database.DatabaseHelper;

/**
 * Created by eric on 19/08/16.
 */
public class NAApplication extends Application {

    static DatabaseHelper databaseHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        databaseHelper = new DatabaseHelper(this);

        Stetho.initializeWithDefaults(this);

    }

    public static DatabaseHelper getDatabaseHelper() {
        return databaseHelper;
    }
} // FIM
