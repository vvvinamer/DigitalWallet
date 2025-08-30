package coding.paymentGateyway;

import coding.paymentGateyway.models.PaymentRequest;
import coding.paymentGateyway.strategy.Payment;
import coding.paymentGateyway.strategy.impl.CardPayment;
import coding.paymentGateyway.strategy.impl.NetBanking;
import coding.paymentGateyway.strategy.impl.UPIPayment;

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
