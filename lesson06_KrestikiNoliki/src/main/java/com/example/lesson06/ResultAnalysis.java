package com.example.lesson06;

public class ResultAnalysis {
    String crossesWon(){
        return "Победили крестики";
    }
    String zerosWon(){
        return "Победили Нолики";
    }
    String analysis(int[][] a2){
        if (a2[0][0]==1 && a2[0][1]==1 && a2[0][2]==1){return crossesWon();}
        if (a2[1][0]==1 && a2[1][1]==1 && a2[1][2]==1){return crossesWon();}
        if (a2[2][0]==1 && a2[2][1]==1 && a2[2][2]==1){return crossesWon();}
        if (a2[0][0]==1 && a2[1][0]==1 && a2[2][0]==1){return crossesWon();}
        if (a2[0][1]==1 && a2[1][1]==1 && a2[2][1]==1){return crossesWon();}
        if (a2[0][2]==1 && a2[1][2]==1 && a2[2][2]==1){return crossesWon();}
        if (a2[0][0]==1 && a2[1][1]==1 && a2[2][2]==1){return crossesWon();}
        if (a2[0][2]==1 && a2[1][1]==1 && a2[2][0]==1){return crossesWon();}

        if (a2[0][0]==2 && a2[0][1]==2 && a2[0][2]==2){return zerosWon();}
        if (a2[1][0]==2 && a2[1][1]==2 && a2[1][2]==2){return zerosWon();}
        if (a2[2][0]==2 && a2[2][1]==2 && a2[2][2]==2){return zerosWon();}
        if (a2[0][0]==2 && a2[1][0]==2 && a2[2][0]==2){return zerosWon();}
        if (a2[0][1]==2 && a2[1][1]==2 && a2[2][1]==2){return zerosWon();}
        if (a2[0][2]==2 && a2[1][2]==2 && a2[2][2]==2){return zerosWon();}
        if (a2[0][0]==2 && a2[1][1]==2 && a2[2][2]==2){return zerosWon();}
        if (a2[0][2]==2 && a2[1][1]==2 && a2[2][0]==2){return zerosWon();}
        return "Пока победителя нет";
    }
}
