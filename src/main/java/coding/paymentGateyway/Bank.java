package coding.paymentGateyway;

import coding.paymentGateyway.models.BankPayment;
import coding.paymentGateyway.strategy.Payment;

public abstract class Bank {

    abstract BankPayment processPayment(Payment payment);

}
