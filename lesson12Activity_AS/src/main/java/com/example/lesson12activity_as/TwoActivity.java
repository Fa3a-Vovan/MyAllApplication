package com.example.lesson12activity_as;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TwoActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "myLogs";
    TextView textView;
    EditText editText;
    Button button, button2;
    int k = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_activity);

        Log.d(TAG, "Two k="+k);
        Intent intent = getIntent();
        k=intent.getIntExtra("k", k);
        Log.d(TAG, "Two k="+k);

        textView = findViewById(R.id.text);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        textView.setText("Two"+k);

    }

    @Override
    protected void onStart() {
        Log.d(TAG, "TwoActivity onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "TwoActivity onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "TwoActivity onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "TwoActivity onStop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "TwoActivity onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "TwoActivity Destroy");
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        k++;
        Intent intent = null;
        textView.setText(editText.getText()+""+k);
        switch (v.getId()){
            case R.id.button: intent = new Intent(this, MainActivity.class); break;
            case R.id.button2: intent = new Intent(this, OneActivity.class); break;
        }
        intent.putExtra("k", k);
        startActivity(intent);
    }
}