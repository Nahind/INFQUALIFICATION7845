import java.util.ArrayList;
import java.util.List;

/**
 * Created by nandane on 23/02/17.
 */
public class Cache implements Comparable{

    int id;
    int limitSize;
    int remainingSize;
    List<Video> videos = new ArrayList<>();

    public Cache(int id, int limitSize) {
        this.id = id;
        this.limitSize = limitSize;
        remainingSize = limitSize;
    }


    public Boolean addVideo(Video v) {
        Boolean success = false;
        int videoSize = v.getSize();

        if (remainingSize - videoSize >= 0) {
            success = true;
            remainingSize = remainingSize - videoSize;
        } else {

        }

        return success;
    }

    public int getId() {
        return id;
    }

    public int getLimitSize() {
        return limitSize;
    }

    public int getRemainingSize() {
        return remainingSize;
    }

    public List<Video> getVideos() {
        return videos;
    }

    @Override
    public int compareTo(Object o) {

        return 0;
    }
}
