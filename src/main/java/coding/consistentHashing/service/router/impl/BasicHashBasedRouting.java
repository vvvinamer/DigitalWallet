package coding.consistentHashing.service.router.impl;

import coding.consistentHashing.models.Request;
import coding.consistentHashing.models.Server;
import coding.consistentHashing.service.router.RequestToServerRouter;

import java.util.ArrayList;
import java.util.List;

public class BasicHashBasedRouting extends RequestToServerRouter {

    private final List<Server> servers;

    public BasicHashBasedRouting(List<Server> servers) {
        this.servers = new ArrayList<>(servers);
    }

    public BasicHashBasedRouting() {
        this.servers = new ArrayList<>();
    }

    @Override
    public Server getServerForRequest(Request request) {

        if (servers.isEmpty()) {
            throw new RuntimeException("No servers available");
        }

        int requestHash = request.getHash();

//        System.out.printf("Request hash : %s\n", requestHash);

        int serverIndex = Math.floorMod(requestHash, servers.size());
        return servers.get(serverIndex);
    }

    @Override
    public void addServer(Server server) {
        this.servers.add(server);
    }

    @Override
    public void removeServer(Server server) {

    }

}
