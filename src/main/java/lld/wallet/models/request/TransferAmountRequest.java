package lld.wallet.models.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TransferAmountRequest {

    private String fromAccount;
    private String toAccount;
    private double amount;

}
