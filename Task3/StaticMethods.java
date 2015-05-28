package paralelMinimalPointCalculations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class StaticMethods {

    public static List<Point> generatePoints() {

        Random rand = new Random();
        List<Point> list = new ArrayList<Point>();
        for (int number = 0; number < 100_000; number++) {
            list.add(new Point(rand.nextInt(10_000) + 1, rand.nextInt(10_000) + 1));
        }
        return list;
    }

    public static Map<Point, Point> getNearestPoints(List<Point> generatedPoints) {
        Map<Point, Point> map = new HashMap<Point, Point>();
        Thread t1 = new Thread(new Threads(generatedPoints, 0, generatedPoints.size() / 2, map));
        Thread t2 = new Thread(new Threads(generatedPoints, generatedPoints.size() / 2, generatedPoints.size(), map));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void doCalculations(List<Point> inPoints, int indexFrom, int indexTo, Map<Point, Point> outMap) {
        for (int i = indexFrom; i < indexTo; i++) {
            int current = 0;
            int nearest = Integer.MAX_VALUE;
            for (int j = inPoints.size() - 1; j >= 0; j--) {
                if (i != j) {
                    int distance = (Math.abs(inPoints.get(i).getX() - inPoints.get(j).getX()))
                            + (Math.abs(inPoints.get(i).getY() - inPoints.get(j).getY()));
                    if (nearest > distance) {
                        nearest = distance;
                        current = j;
                    }
                }
            }
            outMap.put(inPoints.get(i), inPoints.get(current));
        }
    }

    public static void printMap(Map<Point, Point> map) {
        for (Map.Entry<Point, Point> entry : map.entrySet()) {
            System.out.println(entry.getKey().toString() + " nearest to " + entry.getValue().toString());
        }
    }
}
