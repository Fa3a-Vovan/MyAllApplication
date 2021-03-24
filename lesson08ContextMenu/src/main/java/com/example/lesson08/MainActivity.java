package com.example.lesson08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.new_text);
        TextView textView1 = findViewById(R.id.new_text1);
        TextView textView2 = findViewById(R.id.new_text2);
        EditText editText = findViewById(R.id.edit_text);
        out = findViewById(R.id.result);
        Button button = findViewById(R.id.button);
        LinearLayout linearLayout = findViewById(R.id.linear_layout);
//        registerForContextMenu(button);
        registerForContextMenu(textView);
        registerForContextMenu(textView1);
        registerForContextMenu(textView2);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.context_menu, menu);
        switch (v.getId()) {
            case R.id.new_text:
                inflater.inflate(R.menu.context_menu, menu);
                break;
            case R.id.new_text1:
                inflater.inflate(R.menu.context_menu1, menu);
                break;
            case R.id.new_text2:
                inflater.inflate(R.menu.context_menu2, menu);
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.contextSolve: return true;
            case R.id.contextExit:finish();return true;
            case R.id.file1: return true;
            case R.id.vibor1: out.setText("vibor1"); return true;
            case R.id.vihod1: finish(); return true;
            case R.id.file2: return true;
            case R.id.vibor2: out.setText("vibor1"); return true;
            case R.id.vihod2: finish(); return true;
            default:return super.onContextItemSelected(item);
        }
    }
}