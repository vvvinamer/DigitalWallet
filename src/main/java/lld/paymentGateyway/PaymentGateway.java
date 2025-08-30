package lld.paymentGateyway;

import lld.paymentGateyway.models.BankPayment;
import lld.paymentGateyway.models.PaymentMode;
import lld.paymentGateyway.models.PaymentRequest;

import java.util.Map;
import java.util.Set;

public abstract class PaymentGateway {

    Map<String, Client> clientsMap;
    Set<PaymentMode> supportedPaymentModes;

    abstract void addClient(Client client);
    abstract void removeClient(String clientId);
    abstract boolean hasClient();

    abstract Set<PaymentMode> listSupportedPaymentModes();

    abstract Set<PaymentMode> listSupportedPaymentModes(String clientId);

    abstract void addSupportForPaymentMode();

    abstract void addSupportForPaymentMode(String clientId);

    abstract void removePaymentMode();

    abstract void removePaymentMode(String clientId);

    abstract BankPayment makePayment(String clientId, PaymentRequest paymentRequest);
}
