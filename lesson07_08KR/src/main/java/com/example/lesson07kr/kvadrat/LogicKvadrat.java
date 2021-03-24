package com.example.lesson07kr.kvadrat;

import android.util.Log;

public class LogicKvadrat {
    public String howManyRootsHaveEquation(Entity entity) throws ArithmeticException {
        entity.setD((entity.getB() * entity.getB() - (4 * entity.getA() * entity.getC())));


        if (entity.getD() < 0) {
            return "уравнение не имеет корней";
        } else if (entity.getD() == 0) {
            return "Уравнение имеет один корень:\n" + oneX(entity);
        } else {
            return "Уравнение имеет два корня:\n" + twoX(entity);
        }
    }

    private String twoX(Entity entity) {
        double x1 = ((-entity.getB() + Math.sqrt((double) entity.getD())) / (2 * entity.getA()));
        double x2 = ((-entity.getB() - Math.sqrt((double) entity.getD())) / (2 * entity.getA()));
        return "x1=" + x1 + "\n" + "x2=" + x2;
    }

    private double oneX(Entity entity) {
        return (double) -entity.getB() / (2 * entity.getA());
    }
}
