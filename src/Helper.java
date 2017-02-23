import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nandane on 23/02/17.
 */
public class Helper {

    public static HashCodeProblem loadProblem(File hashCodeFile) {

        DataCenter dc = null;
        List<Cache> caches = null;
        List<Endpoint> endpoints = null;
        List<Video> videos = null;
        List<Request> requests = null;

        int videoCount = 0;
        int endPointCount = 0;
        int requestCount = 0;
        int cacheCount = 0;
        int cacheSize = 0;

        int lineCounter = 0;
        int requestid = 0;


        try {
            FileInputStream fStream = new FileInputStream(hashCodeFile);
            BufferedReader in = new BufferedReader(new InputStreamReader(fStream));
            boolean firstline = true;

            while (in.ready()) {
                // System.out.println("line number = " + lineCounter);
                String line = in.readLine();
                lineCounter++;

                if (lineCounter == 1) {
                    String[] data = line.split(" ");
                    videoCount = Integer.parseInt(data[0]);
                    endPointCount = Integer.parseInt(data[1]);
                    requestCount = Integer.parseInt(data[2]);
                    cacheCount = Integer.parseInt(data[3]);
                    cacheSize = Integer.parseInt(data[4]);
                    firstline = false;

                    caches = new ArrayList<Cache>();
                    endpoints = new ArrayList<Endpoint>();
                    videos = new ArrayList<Video>();
                    requests = new ArrayList<Request>();


                } else if (lineCounter == 2) { // videos line
                    String[] data = line.split(" ");
                    for (int i = 0; i < videoCount; i++) {
                        Video v = new Video(i, Integer.parseInt(data[i]));
                        videos.add(v);
                    }
                } else if (lineCounter == 3) {

                    for (int i = 0; i < endPointCount; i++) {

                        String[] data = line.split(" ");
                        int endpointId = i;
                        int endpointLatencyToDataCenter = Integer.parseInt(data[0]);
                        int cacheNumber = Integer.parseInt(data[1]);
                        ArrayList<Cache> cachesOfThisEndpoint = new ArrayList<>();
                        Map<Cache, Integer> connectedCaches = new HashMap<>();
                        // System.out.println("cache number = " + cacheNumber);

                        for (int k = 0; k < cacheNumber; k++) {

                            line = in.readLine();
                            data = line.split(" ");
                            int cacheId = Integer.parseInt(data[0]);
                            int cacheLatency = Integer.parseInt(data[1]);
                            Cache c = new Cache(cacheId, cacheSize);
                            caches.add(c);
                            cachesOfThisEndpoint.add(c);
                            connectedCaches.put(c, cacheLatency);
                        }

                        Endpoint e = new Endpoint(i, endpointLatencyToDataCenter, connectedCaches);
                        endpoints.add(e);
                        if (cacheNumber > 0 && i != endPointCount - 1) line = in.readLine();
                    }

                    lineCounter++;


                } else if (lineCounter >= 4) { // requests line


                    String[] data = line.split(" ");
                    int requestVideoId = Integer.parseInt(data[0]);
                    int requestEndpointId = Integer.parseInt(data[1]);
                    int requestsNumber = Integer.parseInt(data[2]);
                    // System.out.println("lat = " + requestsNumber);
                    Request r = new Request(requestid, requestVideoId, requestEndpointId, requestsNumber);
                    requests.add(r);
                    Endpoint e = endpoints.get(requestEndpointId);
                    e.addRequest(r);
                    requestid++;

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new HashCodeProblem(dc, caches, endpoints, videos, requests);
    }

    public void printResult(String outputFileName, Solution solution) {

        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("./" + outputFileName));

            writer.write(solution.selectedCache.size());


            for (Cache c :solution.selectedCache) {
                writer.newLine();
                String format = "";
                format += c.getId();

                for (Video v : c.getVideos()) {

                    format += " " + v.getId();
                }

                writer.write(format);

            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
