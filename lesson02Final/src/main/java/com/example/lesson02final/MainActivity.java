package com.example.lesson02final;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "myLogs";
    EditText textRead;
    Button button;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative_main);

        textRead = findViewById(R.id.et_text_listener);
        Log.d(TAG, "EditText=" + textRead);
        button = findViewById(R.id.b_button);
        result = findViewById(R.id.tv_result);

        TransformData transform = new TransformData();
        Logic logic = new Logic();
        View.OnClickListener listener = new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                try {
                Entity entity = transform.stringToInts(textRead.getText().toString());
                Log.d(TAG, "entity.a = "+entity.getA());
                result.setText(logic.howManyRootsHaveEquation(entity));
                Log.d(TAG, "a после = "+entity.getA());
                } catch (ArithmeticException e) {
                    textRead.setText("неправильный формат");
                } catch (IndexOutOfBoundsException e) {
                    textRead.setText("Неверное количество переменных");
                } catch (NumberFormatException e) {
                    textRead.setText("NumberFormatException");
                } catch (Exception e) {
                    textRead.setText("неизвестное исключение");
                }
            }
        };
        button.setOnClickListener(listener);
    }
}