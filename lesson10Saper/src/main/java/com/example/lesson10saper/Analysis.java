package com.example.lesson10saper;

import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class Analysis {

    int quantity;

    private static final String TAG = "myLogs";

    String createGameField(int[][] cageOfField) {
        int numberOfMines = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if ((int) (Math.random() * 100.0) > 80) {
                    cageOfField[i][j] = 1;
                    numberOfMines++;
                }
                Log.d(TAG, "клетка поля[" + i + "][" + j + "]: " + cageOfField[i][j]);
            }
        }
        return "Количество мин на поле: " + numberOfMines;
    }

    void deMine(int height, int width, int[][] cageOfField, Button[][] button) {
        quantity = 0;
        Log.i(TAG,""+cageOfField[height][width]);
        if (height > 0) {
            if (width > 0) {
                numberOfMineNearby(cageOfField[height - 1][width - 1]);
            }
            numberOfMineNearby(cageOfField[height - 1][width]);
            if (width < 3) {
                numberOfMineNearby(cageOfField[height - 1][width + 1]);
            }
        }
        if (width > 0) numberOfMineNearby(cageOfField[height][width - 1]);
        if (width < 3) numberOfMineNearby(cageOfField[height][width + 1]);

        if (height < 3) {
            if (width > 0) {
                numberOfMineNearby(cageOfField[height + 1][width - 1]);
            }
            numberOfMineNearby(cageOfField[height + 1][width]);
            if (width < 3) {
                numberOfMineNearby(cageOfField[height + 1][width + 1]);
            }
        }
        button[height][width].setText(String.valueOf(quantity));
        button[height][width].setEnabled(false);
        cageOfField[height][width] = 2;
    }

    void winner(int [][] cageOfField, TextView textView, Button button[][]){
        for (int i = 0; i <=3; i++){
            for (int j = 0; j <=3; j++){
                if (cageOfField[i][j] == 0) return;
            }
        }
        textView.setText("You win");
        button[0][0].setEnabled(false);
        button[0][1].setEnabled(false);
        button[0][2].setEnabled(false);
        button[0][3].setEnabled(false);

        button[1][0].setEnabled(false);
        button[1][1].setEnabled(false);
        button[1][2].setEnabled(false);
        button[1][3].setEnabled(false);

        button[2][0].setEnabled(false);
        button[2][1].setEnabled(false);
        button[2][2].setEnabled(false);
        button[2][3].setEnabled(false);

        button[3][0].setEnabled(false);
        button[3][1].setEnabled(false);
        button[3][2].setEnabled(false);
        button[3][3].setEnabled(false);
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (cageOfField[i][j]==1){
                    button[i][j].setText("bomb");
                }
            }
        }
    }
    void numberOfMineNearby(int cage) {
        if (cage == 1) {
            quantity++;
        }
    }
}
