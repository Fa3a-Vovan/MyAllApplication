package com.example.lesson02normal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editA;
    EditText editB;
    EditText editC;
    Button button;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editA = findViewById(R.id.et_set_a);
        editB = findViewById(R.id.et_set_b);
        editC = findViewById(R.id.et_set_c);
        button = findViewById(R.id.button);
        result = findViewById(R.id.result);

        Logic logic = new Logic();

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Entity entity = new Entity();
                try {
                    logic.setEntityA(entity, editA.getText().toString());
                    logic.setEntityB(entity, editB.getText().toString());
                    logic.setEntityC(entity, editC.getText().toString());
                } catch (NumberFormatException e) {
                    result.setText(e.toString());
                }
                result.setText(logic.howManyRootsOfExpression(entity));
            }
        };

        button.setOnClickListener(listener);
    }
}