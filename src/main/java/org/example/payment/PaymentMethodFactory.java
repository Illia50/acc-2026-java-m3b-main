package org.example.payment;

public class PaymentMethodFactory {
    public static PaymentMethod createCreditCardPayment(String cardNumber,String cardHolderName){
        return new CreditCardPayment(cardNumber,cardHolderName);
    }

    public static PaymentMethod createPaypalPayment (String email) {
        return new PaypalPayment(email);
    }

    public static PaymentMethod createGiftCardPayment (String providerName, String code, double balance){
        return new GiftCardPayment(providerName, code, balance);
    }

    public static PaymentMethod createCryptoPayment(String walletAddress) {
        return new CryptoPayment(walletAddress);
    }
    // TODO: create factories for PayPal and gift card
}
