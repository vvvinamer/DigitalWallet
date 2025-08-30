package coding.paymentGateyway.strategy.impl;

import coding.paymentGateyway.models.PaymentMode;
import coding.paymentGateyway.strategy.Payment;

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
