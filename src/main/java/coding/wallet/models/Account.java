package coding.wallet.models;

import coding.wallet.exception.InsufficientBalanceException;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Builder
@Data
@Slf4j
public class Account {

    private String accountHolderName;
    private double balance;
    private List<Transaction> transactions;
    private long transactionsCount;
    private long createdTimestamp;


    public void addMoney(double amount) {
        this.balance = this.balance + amount;
        log.info("Money with amount : {} added to account {}", amount, this.accountHolderName);
    }

    public void deductMoney(double amount) throws InsufficientBalanceException {

        if (this.balance - amount <= 0) {
            log.error("Insufficient balance found for deduction");
            throw new InsufficientBalanceException();
        }

        this.balance = this.balance - amount;
        log.info("Money with amount : {} deducted from account {}", amount, this.accountHolderName);
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);

        if (TransactionType.NORMAL.equals(transaction.getTransactionType())) {
            this.transactionsCount++;
        }
    }
}
