package lld.wallet;


import lld.wallet.models.Transaction;

public interface TransactionalOffer extends IApplyOffer {

    void applyOffer(Transaction transaction);

}
