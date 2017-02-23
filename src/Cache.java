import java.util.ArrayList;
import java.util.List;

/**
 * Created by nandane on 23/02/17.
 */
public class Cache {

    int id;
    int limitSize;
    List<Video> videos = new ArrayList<>();

    public Cache(int id, int limitSize) {
        this.id = id;
        this.limitSize = limitSize;
    }
}
