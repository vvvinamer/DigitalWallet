package coding.consistentHashing;

import coding.consistentHashing.models.Request;
import coding.consistentHashing.models.Server;
import coding.consistentHashing.service.router.impl.BasicHashBasedRouting;
import coding.consistentHashing.service.router.RequestToServerRouter;
import coding.consistentHashing.service.router.impl.ConsistentHashingRouting;
import coding.consistentHashing.service.router.impl.ConsistentHashingWithVirtualNodes;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();

        List<Request> requests = IntStream.range(1, 1000)
                .map(ignore -> random.nextInt())
                .mapToObj(i -> new Request(String.valueOf(i)))
                .toList();

        List<Server> servers = IntStream.range(1, 10)
                .mapToObj(i -> new Server(String.valueOf(i)))
                .toList();

        List<RequestToServerRouter> routers = List.of(new BasicHashBasedRouting(servers),
                new ConsistentHashingRouting(servers), new ConsistentHashingWithVirtualNodes(servers));

        routers.forEach(router -> routeExtractsAfterAdditionAndGetDifference(router, requests));
    }

    private static void routeExtractsAfterAdditionAndGetDifference(RequestToServerRouter router, List<Request> requests) {
        List<Server> servers1 = routeRequests(requests, router);

        IntStream.range(11, 15)
                .mapToObj(i -> new Server(String.valueOf(i)))
                        .forEach(router::addServer);

        List<Server> servers2 = routeRequests(requests, router);

        printPercentageChange(router.getClass().getSimpleName(), servers1, servers2);
    }

    private static List<Server> routeRequests(List<Request> requests, RequestToServerRouter router) {
        List<Server> servers = requests.stream().map(request -> {

            Server server = router.getServerForRequest(request);
//            System.out.printf("Got server %s for request %s%n", server.getId(), request.getId());

            return server;
        }).toList();

        System.out.println();
        return servers;
    }

    private static void printPercentageChange(String routingStrategy, List<Server> servers1, List<Server> servers2) {
        double size = servers1.size();
        double diffCount = 0;

        for (int i = 0; i < size; i++) {
            if (servers1.get(i) != servers2.get(i)) {
                diffCount++;
            }
        }

        double diffPercentage = (diffCount/size) * 100;
        System.out.println(routingStrategy + " : "+ diffPercentage + "% of requests got changed : ");
        System.out.println();
    }
}
