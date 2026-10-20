package org.example.model;

public class InternationalFee implements Fee {
    @Override
    public double applyFee(double amount) {
        return amount * 0.05;
    }
}
