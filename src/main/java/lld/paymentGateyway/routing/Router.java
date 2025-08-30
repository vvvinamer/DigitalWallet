package lld.paymentGateyway.routing;

import lld.paymentGateyway.Bank;
import lld.paymentGateyway.strategy.Payment;

import java.util.ArrayList;
import java.util.List;

public class Router {

    List<Bank> banks;

    public Router() {
        this.banks = new ArrayList<>();
    }

    public Bank resolveBankForPayment(Payment payment) {
        return banks.getFirst();
    }

}
