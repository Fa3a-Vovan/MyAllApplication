package com.example.lesson19dbsqlite_create_as;

import androidx.appcompat.app.AppCompatActivity;

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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "myLogs";
    EditText editText, editText2, editText3, editText4;
    Button button, button2, button3, button4, button5, button6;

    DBHelper dbHelper;              //Позволяет создавать, открывать и обновлять базы данных
    SQLiteDatabase database;        //управление базой данных SQLite
    Cursor cursor;                  //Считивает в себя таблицу БД для работы
    ContentValues contentValues;    //используется для добавления новых строк в таблицу

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "MainActivityonCreate");
        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        button = findViewById(R.id.button);   button.setOnClickListener(this);
        button2 = findViewById(R.id.button2); button2.setOnClickListener(this);
        button3 = findViewById(R.id.button3); button3.setOnClickListener(this);
        button4 = findViewById(R.id.button4); button4.setOnClickListener(this);
        button5 = findViewById(R.id.button5); button5.setOnClickListener(this);
        button6 = findViewById(R.id.button6); button6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button: onCreateDB(editText.getText().toString()); break;
            case R.id.button2: onCreateTable(editText.getText().toString(), editText2.getText().toString(), editText3.getText().toString()); break;
            case R.id.button3: onSaveData(editText.getText().toString(), editText2.getText().toString(), editText4.getText().toString()); break;
            case R.id.button4: onDeleteTable(editText.getText().toString(), editText2.getText().toString()); break;
            case R.id.button5: onDeleteDB(editText.getText().toString()); break;
            case R.id.button6: onSelectIntentOne(); break;
        }
    }

    void onCreateDB(String nameDB){
        Log.d(TAG, "onCreateDB");
        String SQLZapros = "create table mytable (_id integer primary key autoincrement, _a1 text, _a2 text);";
        dbHelper = new DBHelper(this, nameDB, null, 1, SQLZapros);
        try {
            database = dbHelper.getWritableDatabase();
        } catch (SQLiteException e) {database = dbHelper.getReadableDatabase(); }
        dbHelper.close();   database.close();
    }

    @SuppressLint("WrongConstant")
    void onCreateTable(String nameDB, String nameTableDB, String structTableDB){
        Log.d(TAG, "onCreateTable");
        String SQLZapros = "create table " + nameTableDB + "(_id integer primary key autoincrement";
        String [] result = structTableDB.split(" "); //разбираем структуру вбитую пользователем по пробелам и помещаем в масив
        for (String x:result) {SQLZapros = SQLZapros + ", " + x + " text"; }
        SQLZapros = SQLZapros + ");";
        Log.d(TAG, "SQLZapros = " + SQLZapros + "  size = " + SQLZapros.length());
        //////////-----Открываем БД для определени версии-----//////////
        database = openOrCreateDatabase(nameDB, SQLiteDatabase.CREATE_IF_NECESSARY, null);
        int version = database.getVersion();
        Log.d(TAG, "version = " + version);
        version++;
        database.close();
        //////-----Создаем новую таблицу по структуре запроса-----/////
        dbHelper = new DBHelper(this, nameDB, null, version, SQLZapros);
        try {
            database = dbHelper.getWritableDatabase(); Log.d(TAG, "writeDB");
        } catch (SQLiteException e) {database = dbHelper.getReadableDatabase(); Log.d(TAG, "readDB");}
        dbHelper.close(); database.close();
    }

    @SuppressLint("WrongConstant")
    void onSaveData(String nameDB, String nameTableDB, String dataForTableDB){
        Log.d(TAG, "onSaveData");
        //////---Открываем БД для определения версии---///////
        database = openOrCreateDatabase(nameDB, SQLiteDatabase.CREATE_IF_NECESSARY, null);
        int version = database.getVersion();
        Log.d(TAG, "version = " + version);
        database.close();
        ///////---Заносим данные в таблицу---///////
        dbHelper = new DBHelper(this, nameDB, null, version, null);
        try {
            database = dbHelper.getWritableDatabase(); Log.d(TAG, "writeDB");
        } catch(SQLiteException e) {database = dbHelper.getReadableDatabase(); Log.d(TAG, "readDB");}
        //////---Заносим данные в таблицу---///////
        cursor = database.query(nameTableDB, null, null, null, null, null, null);
        String [] data = dataForTableDB.split(" ");
        contentValues = new ContentValues();
        for (int i = 1; i<=data.length; i++)
        {
            contentValues.put(cursor.getColumnName(i), data[i-1] );
            Log.d(TAG, "cursor.getColumnName(i) = " + cursor.getColumnName(i) + "   data[i-1] = " + data[i-1]);
        }
        //database.insert(nameTableDB, null, contentValues) - записывает в таблицу строку с накопленными данными
        Log.d(TAG, "Nomer zapisi = " +database.insert(nameTableDB, null, contentValues));
        cursor.close();     dbHelper.close();   database.close();
    }

    @SuppressLint("WrongConstant")
    void onDeleteTable(String nameDB, String nameTableDB){
        Log.d(TAG, "onDeleteTable");
        String SQLZapros = "DROP TABLE IF EXISTS " + nameTableDB;
        ////---Открываем БД для определения версии---///////
        database = openOrCreateDatabase(nameDB, SQLiteDatabase.CREATE_IF_NECESSARY, null);
        int version = database.getVersion();
        Log.d(TAG, "version = " + version);
        version++;
        database.close();
        ////////---Создаем новую таблицу по структуре запроса---////////
        dbHelper = new DBHelper(this, nameDB, null, version, SQLZapros);
        try {
            database = dbHelper.getWritableDatabase();
        } catch (SQLiteException e) {database = dbHelper.getReadableDatabase(); }
        dbHelper.close(); database.close();
    }

    void onDeleteDB(String nameDB){
        Log.d(TAG, "onDeleteDB");
        this.deleteDatabase(nameDB);
    }

    void onSelectIntentOne(){
        Log.d(TAG, "onSelectIntentOne");
        Intent intent = new Intent(this, OneActivity.class);
        startActivity(intent);
        finish();
    }
}