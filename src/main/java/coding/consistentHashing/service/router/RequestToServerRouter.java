package coding.consistentHashing.service.router;

import coding.consistentHashing.models.Request;
import coding.consistentHashing.models.Server;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class RequestToServerRouter {

    public abstract Server getServerForRequest(Request request);

    public abstract void addServer(Server server);

    public abstract void removeServer(Server server);
}
