package lld.paymentGateyway.strategy.impl;

import lld.paymentGateyway.models.PaymentMode;
import lld.paymentGateyway.strategy.Payment;

public class NetBanking extends Payment {

    String username;
    String password;

    public NetBanking(String username, String password) {
        super(PaymentMode.NET_BANKING);
        this.username = username;
        this.password = password;
    }

}
