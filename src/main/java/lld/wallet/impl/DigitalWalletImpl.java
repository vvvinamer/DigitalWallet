package lld.wallet.impl;

import lld.wallet.*;
import lld.wallet.exception.AccountNotFoundException;
import lld.wallet.exception.InsufficientBalanceException;
import lld.wallet.models.*;
import lld.wallet.models.request.CreateAccountRequest;
import lld.wallet.models.request.TransferAmountRequest;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class DigitalWalletImpl implements IDigitalWallet {

    private final Map<String, Account> accounts;

    public DigitalWalletImpl() {
        this.accounts = new ConcurrentHashMap<>();
        OfferConfig.initOfferConfig(accounts);
    }


    @Override
    public Account createWallet(CreateAccountRequest createAccountRequest) {

        logDelemiter();
        log.info("Creating new account with request : {}", createAccountRequest);
        if (this.accounts.containsKey(createAccountRequest.getAccountHolderName())
                || createAccountRequest.getOpeningBalance() < 0) {
            //TODO: here too checked exception can be thrown
            throw new RuntimeException("Account can't be created, bad request");
        }

        Account account = Account.builder()
                .accountHolderName(createAccountRequest.getAccountHolderName())
                .balance(createAccountRequest.getOpeningBalance())
                .transactions(new ArrayList<>())
                .createdTimestamp(System.currentTimeMillis())
                .build();

        this.accounts.put(account.getAccountHolderName(), account);

        log.info("Account successfully created : {}", account);
        logDelemiter();
        return account;
    }


    @Override
    public Transaction transferMoney(TransferAmountRequest transferAmountRequest) throws AccountNotFoundException, InsufficientBalanceException {

        if (transferAmountRequest.getFromAccount().equals(transferAmountRequest.getToAccount())) {
            throw new RuntimeException("Money can't be transferred to self");
        }

        Account fromAccount = checkAndGetAccount(transferAmountRequest.getFromAccount());
        Account toAccount = checkAndGetAccount(transferAmountRequest.getToAccount());

        fromAccount.deductMoney(transferAmountRequest.getAmount());
        toAccount.addMoney(transferAmountRequest.getAmount());


        Transaction transaction = Transaction.builder()
                .accountHolderFrom(fromAccount.getAccountHolderName())
                .accountHolderTo(toAccount.getAccountHolderName())
                .amount(transferAmountRequest.getAmount())
                .transactionId(UUID.randomUUID().toString())
                .transactionType(TransactionType.NORMAL)
                .build();

        fromAccount.addTransaction(transaction);
        toAccount.addTransaction(transaction);

        log.info("Transaction completed : {}", transaction);
        logDelemiter();

        this.applyTransactionalOffer(OFFER_TYPE.OFFER1, transaction);
        return transaction;
    }

    @Override
    public void getStatement(String accountHoldersName) throws AccountNotFoundException {

        logDelemiter();
        log.info("Getting statement for customer : {}", accountHoldersName);

        Account account = checkAndGetAccount(accountHoldersName);
        List<Transaction> transactions = account.getTransactions();
        List<CustomerTransaction> customerTransactions = transactions.stream().map(transaction -> {

            if (accountHoldersName.equals(transaction.getAccountHolderFrom())) {
                return CustomerTransaction.builder()
                        .amount(transaction.getAmount())
                        .customerTransactionType(CustomerTransaction.CustomerTransactionType.DEBIT)
                        .otherAccountInvolved(transaction.getAccountHolderTo())
                        .build();
            } else {
                return CustomerTransaction.builder()
                        .amount(transaction.getAmount())
                        .customerTransactionType(CustomerTransaction.CustomerTransactionType.CREDIT)
                        .otherAccountInvolved(transaction.getAccountHolderFrom())
                        .build();
            }

        }).toList();

        customerTransactions.forEach(customerTransaction ->  log.info("Customer Transaction : {}", customerTransaction));
        log.info("Customer current Balance for : {} is : {}", account.getAccountHolderName(), account.getBalance());
        logDelemiter();

        Statement statement = Statement.builder().customerTransactions(customerTransactions).build();


    }

    @Override
    public void PrintOverview() {

        logDelemiter();
        log.info("Printing overview of digital wallet");

        this.accounts.forEach((accountHolderName, account) -> {
            log.info("Account : {} has following balance : {}", accountHolderName, account.getBalance());
        });
        logDelemiter();
    }

    @Override
    public void applyOffer(OFFER_TYPE offerType) {
        logDelemiter();
        log.info("Going to apply offer of type : {}", offerType);

        NonTransactionalOffer nonTransactionalOffer = Optional.ofNullable(OfferConfig.getNonTransactionalOfferMap().get(offerType))
                .orElseThrow(() -> new RuntimeException("Offer type not supported yet"));
        nonTransactionalOffer.applyOffer();

        log.info("Offer applied : {}", offerType);
        logDelemiter();
    }

    private void applyTransactionalOffer(OFFER_TYPE offerType, Transaction transaction) {
        logDelemiter();
        log.info("Going to apply transactional offer of type : {}", offerType);

        TransactionalOffer transactionalOffer = Optional.ofNullable(OfferConfig.getTransactionalOfferMap().get(offerType))
                .orElseThrow(() -> new RuntimeException("Offer type not supported yet"));
        transactionalOffer.applyOffer(transaction);

        log.info("Transactional Offer applied : {}", offerType);
        logDelemiter();
    }


    private Account checkAndGetAccount(String accountHolderName) throws AccountNotFoundException {
        return Optional.ofNullable(this.accounts.get(accountHolderName))
                .orElseThrow(() -> new AccountNotFoundException(String.format("Account with name %s not found", accountHolderName)));
    }


    private static void logDelemiter() {
        log.info("-------------------------------------------------------------------------------------");
    }
}
