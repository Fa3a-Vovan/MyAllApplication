package com.example.lesson02final;

public class TransformData {

    Entity stringToInts(String string) throws ArithmeticException {
        Entity entity = new Entity();
        string = string.replaceAll("[a-zA-z=]", "");
        String[] arrayString = string.split(", ", 3);
        entity.setA(Integer.parseInt(arrayString[0]));
        entity.setB(Integer.parseInt(arrayString[1]));
        entity.setC(Integer.parseInt(arrayString[2]));
        return entity;
    }
}