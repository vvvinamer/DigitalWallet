package coding.wallet.impl.offers;

import coding.wallet.NonTransactionalOffer;
import coding.wallet.models.Account;
import coding.wallet.models.OFFER_TYPE;
import coding.wallet.models.Transaction;
import coding.wallet.models.TransactionType;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.IntStream;

@Slf4j
public class Offer2 implements NonTransactionalOffer {

    private final Map<String, Account> accounts;
    private final List<Double> amountsToBeAdded;

    public Offer2(Map<String, Account> accounts) {
        this.accounts = accounts;
        this.amountsToBeAdded = List.of(10D, 5D, 2D);
    }

    @Override
    public OFFER_TYPE offerName() {
        return OFFER_TYPE.OFFER2;
    }

    @Override
    public void applyOffer() {

        List<Account> accountList = new java.util.ArrayList<>(this.accounts.values().stream().toList());
        accountList.sort((o1, o2) -> {
            if (o1.getTransactionsCount() > o2.getTransactionsCount()) {
                return -1;
            }

            if (o1.getTransactionsCount() == o2.getTransactionsCount()) {

                if (o1.getBalance() > o2.getBalance()) {
                    return -1;
                }

                if (o1.getBalance() == o2.getBalance()) {

                    if (o1.getCreatedTimestamp() < o2.getCreatedTimestamp()) {
                        return -1;
                    } else if (o1.getCreatedTimestamp() == o2.getCreatedTimestamp()) {
                        return 0;
                    }

                }

            }

            return 1;
        });

        IntStream.range(0, Math.min(amountsToBeAdded.size(), accountList.size()))
                .forEach(i -> {

                    double amountToBeAdded = amountsToBeAdded.get(i);
                    Account account = accountList.get(i);
                    account.addMoney(amountToBeAdded);

                    Transaction transaction = Transaction.builder()
                            .transactionId(UUID.randomUUID().toString())
                            .accountHolderTo(account.getAccountHolderName())
                            .amount(amountToBeAdded)
                            .transactionType(TransactionType.OFFER2)
                            .build();

                    account.addTransaction(transaction);
                });
    }

}
