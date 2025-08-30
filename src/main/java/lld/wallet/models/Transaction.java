package lld.wallet.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Transaction {

    private String accountHolderFrom;
    private String accountHolderTo;
    private String transactionId;
    private double amount;
    private TransactionType transactionType;
}
