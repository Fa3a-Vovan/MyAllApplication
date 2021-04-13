package com.example.lesson14page05;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivityTable extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "myLogs";
    TableLayout tableLayout;
    TableRow[] tableRow;
    Button[] butNew;
    //количество кнопок, полей, столбцов
    final int k = 56, m = 8, n = 7;
    int schet = 0, schetK = 0;
    /////////////////
    Resources res;
    TypedArray icon;

    private static final Integer[] icons = {R.drawable.black,
                                            R.drawable.white};
    //////////////////////
    int[] a = new int [52];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "MainActivityonCreate");

        tableLayout = new TableLayout(this);
        tableRow = new TableRow[m];
        butNew = new Button[k];
        for (int i = 0; i < k; i++) {
            butNew[i] = new Button(this);
            butNew[i].setBackgroundResource(R.drawable.rubashka);
            butNew[i].setOnClickListener(this);
            butNew[i].setId(i);
            butNew[i].setLayoutParams(new TableRow.LayoutParams(20, 85, 1.0f));
        }
        ///////////////////////////
        for (int i = 0; i < m; i++) {
            tableRow[i] = new TableRow(this);
            for (int j = 0; j < n; j++) {
                tableRow[i].addView(butNew[schetK]);
                schetK++;
            }
        }
        for (int i = 0; i < m; i++) {
            tableLayout.addView(tableRow[i]);
        }
        setContentView(tableLayout);
        //////////////
        res = getResources();
        icon = res.obtainTypedArray(R.array.icon);
        /////////////////
        alhoritm();
        Log.d(TAG,""+a);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onClick(View v) {
        if (v.getId()==0){
            butNew[1].setBackgroundResource(icon.getResourceId(a[schet],0));
        }
        if (schet<51){schet++;}
        else {schet=0;}
//        for (int i = 0; i < k; i++) {
//            if (i == v.getId()) {
//                if (schet % 2 == 0) {
//                    butNew[i].setBackgroundResource(icon.getResourceId(0, 0));
//                } else {
//                    butNew[i].setBackgroundResource(icon.getResourceId(1, 0));
//                }
//                schet++;
//            }
//        }
    }

    public void alhoritm(){
        for (int i = 0; i < 52; i++) {

            int i1 = (int) (Math.random()*52);
            for(int j=0; j<=i;j++){
                if (j==i){a[i]=i1;break;}
                if (a[j]==i1){i--;break;}
            }
        }
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.restart:
                Intent intent = getIntent();
                finish();
                startActivity(intent);
                break;
            case R.id.exit:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
