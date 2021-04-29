package com.example.lesson21sdbqlitepad;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.widget.TextView;

public class HelperMethodClass {
    private static final String TAG = "myLogs";
    DBHelper dbHelper;                  //позволяет создавать, открывать и обновлять базы данных
    SQLiteDatabase database;            //управление базой данных SQLite
    Cursor cursor;                      //считывает в себя таблицу БД для работы
    ContentValues contentValues;        //используется для добавления новых строк в таблицу

    void onCreateDB(Context context, String nameDB, String SQLZapros) {
        Log.d(TAG, "onCreateDB");
        DBHelper dbHelper = new DBHelper(context, nameDB, null, 1, SQLZapros);
        try {
            database = dbHelper.getWritableDatabase();
        } catch (SQLiteException e) {database = dbHelper.getReadableDatabase();}
        dbHelper.close();   database.close();
    }
    @SuppressLint("WrongConstant")
    void onCreateNoteInTable (Context context, String nameDB, String nameTable, String dataRazdel){
        Log.d(TAG, "onCreateNoteInTable");
        /////---Открываем БД для определения версии---///////
        database = context.openOrCreateDatabase(nameDB, SQLiteDatabase.CREATE_IF_NECESSARY, null);
        int version = database.getVersion();
        database.close();
        Log.d(TAG, "version = " + version);
        ////////---Открываем БД для внесения данных в таблицу---////////
        dbHelper = new DBHelper(context, nameDB, null, version, null);
        try {
            database = dbHelper.getWritableDatabase(); Log.d(TAG, "writeDB");
        } catch (SQLException e) {database = dbHelper.getReadableDatabase(); Log.d(TAG, "readDB"); }
        ///////---Заносим данные в таблицу---//////////
//        cursor = database.query(nameTable, null, null, null, null, null, null);
        contentValues = new ContentValues();
        contentValues.put("_razdel", dataRazdel);
        Log.d(TAG, "Nomer zapisi = " + database.insert(nameTable, null, contentValues));
        cursor.close();     dbHelper.close();       database.close();
    }
    @SuppressLint("WrongConstant")
    String onReadDataFromFieldTable(Context context, String nameDB, String nameTableDB, String nameField) {
        Log.d(TAG, "onREadDataFromFieldTable");
        ////////---Открываем БД для определения версии---/////////
        database = context.openOrCreateDatabase(nameDB, SQLiteDatabase.CREATE_IF_NECESSARY, null);
        int version = database.getVersion();
        database.close();
        Log.d(TAG, "version = " + version);
        //////////---Открываем БД для считываения данных из таблицы---///////
        dbHelper = new DBHelper(context, nameDB, null, version, null);
        try {
            database = dbHelper.getWritableDatabase();
            Log.d(TAG, "writeDB");
        } catch (SQLException e) {
            database = dbHelper.getReadableDatabase();
            Log.d(TAG, "readDB");
        }
        ///////---Читанем данные из поля таблицы---/////////
        String str = "";
        cursor = database.query(nameTableDB, null, null, null, null, null, null);
        if (cursor.moveToFirst()){
            do {
//                cursor.getColumnIndex(nameField);//как бы и не нужно в холостую юзать
                Log.d(TAG, "cursor.getColumnIndex(nameField); = " + cursor.getColumnIndex(nameField));
                str = str + "\n" + cursor.getString(cursor.getColumnIndex(nameField));
            } while (cursor.moveToNext());
        }
        Log.d(TAG, "Все записи столбца = " + str);
        cursor.close();     dbHelper.close();       database.close();
        return str;
    }

    @SuppressLint("WrongConstant")
    int onViewDataFromTable (Context context, String nameDB, String nameTable, String nameField, int tekString, TextView textView) {
        Log.d(TAG, "onViewDataFromTable");
        /////////---Открываем БД для определения версии---//////////
        database = context.openOrCreateDatabase(nameDB, SQLiteDatabase.CREATE_IF_NECESSARY, null);
        int version = database.getVersion();
        database.close();
        Log.d(TAG, "version = " + version);
        ////////---Открываем БД для считывания данных из таблицы---///////
        dbHelper = new DBHelper(context, nameDB, null, version, null);
        try {
            database = dbHelper.getWritableDatabase(); Log.d(TAG, "writeDB");
        } catch (SQLException e) {database = dbHelper.getReadableDatabase(); Log.d(TAG, "readDB"); }
        ////////---Читаем данные из поля таблицы---/////////
        String str = "";
        cursor = database.query(nameTable, null, null, null, null, null, null);
        if (cursor.moveToPosition(tekString)) {
            str = cursor.getString(cursor.getColumnIndex(nameField));
        } else {str = "- Это все -"; tekString = -1; }
        textView.setText(str);
        Log.d(TAG, "Все записи столбца = " + str);
        cursor.close();     dbHelper.close();       database.close();
        return tekString;
    }

    @SuppressLint("WrongConstant")
    void onDeleteStringTable(Context context, String nameDB, String nameTable, int numberString) {
        Log.d(TAG, "onDeleteStringTable");
        /////////---Открываем БД для определения версии---/////////
        database = context.openOrCreateDatabase(nameDB, SQLiteDatabase.CREATE_IF_NECESSARY, null);
        int version = database.getVersion();
        database.close();
        Log.d(TAG, "version = " + version);
        //////---Открываем БД для считывания данных из таблицы---/////////
        dbHelper = new DBHelper(context, nameDB, null, version, null);
        try {
            database = dbHelper.getWritableDatabase(); Log.d(TAG, "writeDB");
        } catch (SQLException e) { database = dbHelper.getReadableDatabase(); Log.d(TAG, "readDB"); }
        ///////---Удаляем строку из таблицы---//////
        cursor = database.query(nameTable, null, null, null, null, null, null);
        if (cursor.moveToPosition(numberString)) {
            database.delete(nameTable, "_id = " + cursor.getString(0), null);
        }
    }
}
