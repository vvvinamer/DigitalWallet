package coding.consistentHashing.service.router.impl;

import coding.consistentHashing.models.Request;
import coding.consistentHashing.models.Server;
import coding.consistentHashing.models.VirtualServerNode;
import coding.consistentHashing.service.router.RequestToServerRouter;
import coding.consistentHashing.utils.CommonUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ConsistentHashingWithVirtualNodes extends RequestToServerRouter {

    private final TreeMap<Integer, VirtualServerNode> virtualServers;
    private static final int VIRTUAL_NODES_COUNT = 100;
//    private static final String

    public ConsistentHashingWithVirtualNodes(List<Server> servers) {
        virtualServers = new TreeMap<>();
        servers.forEach(this::addServer);
    }

    @Override
    public Server getServerForRequest(Request request) {

        if (virtualServers.isEmpty()) {
            throw new RuntimeException("No servers available");
        }

        int requestHash = request.getHash();
        return Optional.ofNullable(virtualServers.higherEntry(requestHash))
                .orElse(virtualServers.firstEntry())
                .getValue()
                .getServer();

    }

    @Override
    public void addServer(Server server) {

        for (int virtualServerNum = 0; virtualServerNum < VIRTUAL_NODES_COUNT; virtualServerNum++) {
            VirtualServerNode virtualServerNode = new VirtualServerNode(virtualServerNum, server);
            int virtualServerHash = virtualServerNode.getHash();
            virtualServers.put(virtualServerHash, virtualServerNode);
        }

    }

    @Override
    public void removeServer(Server server) {

        for (int virtualServerNum = 0; virtualServerNum < VIRTUAL_NODES_COUNT; virtualServerNum++) {
            String virtualNodeId = CommonUtils.getVirtualServerId(server.getId(), virtualServerNum);
            virtualServers.remove(CommonUtils.getHash(virtualNodeId));
        }

    }


}
