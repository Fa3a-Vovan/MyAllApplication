package com.example.lesson7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
String TAG = "myLog";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "create");

        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onResume() {
        Log.d(TAG, "resume");
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d(TAG, "onCreateOptionsMenu");
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.action_settings1){
            Log.d(TAG, "1");

            return true;
        }else if(item.getItemId()==R.id.action_settings2){
            Log.d(TAG, "2");

            return true;
        }
        Log.d(TAG, "3");

        return super.onOptionsItemSelected(item);
    }
}