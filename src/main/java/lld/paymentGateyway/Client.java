package lld.paymentGateyway;

import lld.paymentGateyway.models.PaymentMode;

import java.util.Set;

public abstract class Client {

    Set<PaymentMode> supportedPaymentModes;

    void addPaymentModes(PaymentMode paymentMode) {
        supportedPaymentModes.add(paymentMode);
    }

    boolean supportsPaymentMode(PaymentMode paymentMode) {
        return supportedPaymentModes.contains(paymentMode);
    }

    abstract String getId();

}
