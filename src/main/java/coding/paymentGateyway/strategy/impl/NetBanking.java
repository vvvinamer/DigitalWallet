package coding.paymentGateyway.strategy.impl;

import coding.paymentGateyway.models.PaymentMode;
import coding.paymentGateyway.strategy.Payment;

public class NetBanking extends Payment {

    String username;
    String password;

    public NetBanking(String username, String password) {
        super(PaymentMode.NET_BANKING);
        this.username = username;
        this.password = password;
    }

}
