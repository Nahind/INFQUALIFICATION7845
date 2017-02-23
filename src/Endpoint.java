import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by nandane on 23/02/17.
 */
public class Endpoint {

    int id;
    int latencyToDataServer;
    Map<Cache, Integer> connectedCaches;
    List<Request> requests = new ArrayList<>();

    public Endpoint(int id, int latencyToDataServer, Map<Cache, Integer> connectedCaches) {
        this.id = id;
        this.latencyToDataServer = latencyToDataServer;
        this.connectedCaches = connectedCaches;
    }

    public void addRequest(Request r) {
        requests.add(r);
    }

    public int getId() {
        return id;
    }

    public int getLatencyToDataServer() {
        return latencyToDataServer;
    }

    public Map<Cache, Integer> getConnectedCaches() {
        return connectedCaches;
    }

    public List<Request> getRequests() {
        return requests;
    }
}
