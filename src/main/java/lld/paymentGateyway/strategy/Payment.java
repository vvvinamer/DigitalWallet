package lld.paymentGateyway.strategy;

import lld.paymentGateyway.models.PaymentMode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public abstract class Payment {

    final PaymentMode paymentMode;

}
