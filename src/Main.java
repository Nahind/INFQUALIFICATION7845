import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by nandane on 23/02/17.
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File testFile = new File("src/kittens.in");
        HashCodeProblem hcp = Helper.loadProblem(testFile);

        DataCenter dc;
        List<Cache> caches = hcp.caches;
        List<Endpoint> endpoints = hcp.endpoints;
        List<Video> videos = hcp.videos;
        List<Request> requests = hcp.requests;

        System.out.println("c nb : " + caches.size());
        System.out.println("e nb : " + endpoints.size());
        System.out.println("v nb : " + videos.size());
        System.out.println("r nb : " + requests.size());




    }

}
