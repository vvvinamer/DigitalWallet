package lld.paymentGateyway;

import lld.paymentGateyway.models.BankPayment;
import lld.paymentGateyway.strategy.Payment;

public abstract class Bank {

    abstract BankPayment processPayment(Payment payment);

}
