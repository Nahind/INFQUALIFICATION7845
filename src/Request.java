/**
 * Created by nandane on 23/02/17.
 */
public class Request {

    int id;
    int requestVideoId;
    int requestEndpointId;
    int requestNumber;

    public Request(int id, int requestVideoId, int requestEndpointId, int requestNumber) {
        this.id = id;
        this.requestVideoId = requestVideoId;
        this.requestEndpointId = requestEndpointId;
        this.requestNumber = requestNumber;
    }
}
