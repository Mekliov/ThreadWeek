package paralelMinimalPointCalculations;

public class MainClass {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        StaticMethods.printMap(StaticMethods.getNearestPoints(StaticMethods.generatePoints()));
        System.out.println(System.currentTimeMillis() - start);
    }
}
