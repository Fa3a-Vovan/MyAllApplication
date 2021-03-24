package com.example.lesson07kr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lesson07kr.kvadrat.LogicKvadrat;
import com.example.lesson07kr.kvadrat.TransformKvadrat;
import com.example.lesson07kr.sort.LogicSort;
import com.example.lesson07kr.sort.TransformSort;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String TAG = "myLogs";
    TextView task;
    EditText editText;
    Button button;
    TextView textView;

    LogicKvadrat logicKvadrat = new LogicKvadrat();
    TransformKvadrat transformKvadrat = new TransformKvadrat();
    LogicSort logicSort = new LogicSort();
    TransformSort transformSort = new TransformSort();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d(TAG, "createOpt");
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.d(TAG, "ItemOpt");

        switch (item.getItemId()) {
            case R.id.solution:
                solution();
                break;
            case R.id.exit:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        Log.d(TAG, "createCont");

        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Log.d(TAG, "ItemCont");

        switch (item.getItemId()) {
            case R.id.solution: solution(); return true;
            case R.id.exit: finish(); return true;
            default: return super.onContextItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "create");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        task = findViewById(R.id.tv_task_app);
        editText = findViewById(R.id.et_edit_text);
        button = findViewById(R.id.b_button);
        textView = findViewById(R.id.tv_result);
        registerForContextMenu(task);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        solution();
    }

    private void solution() {
        if (String.valueOf(editText.getText()).contains("(")) {
            solutionForSort();
        }
        if (String.valueOf(editText.getText()).contains("a=")) {
            solutionForKvadrat();
        }
    }

    private void solutionForKvadrat() {
        try {
            textView.setText(logicKvadrat.howManyRootsHaveEquation(transformKvadrat.stringToInts(String.valueOf(editText.getText()))));
        } catch (ArithmeticException e) {
            textView.setText("неправильный формат");
        } catch (IndexOutOfBoundsException e) {
            textView.setText("Неверное количество переменных");
        } catch (NumberFormatException e) {
            textView.setText("NumberFormatException");
        } catch (Exception e) {
            textView.setText("неизвестное исключение");
        }
    }

    private void solutionForSort() {
        String strings[] = new String[2];
        try {
            strings = transformSort.stringSeparator(String.valueOf(editText.getText()));
        } catch (IndexOutOfBoundsException e) {
            textView.setText(e.getMessage());
        }
        try {
            textView.setText(logicSort.result(strings[0], logicSort.arraySort(transformSort.stringToDoubleArray(strings[1]))));
        } catch (ArithmeticException e) {
            textView.setText(e.getMessage());
        } catch (NumberFormatException e) {
            textView.setText(e.getMessage());
        } catch (NullPointerException e) {
            textView.setText("NullPointerException");
        } catch (Exception e) {
            textView.setText("Неизвестное исключение");
        }
    }
}