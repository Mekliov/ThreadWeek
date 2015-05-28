package paralelMinimalPointCalculations;

import java.util.List;
import java.util.Map;

public class Threads implements Runnable {

    private int indexFrom;
    private int indexTo;
    private List<Point> inPoints;
    private Map<Point, Point> outMap;

    public Threads(List<Point> inPoints, int indexFrom, int indexTo, Map<Point, Point> outMap) {
        this.indexFrom = indexFrom;
        this.indexTo = indexTo;
        this.inPoints = inPoints;
        this.outMap = outMap;
    }

    @Override
    public void run() {
        synchronized (this) {
            StaticMethods.doCalculations(inPoints, indexFrom, indexTo, outMap);
        }
    }
}
