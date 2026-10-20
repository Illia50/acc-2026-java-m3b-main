package org.example.model;

public class FixedAmountDiscount extends Discount {
    private double amount;

    public FixedAmountDiscount(double amount) {
        super("FIXED AMOUNT");
        this.amount = amount;
    }

    @Override
    public double apply(double originalAmount) {
        return Math.max(0, originalAmount - this.amount);
        // TODO
        // 'apply' formula: Math.max(0,originalAmount - amount)

    }
}
