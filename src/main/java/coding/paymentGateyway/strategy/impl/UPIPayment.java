package coding.paymentGateyway.strategy.impl;

import coding.paymentGateyway.models.PaymentMode;
import coding.paymentGateyway.strategy.Payment;
import lombok.*;

@Getter
public class UPIPayment extends Payment {

    String vpa;

    public UPIPayment(String vpa) {
        super(PaymentMode.UPI);
        this.vpa = vpa;
    }

}
