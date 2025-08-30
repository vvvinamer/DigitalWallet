package lld.paymentGateyway.models;

import lombok.Data;

@Data
public class PaymentRequest {

    String userName;
    String password;

    String cardNumber;
    String expiryMonth;
    String cvv;

    String vpa;
}
