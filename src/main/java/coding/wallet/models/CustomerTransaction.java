package coding.wallet.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomerTransaction {

    private String otherAccountInvolved;
    private double amount;
    private CustomerTransactionType customerTransactionType;


    public enum CustomerTransactionType {
        DEBIT,
        CREDIT
    }

}
