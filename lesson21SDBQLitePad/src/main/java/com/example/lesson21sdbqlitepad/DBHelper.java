package com.example.lesson21sdbqlitepad;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    private static final String TAG = "myLogs";
    String SQLZapros;
    public DBHelper(Context context, String nameDB, SQLiteDatabase.CursorFactory factory,
                    int version, String SQLZapros) {
        super(context, nameDB, null, version); Log.d(TAG, "super");
        this.SQLZapros = SQLZapros;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLZapros); Log.d(TAG, "onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQLZapros); Log.d(TAG, "onUpgrade");
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "onDowngrade");
    }
}
