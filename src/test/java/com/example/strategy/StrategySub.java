package com.example.strategy;

public class StrategySub implements Strategy {

    @Override
    public void operate(int var1, int var2) {
        System.out.println ("var1-var2::"+(var1-var2));
    }
}
