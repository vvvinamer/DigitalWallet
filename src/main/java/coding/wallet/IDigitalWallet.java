package coding.wallet;

import coding.wallet.exception.AccountNotFoundException;
import coding.wallet.exception.InsufficientBalanceException;
import coding.wallet.models.Account;
import coding.wallet.models.OFFER_TYPE;
import coding.wallet.models.Transaction;
import coding.wallet.models.request.CreateAccountRequest;
import coding.wallet.models.request.TransferAmountRequest;

public interface IDigitalWallet {

    Account createWallet(CreateAccountRequest createAccountRequest);

    Transaction transferMoney(TransferAmountRequest transferAmountRequest) throws AccountNotFoundException, InsufficientBalanceException;

    void getStatement(String accountHoldersName) throws AccountNotFoundException;

    void PrintOverview();

    void applyOffer(OFFER_TYPE offerType);
}
