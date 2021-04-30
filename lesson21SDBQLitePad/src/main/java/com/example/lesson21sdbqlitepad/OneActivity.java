package com.example.lesson21sdbqlitepad;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OneActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "myLogs";
    TextView textView0, textView1, textView2;
    EditText editText2;
    Button button1, button2, button3, button4;

    DBHelper dbHelper;                  //позволяет создавать, открывать и обновлять базы данных
    SQLiteDatabase database;            //управление базой данных SQLite
    Cursor cursor;                      //считывает в себя таблицу БД для работы
    ContentValues contentValues;        //используеться для добавления новых строк в таблицу
    HelperMethodClassOne helperMethodClassOne = new HelperMethodClassOne(); // Класс вспомагательных методов
    String nameDB = "cooking.db";
    String myTable = "";//сюда поместим имя таблицы запись ниже тут бесполезна, но есть для наглядности
    String SQLZapros = "create table if not exists "+ myTable + " (_id integer primary key autoincrement, _punkt text, _recept text);";
    int tekString = 0;  //переменная костыль, показывающая номер текущей строки в таблице
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        textView0 = findViewById(R.id.textView0);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);// Текущий активный раздел для выбора
        editText2 = findViewById(R.id.editText2);//имя нового раздела
        button1 = findViewById(R.id.button1); button1.setOnClickListener(this);//выбор разделов
        button2 = findViewById(R.id.button2); button2.setOnClickListener(this);//выбрать раздел и перейти в OneActivity
        button3 = findViewById(R.id.button3); button3.setOnClickListener(this);//выбрать раздел и удалить его
        button4 = findViewById(R.id.button4); button4.setOnClickListener(this);//добавить раздел
        intent = getIntent();
        Log.d(TAG, "tek_razdel = " + intent.getStringExtra("tek_razdel"));
        Log.d(TAG, "tek_id = " + intent.getStringExtra("tek_id"));
        textView0.setText(intent.getStringExtra("tek_razdel"));//Вот вывод переданного вида блюд (торты, салаты и т.д.)
        myTable = "table" + intent.getStringExtra("tek_id"); //вот формируем название таблицы
        SQLZapros = "create table if not exists " + myTable + " (_id integer primary key autoincrement, _punkt text , _recept text);";

        helperMethodClassOne.onCreateDB(this, nameDB, myTable, SQLZapros); //Создаем БД
        textView1.setText(helperMethodClassOne.onReadDataFromFieldTable(this, nameDB, "mytable", "_razdel"));//вывод всех данных столбца на экран
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1://Перебор существующих в таблице данных (торты, салаты, пироги и т.д.)
                tekString = helperMethodClassOne.onViewDataFromTable(this, nameDB, myTable,"_punkt", tekString, textView2);
                tekString++;
                Log.d(TAG, "tekString = " + tekString);
                break;
            case R.id.button2:
                if ((tekString - 1) != -1) {
                    Intent intent = new Intent(this, TwoActivity.class);
                    intent.putExtra("myTable", myTable);
                    Log.d(TAG, "myTable = " + intent.getStringExtra("myTable"));
                    intent.putExtra("tekString","" +(tekString-1));
                    Log.d(TAG, "tekString = " + intent.getStringExtra("tekString"));
                    startActivity(intent);
                    finish();
                }
            case R.id.button3://Удаление текущей позиции вкусностей
                helperMethodClassOne.onDeleteStringTable(this, nameDB, myTable, --tekString);
                textView2.setText("Перебор разделов"); tekString = 0;
                //Вывод всех данных столбца на экран после удаления
                textView1.setText(helperMethodClassOne.onReadDataFromFieldTable(this, nameDB, myTable, "_punkt"));
                break;
            case R.id.button4://Добавление новых групп вкусностей
                helperMethodClassOne.onCreateNoteInTable(this, nameDB, myTable, editText2.getText().toString());
                //Вывод всех данных столбца на экран
                textView1.setText(helperMethodClassOne.onReadDataFromFieldTable(this, nameDB, myTable, "_punkt"));//вывод всех данных столбца на экран
                break;
        }
    }
}