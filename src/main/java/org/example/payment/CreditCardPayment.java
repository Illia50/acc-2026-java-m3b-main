package org.example.payment;

import org.example.model.PaymentResult;

public class CreditCardPayment extends PaymentMethod {
    private final String cardNumber;
    private final String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        super("CreditCard");
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public PaymentResult processPayment(double amount) {
        if (cardNumber == null) {
            if (cardNumber.length() < 8) {
                return new PaymentResult(false, "Error: Invalid card number.");
            }
            if (cardHolderName.trim().isEmpty()) {
                return new PaymentResult(false, "Error: Card holder name is missing.");
            }
        }
        // TODO: add basic validations
        return new PaymentResult(true, "Paid " + amount + " using credit card ending with " + cardNumber.substring(cardNumber.length() - 4));
    }
}
