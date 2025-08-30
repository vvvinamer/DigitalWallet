package lld.paymentGateyway;

import lld.paymentGateyway.models.BankPayment;
import lld.paymentGateyway.models.PaymentMode;
import lld.paymentGateyway.models.PaymentRequest;
import lld.paymentGateyway.routing.Router;
import lld.paymentGateyway.strategy.Payment;

import java.util.*;

public class FastPay extends PaymentGateway {

    PaymentFactory paymentFactory;
    Map<String, Router> routersMap;

    public FastPay() {
        this.clientsMap = new HashMap<>();
        this.supportedPaymentModes = new HashSet<>();
        this.paymentFactory = new PaymentFactory();
        this.routersMap = new HashMap<>();
    }

    @Override
    public void addClient(Client client) {
        this.clientsMap.put(client.getId(), client);
        this.routersMap.put(client.getId(), new Router());
    }

    @Override
    public void removeClient(String clientId) {
        this.clientsMap.remove(clientId);
        this.routersMap.remove(clientId);
    }

    @Override
    public boolean hasClient() {
        return Objects.nonNull(this.clientsMap) && !this.clientsMap.isEmpty();
    }

    @Override
    public Set<PaymentMode> listSupportedPaymentModes() {
        return supportedPaymentModes;
    }

    @Override
    public Set<PaymentMode> listSupportedPaymentModes(String clientId) {
        return Optional.ofNullable(this.clientsMap.get(clientId))
                .orElseThrow()
                .supportedPaymentModes;
    }

    @Override
    void addSupportForPaymentMode() {

    }

    @Override
    void addSupportForPaymentMode(String clientId) {

    }

    @Override
    public void removePaymentMode() {

    }

    @Override
    public void removePaymentMode(String clientId) {

    }

    @Override
    public BankPayment makePayment(String clientId, PaymentRequest paymentRequest) {

        Payment payment = paymentFactory.getPayment(paymentRequest);
        Client client = this.clientsMap.get(clientId);

        if (this.supportsPaymentMode(payment.getPaymentMode())) {
            throw new IllegalStateException("Payment Gateway doesn't support this payment mode");
        }

        if (!client.supportsPaymentMode(payment.getPaymentMode())) {
            throw new IllegalStateException(String.format("%s Client doesn't support payment mode %s", clientId, payment.getPaymentMode()));
        }

        Bank resolvedBankForPayment = this.routersMap.get(clientId).resolveBankForPayment(payment);
        return resolvedBankForPayment.processPayment(payment);
    }

    private boolean supportsPaymentMode(PaymentMode paymentMode) {
        return this.supportedPaymentModes.contains(paymentMode);
    }
}
