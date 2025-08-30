package lld.paymentGateyway;

import lld.paymentGateyway.models.PaymentRequest;
import lld.paymentGateyway.strategy.Payment;
import lld.paymentGateyway.strategy.impl.CardPayment;
import lld.paymentGateyway.strategy.impl.NetBanking;
import lld.paymentGateyway.strategy.impl.UPIPayment;

import java.util.Objects;

public class PaymentFactory {

    Payment getPayment(PaymentRequest paymentRequest) {

        if (Objects.nonNull(paymentRequest.getVpa())) {
            return new UPIPayment(paymentRequest.getVpa());
        } else if (Objects.nonNull(paymentRequest.getUserName())
                && Objects.nonNull(paymentRequest.getPassword())) {
            return new NetBanking(paymentRequest.getUserName(), paymentRequest.getPassword());
        } else if (Objects.nonNull(paymentRequest.getCardNumber())
                && Objects.nonNull(paymentRequest.getCvv())
                && Objects.nonNull(paymentRequest.getExpiryMonth())) {
            return new CardPayment(paymentRequest.getCardNumber(), paymentRequest.getCvv(), paymentRequest.getExpiryMonth());
        }

        throw new IllegalStateException("Invalid payment request");
    }

}
