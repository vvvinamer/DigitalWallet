package lld.paymentGateyway.strategy.impl;

import lld.paymentGateyway.models.PaymentMode;
import lld.paymentGateyway.strategy.Payment;
import lombok.*;

@Getter
public class UPIPayment extends Payment {

    String vpa;

    public UPIPayment(String vpa) {
        super(PaymentMode.UPI);
        this.vpa = vpa;
    }

}
