package com.example.lesson21sdbqlitepad;

import androidx.appcompat.app.AppCompatActivity;

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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "myLogs";
    TextView textView1, textView2;
    EditText editText2;
    Button button1, button2, button3, button4;

    DBHelper dbHelper;                  //позволяет создавать, открывать и обновлять базы данных
    SQLiteDatabase database;            //управление базой данных SQLite
    Cursor cursor;                      //считывает в себя таблицу БД для работы
    ContentValues contentValues;        //используеться для добавления новых строк в таблицу
    HelperMethodClass helperMethodClass = new HelperMethodClass(); // Класс вспомагательных методов
    String nameDB = "cooking.db";
    String SQLZapros = "create table if not exists mytable (_id integer primary key autoincrement, _razdel text);";
    int tekString = 0;  //переменная костыль, показывающая номер текущей строки в таблице

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);// Текущий активный раздел для выбора
        editText2 = findViewById(R.id.editText2);//имя нового раздела
        button1 = findViewById(R.id.button1); button1.setOnClickListener(this);//выбор разделов
        button2 = findViewById(R.id.button2); button2.setOnClickListener(this);//выбрать раздел и перейти в OneActivity
        button3 = findViewById(R.id.button3); button3.setOnClickListener(this);//выбрать раздел и удалить его
        button4 = findViewById(R.id.button4); button4.setOnClickListener(this);//добавить раздел
        helperMethodClass.onCreateDB(this, nameDB, SQLZapros); //Создаем БД
        textView1.setText(helperMethodClass.onReadDataFromFieldTable(this, nameDB, "mytable", "_razdel"));//вывод всех данных столбца на экран
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1://Перебор сузествующих в таблице данных (торты, салаты, пироги и т.д.)
                tekString = helperMethodClass.onViewDataFromTable(this, nameDB, "mytable", "_razdel", tekString, textView2);
                tekString++;
                Log.d(TAG, "tekString = " + tekString);
                break;
//            case R.id.button2: Intent intent = new Intent(this, OneActivity.class); startActivity(intent); finish(); break;
            case R.id.button3://Удаление текущей позиции вкусностей
                helperMethodClass.onDeleteStringTable(this, nameDB, "mytable", --tekString);
                textView2.setText("Перебор разделов"); tekString = 0;
                //Вывод всех данных столбца на экран после удаления
                textView1.setText(helperMethodClass.onReadDataFromFieldTable(this, nameDB, "mytable", "_razdel"));
                break;
            case R.id.button4://Добавление новых групп вкусностей
                helperMethodClass.onCreateNoteInTable(this, nameDB, "mytable", editText2.getText().toString());
                //Вывод всех данных столбца на экран
                textView1.setText(helperMethodClass.onReadDataFromFieldTable(this, nameDB, "mytable", "_razdel"));//вывод всех данных столбца на экран
            break;
        }
    }
}