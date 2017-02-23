import java.io.*;
import java.util.List;

/**
 * Created by nandane on 23/02/17.
 */
public class Helper {

    public HashCodeProblem loadProblem(File pizzaFile) {

        DataCenter dc;
        List<Cache> caches;
        List<Endpoint> endpoints;
        List<Video> videos;
        int videoCount;
        int endPointCount;
        int requestCount;
        int cacheCount;
        int cacheSize;

        try {
            FileInputStream fStream = new FileInputStream(pizzaFile);
            BufferedReader in = new BufferedReader(new InputStreamReader(fStream));
            boolean firstline = true;

            while (in.ready()) {
                String line = in.readLine();

                if (firstline) {
                    String[] data = line.split(" ");
                    videoCount = Integer.parseInt(data[0]);
                    endPointCount = Integer.parseInt(data[1]);
                    requestCount = Integer.parseInt(data[2]);
                    cacheCount = Integer.parseInt(data[3]);
                    cells = new int[rows][cols];
                    firstline = false;
                } else {
                    char[] data = line.toCharArray();
                    for (int k = 0; k < data.length; k++) {
                        int val;
                        if (data[k] == 'T') val = 0;
                        else val = 1;
                        cells[counter][k] = val;
                    }
                    counter++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Pizza(rows, cols, minOfEach, maxCells, cells);
    }
}
