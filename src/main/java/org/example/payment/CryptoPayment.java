package org.example.payment;

import org.example.model.PaymentResult;

public class CryptoPayment extends PaymentMethod {
    private final String walletAddress;

    public CryptoPayment(String walletAddress) {
        super("Crypto");
        this.walletAddress = walletAddress;
    }

    @Override
    public PaymentResult processPayment(double amount) {
        if (walletAddress == null || walletAddress.length() < 26) {
            return new PaymentResult(false, "Error: Invalid crypto wallet address.");
        }
        return new PaymentResult(true, "Paid " + amount + " using Crypto wallet: " + walletAddress.substring(0, 6) + "...");
    }
}