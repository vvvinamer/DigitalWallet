package coding.consistentHashing.models;

import coding.consistentHashing.utils.CommonUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request implements Hashable {

    private String id;

    @Override
    public int getHash() {
        return CommonUtils.getHash(id);
    }

}
