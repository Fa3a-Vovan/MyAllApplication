package com.example.lesson04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page12_kr);

        EditText editText = findViewById(R.id.et_editText);
        Button button = findViewById(R.id.b_button);
        TextView result = findViewById(R.id.tv_result);

        Transform transform = new Transform();
        Logic logic = new Logic();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strings[] = new String[2];
                try {
                    strings = transform.stringSeparator(String.valueOf(editText.getText()));
                } catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
                try {
                    result.setText(logic.result(strings[0], logic.arraySort(transform.array(strings[1]))));
                } catch (ArithmeticException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}