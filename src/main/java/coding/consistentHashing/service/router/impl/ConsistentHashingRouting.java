package coding.consistentHashing.service.router.impl;

import coding.consistentHashing.models.Request;
import coding.consistentHashing.models.Server;
import coding.consistentHashing.service.router.RequestToServerRouter;

import java.util.*;

public class ConsistentHashingRouting extends RequestToServerRouter {

    private final TreeMap<Integer, Server> servers;

    public ConsistentHashingRouting(List<Server> servers) {
        this.servers = new TreeMap<>();
        servers.forEach(this::addServer);
    }

    @Override
    public Server getServerForRequest(Request request) {

        if (servers.isEmpty()) {
            throw new RuntimeException("No servers available");
        }

        int requestHash = request.getHash();
        return Optional.ofNullable(servers.higherEntry(requestHash))
                .orElse(servers.firstEntry())
                .getValue();
    }

    @Override
    public void addServer(Server server) {
        servers.put(server.getHash(), server);
    }

    @Override
    public void removeServer(Server server) {
        servers.remove(server.getHash());
    }

}
