package com.example.lesson17xmlpref;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "myLogs";
    TextView textView4;
    EditText editText, editText2, editText3;
    Button button, button2, button3, button4, button5;
    SharedPreferences sPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "MainActivityOncreated Заготовка:");

        textView4 = findViewById(R.id.textView4);
        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        button  = findViewById(R.id.button);  button.setOnClickListener(this);
        button2 = findViewById(R.id.button2); button2.setOnClickListener(this);
        button3 = findViewById(R.id.button3); button3.setOnClickListener(this);
        button4 = findViewById(R.id.button4); button4.setOnClickListener(this);
        button5 = findViewById(R.id.button5); button5.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button:  onCreateXMLFile(editText.getText().toString()); break;
            case R.id.button2: onSaveData(editText.getText().toString(), editText2.getText().toString(), editText3.getText().toString()); break;
            case R.id.button3: textView4.setText(onReadData(editText.getText().toString(), editText2.getText().toString())); break;
            case R.id.button4: onDeleteData(editText.getText().toString(), editText2.getText().toString()); break;
            case R.id.button5: onDeleteXMLFile(editText.getText().toString()); break;
        }
    }
    void onCreateXMLFile (String XMLFile){
        Log.d(TAG, "onCreateXMLFile");
        SharedPreferences sPref = getSharedPreferences(XMLFile, this.MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        editor.apply();
        Log.d(TAG, "Создан файл: " + XMLFile);
    }

    void onSaveData (String XMLFile, String nameKey, String data) {
        Log.d(TAG, "onSaveData");
        SharedPreferences sPref = getSharedPreferences(XMLFile, this.MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        editor.putString(nameKey, data);
        editor.apply();

        Log.d(TAG, "Данный сохраныне в файл: " + XMLFile + "/nКлюч: " + nameKey + "/nДанные: " + data);
    }

    String onReadData (String XMLFile, String nameKey){
        Log.d(TAG, "onReadData: " + nameKey);
        SharedPreferences sPref = getSharedPreferences(XMLFile, MODE_PRIVATE);
        return sPref.getString(nameKey, "");
    }

    void onDeleteData (String XMLFile, String nameKey){
        Log.d(TAG, "onDeleteData");
        SharedPreferences sPref = getSharedPreferences(XMLFile, MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        editor.remove(nameKey);
        editor.apply();
    }

    void onDeleteXMLFile (String XMLFIle){
        Log.d(TAG, "onDeleteXMLFile");
        String filePath = getApplicationContext().getFilesDir().getParent()+"/shared_prefs/"+XMLFIle+".xml";
        File deletePrefFile = new File(filePath);
        deletePrefFile.delete();
    }
}