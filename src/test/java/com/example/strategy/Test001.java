package com.example.strategy;

public class Test001 {
    public static void main(String[] args) {
        new StrategyBuilder (new StrategySub ()).operate (1,2);
    }
}
