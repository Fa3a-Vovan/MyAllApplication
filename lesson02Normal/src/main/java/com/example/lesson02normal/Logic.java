package com.example.lesson02normal;

public class Logic {

    void setEntityA(Entity entity, String s) {
        s = s.replaceAll("[+]", "");
        entity.setA(Integer.parseInt(s));
    }

    void setEntityB(Entity entity, String s) {
        s = s.replaceAll("[a-zA-Z=]", "");
        entity.setB(Integer.parseInt(s));
    }

    void setEntityC(Entity entity, String s) {
        s = s.replaceAll("[a-zA-Z=]", "");
        entity.setC(Integer.parseInt(s));
    }

    String howManyRootsOfExpression(Entity entity) {
        entity.setD(entity.getB() * entity.getB() - (4 * entity.getA() * entity.getC()));
        if (entity.getD() < 0) {
            return "Корней нет";
        }
        if (entity.getD() == 0) {
            return "есть один корень\n" + oneX(entity);
        } else {
            return "два корня\n" + twoX(entity);
        }
    }

    String oneX(Entity entity) {
        double x = -entity.getB() / (2 * entity.getA());
        return "x = " + x;
    }

    String twoX(Entity entity) {
        double x1 = (-entity.getB() + Math.sqrt(entity.getD())) / (2 * entity.getA());
        double x2 = (-entity.getB() - Math.sqrt(entity.getD())) / (2 * entity.getA());
        return "x1 = " + x1 + "\nx2 =" + x2;
    }
}
