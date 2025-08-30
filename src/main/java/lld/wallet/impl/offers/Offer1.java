package lld.wallet.impl.offers;

import lld.wallet.TransactionalOffer;
import lld.wallet.models.Account;
import lld.wallet.models.OFFER_TYPE;
import lld.wallet.models.Transaction;
import lld.wallet.models.TransactionType;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
public class Offer1 implements TransactionalOffer {

    private final Map<String, Account> accounts;
    private final List<Double> amountsToBeAdded;
    private final long offer1Amount;

    public Offer1(Map<String, Account> accounts) {
        this.accounts = accounts;
        this.amountsToBeAdded = List.of(10D, 5D, 2D);
        this.offer1Amount = 10L;
    }


    @Override
    public void applyOffer(Transaction transaction) {
        Account fromAccount = this.accounts.get(transaction.getAccountHolderFrom());
        Account toAccount = this.accounts.get(transaction.getAccountHolderTo());

        if (fromAccount.getBalance() != toAccount.getBalance()) {
            log.info("Transaction not valid for offer1");
            return;
        }

        log.info("Transaction valid for offer1 : {}", transaction);

        //TODO: this offerTransaction should not show up when viewing transactions of a customer while considering offer 2

        fromAccount.addMoney(this.offer1Amount);
        toAccount.addMoney(this.offer1Amount);


        Transaction offerTransaction = Transaction.builder()
                //TODO: Note transfer From is null
                .accountHolderTo(toAccount.getAccountHolderName())
                .amount(offer1Amount)
                .transactionId(UUID.randomUUID().toString())
                .transactionType(TransactionType.OFFER1)
                .build();

        fromAccount.addTransaction(offerTransaction);
        toAccount.addTransaction(offerTransaction);

        log.info("{} : amount added in accounts : {} and {}",fromAccount.getBalance(),
                fromAccount.getAccountHolderName(), toAccount.getAccountHolderName());
    }

    @Override
    public OFFER_TYPE offerName() {
        return OFFER_TYPE.OFFER1;
    }

}
