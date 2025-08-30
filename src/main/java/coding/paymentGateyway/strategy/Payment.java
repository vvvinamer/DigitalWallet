package coding.paymentGateyway.strategy;

import coding.paymentGateyway.models.PaymentMode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public abstract class Payment {

    final PaymentMode paymentMode;

}
