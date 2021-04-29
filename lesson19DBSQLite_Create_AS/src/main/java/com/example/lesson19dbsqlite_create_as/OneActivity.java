package com.example.lesson19dbsqlite_create_as;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OneActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "myLogs";
    TextView textView3, textView4, textView5;
    EditText editText, editText2, editText3, editText4, editText6;
    Button button3, button4, button5, button6, button7, button8;

    DBHelper dbHelper;              //позволяет создавать, открывать и обновлять базы данных
    SQLiteDatabase database;        //управление базой данных SQLite
    Cursor cursor;                  //считывает в себя таблицу БД для работы
    ContentValues contentValues;    //используется для добавления новых строк в таблицу

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        editText6 = findViewById(R.id.editText6);
        button3 = findViewById(R.id.button3); button3.setOnClickListener(this);
        button4 = findViewById(R.id.button4); button4.setOnClickListener(this);
        button5 = findViewById(R.id.button5); button5.setOnClickListener(this);
        button6 = findViewById(R.id.button6); button6.setOnClickListener(this);
        button7 = findViewById(R.id.button7); button7.setOnClickListener(this);
        button8 = findViewById(R.id.button8); button8.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button3: textView3.setText(
                        onReadDataFromFieldTable(editText.getText().toString(), editText2.getText().toString(), editText3.getText().toString()));
                break;
            case R.id.button4: textView4.setText(
                        onReadDataFromStringTable(editText.getText().toString(), editText2.getText().toString(), editText4.getText().toString()));
                break;
            case R.id.button5: textView5.setText(onReadDataFromCellTable(editText.getText().toString(),
                        editText2.getText().toString(), editText3.getText().toString(), editText4.getText().toString()));
                break;
            case R.id.button6:
                onSaveNewDataCellTable(editText.getText().toString(), editText2.getText().toString(),
                        editText3.getText().toString(), editText4.getText().toString(), editText6.getText().toString());
                break;
            case R.id.button7:
                onDeleteStringTable(editText.getText().toString(), editText2.getText().toString(), editText4.getText().toString());
                break;
            case R.id.button8:
                onSelectIntentMain();
                break;
        }
    }

    @SuppressLint("WrongConstant")
    String onReadDataFromFieldTable(String nameDB, String nameTableDB, String nameField) {
        Log.d(TAG, "onReaderDataFieldTable");
        ////////---Открываем БД для определения версии---//////
        database = openOrCreateDatabase(nameDB, SQLiteDatabase.CREATE_IF_NECESSARY, null);
        int version = database.getVersion();
        database.close();
        Log.d(TAG, "version = " + version);
        ///////---Открываем БД для считываения данных из таблицы---////////
        dbHelper = new DBHelper(this, nameDB, null, version, null);
        try {
            database = dbHelper.getWritableDatabase(); Log.d(TAG, "writDB");
        } catch (SQLiteException e) {database = dbHelper.getReadableDatabase(); Log.d(TAG, "readDB"); }
        //////---Читаем данные из поля таблицы---////////
        String str = "";
        cursor = database.query(nameTableDB, null, null, null, null, null, null);
        if (cursor.moveToFirst()){
            do {
                Log.d(TAG, "cursor.getColumnIndex(nameField);=" + cursor.getColumnIndex(nameField));
                str = str + " " + cursor.getString(cursor.getColumnIndex(nameField));
            } while (cursor.moveToNext());
        }
        Log.d(TAG, "Все записи столбца = " + str);
        cursor.close();     dbHelper.close();       database.close();
        return str;
    }

    @SuppressLint("WrongConstant")
    String onReadDataFromStringTable(String nameDB, String nameTableDB, String numberString) {
        Log.d(TAG, "onReadDataFromStringTable");
        ///////---Открываем БД для определения версии---////////
        database = openOrCreateDatabase(nameDB, SQLiteDatabase.CREATE_IF_NECESSARY, null);
        int version = database.getVersion();
        database.close();
        Log.d(TAG, "version = " + version);
        ///////---Открываем БД для считываения данных из таблицы---///////
        dbHelper = new DBHelper(this, nameDB, null, version, null);
        try {
            database = dbHelper.getWritableDatabase(); Log.d(TAG, "writeDB");
        } catch (SQLiteException e) {dbHelper.getReadableDatabase(); Log.d(TAG, "readDB"); }
        ///////---Читаем данные из поля таблицы---///////
        String str = "";
        cursor = database.query(nameTableDB, null, null, null, null, null, null);
        if (cursor.moveToPosition(Integer.parseInt(numberString))){
            for (String field : cursor.getColumnNames()){
                str = str + cursor.getString(cursor.getColumnIndex(field)) + " ";
            }
        }
        Log.d(TAG, "Все записи строки = " + str);
        cursor.close(); database.close(); dbHelper.close();
        return str;
    }

    @SuppressLint("WrongConstant")
    String onReadDataFromCellTable(String nameDB, String nameTableDB, String nameField, String numberString) {
        Log.d(TAG, "onReadDataFromCellTable");
        ///////---Открываем БД для считывания данных из таблицы---////////
        database = openOrCreateDatabase(nameDB, SQLiteDatabase.CREATE_IF_NECESSARY, null);
        int version = database.getVersion();
        database.close();
        Log.d(TAG, "version = " +version);
        //////---Открываем БД для считываения данных из таблицы---/////////
        dbHelper = new DBHelper(this, nameDB, null, version, null);
        try {
            database = dbHelper.getWritableDatabase(); Log.d(TAG, "writeDB");
        } catch (SQLiteException e) {database = dbHelper.getReadableDatabase(); Log.d(TAG, "readDB"); }
        /////////---Чиатем данные из поля таблицы---///////
        String str = "";
        cursor = database.query(nameTableDB, null, null, null, null, null, null);
        if (cursor.moveToPosition(Integer.parseInt(numberString))){
            str = str + cursor.getString(cursor.getColumnIndex(nameField));
        }
        Log.d(TAG, "Ячейка содержит = " + str);
        cursor.close();     database.close();       dbHelper.close();
        return str;
    }

    @SuppressLint("WrongConstant")
    void onSaveNewDataCellTable(String nameDB, String nameTableDB, String nameField, String numberString, String newDataCell) {
        Log.d(TAG, "onSaveNewDataCellTable");
        ///////---Открываем БД для определения версии---///////////
        database = openOrCreateDatabase(nameDB, SQLiteDatabase.CREATE_IF_NECESSARY, null);
        int version = database.getVersion();
        database.close();
        Log.d(TAG, "version = " + version);
        /////---Открываем БД для считывания данных из таблицы---///////
        dbHelper = new DBHelper(this, nameDB, null, version, null);
        try {
            database = dbHelper.getWritableDatabase(); Log.d(TAG, "writeDB");
        } catch (SQLiteException e) {database = dbHelper.getReadableDatabase(); Log.d(TAG, "readDB"); }
        ////////---Записываем новые данные в ячейку таблицы0---///////////
        contentValues = new ContentValues();
        contentValues.put(nameField, newDataCell);
        cursor = database.query(nameTableDB, null, null, null, null, null,null);
        if (cursor.moveToPosition(Integer.parseInt(numberString))) {
            database.update(nameTableDB, contentValues, "_id = " + cursor.getString(0), null);
        }
    }

    @SuppressLint("WrongConstant")
    void onDeleteStringTable(String nameDB, String nameTableDB, String numberString) {
        Log.d(TAG, "onDeleteStringTable");
        ////////---Открываем БД для определения версии---////////
        database = openOrCreateDatabase(nameDB, SQLiteDatabase.CREATE_IF_NECESSARY, null);
        int version = database.getVersion();
        database.close();
        Log.d(TAG, "version = " + version);
        ///////---Открываем бд для считывания данных из таблицы---//////////
        dbHelper = new DBHelper(this, nameDB, null, version, null);
        try {
            database = dbHelper.getWritableDatabase(); Log.d(TAG, "writeDB");
        } catch (SQLiteException e) {database = dbHelper.getReadableDatabase(); Log.d(TAG, "readDB");}
        ////////---Удаляем строку из таблицы---/////////
        cursor = database.query(nameTableDB, null, null, null, null, null, null);
        if (cursor.moveToPosition(Integer.parseInt(numberString))){
            database.delete(nameTableDB, "_id = " + cursor.getString(0), null);
        }


    }

    void onSelectIntentMain() {
        Log.d(TAG, "onSelectIntentMain");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
