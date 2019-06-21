package com.example.strategy;

public class StrategyBuilder {
    private Strategy strategy;

    public StrategyBuilder(Strategy strategy) {
        this.strategy = strategy;
    }

    public void operate(int num1, int num2) {
        strategy.operate (num1, num2);
    }
}
