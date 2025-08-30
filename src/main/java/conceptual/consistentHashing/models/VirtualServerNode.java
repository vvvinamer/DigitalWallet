package conceptual.consistentHashing.models;

import conceptual.consistentHashing.utils.CommonUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VirtualServerNode implements Hashable {

    private int virtualServerNumber;
    private Server server;

    @Override
    public int getHash() {
        return CommonUtils.getHash(getVirtualServerId());
    }

    public String getVirtualServerId() {
        return CommonUtils.getVirtualServerId(server.getId(), this.virtualServerNumber);
    }
}
