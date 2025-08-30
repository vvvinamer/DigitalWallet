package conceptual.consistentHashing.service.router;

import conceptual.consistentHashing.models.Request;
import conceptual.consistentHashing.models.Server;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class RequestToServerRouter {

    public abstract Server getServerForRequest(Request request);

    public abstract void addServer(Server server);

    public abstract void removeServer(Server server);
}
