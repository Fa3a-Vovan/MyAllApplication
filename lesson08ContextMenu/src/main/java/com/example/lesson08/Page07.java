package com.example.lesson08;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Page07 extends AppCompatActivity //implements View.OnClickListener
{
    public static final int cm1 = 1;
    public static final int cm11 = 11;
    public static final int cm12 = 12;
    public static final int cm2 = 2;
    public static final int cm3 = 3;
    public static final int cmB = 4;
    public static final int cmL = 5;
    public static final int cmOUT = 6;
    Button button;
    EditText editText;
    TextView out;
    LinearLayout linearLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = findViewById(R.id.new_text);
        registerForContextMenu(textView);
        editText = findViewById(R.id.edit_text);
        registerForContextMenu(editText);
        button = findViewById(R.id.button);
        registerForContextMenu(button);
        out = findViewById(R.id.result);
        registerForContextMenu(out);
        linearLayout = findViewById(R.id.linear_layout);
        registerForContextMenu(linearLayout);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };
        button.setOnClickListener(onClickListener);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        switch (v.getId()) {
            case R.id.new_text:
//                menu.add(Menu.NONE, cm1, Menu.NONE, "Выбран TextView");
                SubMenu subMenu = menu.addSubMenu(Menu.FIRST, cm1, Menu.NONE, "Выбран TextView");
                subMenu.add(Menu.FIRST, cm11, Menu.NONE, "Выбран подпункт TextView 1");
                subMenu.add(Menu.FIRST, cm12, Menu.NONE, "Выбран подпункт TextView 2");
                menu.add(Menu.NONE, cm3, Menu.NONE, "Выйти из приложения");
                break;
            case R.id.edit_text:
                menu.add(Menu.NONE, cm2, Menu.NONE, "Выбран EditText");
                menu.add(Menu.NONE, cm3, Menu.NONE, "Выйти из приложения");
                break;
            case R.id.button:
                menu.add(Menu.NONE, cmB, 2, "Выбрана кнопка");
                menu.add(Menu.NONE, cm3, 1, "Выйти из приложения");
                break;
            case R.id.linear_layout:
                menu.add(Menu.NONE, cmL, Menu.NONE, "Выбран LinearLayout");
                menu.add(Menu.NONE, cm3, Menu.NONE, "Выйти из приложения");
                break;
            case R.id.result:
                menu.add(Menu.NONE, cmOUT, Menu.NONE, "Выбран OUT");
                menu.add(Menu.NONE, cm3, Menu.NONE, "Выйти из приложения");
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        CharSequence cm = "";
        switch (item.getItemId()) {
            case cm1: cm = "Выбран пункт возвратиться из TextView"; break;
            case cm11: cm = "Выбран ПОДпункт1 возвратиться из TextView"; break;
            case cm12: cm = "Выбран ПОДпункт2 возвратиться из TextView"; break;

            case cm2: cm = "Выбран пункт возвратиться из EditText"; break;
            case cm3: finish(); break;
            case cmB: cm = "Выбран пункт возвратиться из Button"; break;
            case cmL: cm = "Выбран пункт возвратиться из LinearLayout"; break;
            case cmOUT: cm = "Выбран пункт возвратиться из OUT"; break;
        }
        out.setText(cm);
        return true;
    }
}