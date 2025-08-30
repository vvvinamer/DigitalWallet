package coding.consistentHashing.models;

import coding.consistentHashing.utils.CommonUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Server implements Hashable {

    String id;

    @Override
    public int getHash() {
        return CommonUtils.getHash(id);
    }

}
