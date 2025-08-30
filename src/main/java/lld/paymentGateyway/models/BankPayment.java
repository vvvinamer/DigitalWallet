package lld.paymentGateyway.models;

import lld.paymentGateyway.strategy.Payment;
import lombok.Builder;

@Builder
public class BankPayment {
    String transactionId;
    Payment payment;
    Status status;
}
