package coding.paymentGateyway;

import coding.paymentGateyway.models.BankPayment;
import coding.paymentGateyway.models.Status;
import coding.paymentGateyway.strategy.Payment;

import java.util.Random;
import java.util.UUID;
import java.util.random.RandomGenerator;

public class HDFC extends Bank {

    RandomGenerator randomGenerator;

    public HDFC() {
        this.randomGenerator = new Random();
    }

    @Override
    BankPayment processPayment(Payment payment) {

        String transactionId = UUID.randomUUID().toString();

        if (randomGenerator.nextDouble() < 0.5) {

            System.out.printf("Payment processed successfully, bank %s, mode %s, id %s%n", "HDFC", payment.getPaymentMode(), transactionId);
            return BankPayment.builder().payment(payment)
                    .transactionId(transactionId)
                    .status(Status.SUCCESS)
                    .build();
        }

        System.out.printf("Payment failed, bank %s, mode %s, id %s%n", "HDFC", payment.getPaymentMode(), transactionId);
        return BankPayment.builder().payment(payment)
                .transactionId(transactionId)
                .status(Status.FAILURE)
                .build();
    }

}
