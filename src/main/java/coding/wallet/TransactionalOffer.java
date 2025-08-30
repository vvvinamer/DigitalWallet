package coding.wallet;


import coding.wallet.models.Transaction;

public interface TransactionalOffer extends IApplyOffer {

    void applyOffer(Transaction transaction);

}
