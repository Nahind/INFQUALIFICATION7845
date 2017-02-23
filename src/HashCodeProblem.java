import javax.xml.crypto.Data;
import java.util.List;

/**
 * Created by nandane on 23/02/17.
 */
public class HashCodeProblem {

    DataCenter dc;
    List<Cache> caches;
    List<Endpoint> endpoints;
    List<Video> videos;
    List<Request> requests;

    public HashCodeProblem(DataCenter dc, List<Cache> caches, List<Endpoint> endpoints, List<Video> videos, List<Request> requests) {
        this.dc = dc;
        this.caches = caches;
        this.endpoints = endpoints;
        this.videos = videos;
        this.requests = requests;
    }
}
