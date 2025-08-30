package lld.wallet.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Statement {

    private List<CustomerTransaction> customerTransactions;

}
