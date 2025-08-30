package coding.paymentGateyway.models;

import coding.paymentGateyway.strategy.Payment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
public class BankPayment {
    String transactionId;
    Payment payment;
    Status status;
}
