package coding.wallet.models.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateAccountRequest {

    private String accountHolderName;
    private double openingBalance;

}
