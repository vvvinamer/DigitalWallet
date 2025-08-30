package lld.wallet;

import lld.wallet.exception.AccountNotFoundException;
import lld.wallet.exception.InsufficientBalanceException;
import lld.wallet.models.Account;
import lld.wallet.models.OFFER_TYPE;
import lld.wallet.models.Transaction;
import lld.wallet.models.request.CreateAccountRequest;
import lld.wallet.models.request.TransferAmountRequest;

public interface IDigitalWallet {

    Account createWallet(CreateAccountRequest createAccountRequest);

    Transaction transferMoney(TransferAmountRequest transferAmountRequest) throws AccountNotFoundException, InsufficientBalanceException;

    void getStatement(String accountHoldersName) throws AccountNotFoundException;

    void PrintOverview();

    void applyOffer(OFFER_TYPE offerType);
}
