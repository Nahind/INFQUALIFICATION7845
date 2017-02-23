import java.util.List;
import java.util.Map;

/**
 * Created by nandane on 23/02/17.
 */
public class Endpoint {

    int id;
    int latencyToDataServer;
    Map<Cache, Integer> connectedCaches;

    public Endpoint(int id, int latencyToDataServer, Map<Cache, Integer> connectedCaches) {
        this.id = id;
        this.latencyToDataServer = latencyToDataServer;
        this.connectedCaches = connectedCaches;
    }
}
