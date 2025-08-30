package coding.paymentGateyway.routing;

import coding.paymentGateyway.Bank;
import coding.paymentGateyway.strategy.Payment;

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
