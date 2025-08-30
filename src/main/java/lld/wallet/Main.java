package lld.wallet;


import lld.wallet.exception.AccountNotFoundException;
import lld.wallet.exception.InsufficientBalanceException;
import lld.wallet.impl.DigitalWalletImpl;
import lld.wallet.models.OFFER_TYPE;
import lld.wallet.models.request.CreateAccountRequest;
import lld.wallet.models.request.TransferAmountRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) throws InsufficientBalanceException, AccountNotFoundException {
        IDigitalWallet digitalWallet = new DigitalWalletImpl();

        CreateAccountRequest createAccountRequest2 = CreateAccountRequest.builder()
                .accountHolderName("Sharad")
                .openingBalance(0.5D)
                .build();

        CreateAccountRequest createAccountRequest = CreateAccountRequest.builder()
                .accountHolderName("Vinamer")
                .openingBalance(0.5D)
                .build();

        digitalWallet.createWallet(createAccountRequest2);
        digitalWallet.createWallet(createAccountRequest);

        digitalWallet.PrintOverview();

        TransferAmountRequest transferAmountRequest = TransferAmountRequest.builder()
                .fromAccount("Vinamer")
                .toAccount("Sharad")
                .amount(0.4D)
                .build();

        TransferAmountRequest transferAmountRequest2 = TransferAmountRequest.builder()
                .fromAccount("Sharad")
                .toAccount("Vinamer")
                .amount(0.4D)
                .build();

        digitalWallet.transferMoney(transferAmountRequest);
        digitalWallet.transferMoney(transferAmountRequest2);
        digitalWallet.applyOffer(OFFER_TYPE.OFFER2);

        digitalWallet.PrintOverview();
        digitalWallet.getStatement("Vinamer");
        digitalWallet.getStatement("Sharad");
    }

}
