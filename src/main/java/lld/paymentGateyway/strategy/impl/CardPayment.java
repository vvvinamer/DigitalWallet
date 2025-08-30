package lld.paymentGateyway.strategy.impl;

import lld.paymentGateyway.models.PaymentMode;
import lld.paymentGateyway.strategy.Payment;

public class CardPayment extends Payment {

    String cardNumber;
    String cvv;
    String expiryMonth;

    public CardPayment(String cardNumber, String cvv, String expiryMonth) {
        super(PaymentMode.CARD);
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryMonth = expiryMonth;
    }

}
