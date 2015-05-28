package Task1;

public class ThraedsExample {

    public static void main(String[] args) throws InterruptedException {
        Integer count = new Integer(0);

        Thread t1 = new Thread(new Threads("T1"));
        Thread t2 = new Thread(new Threads("T2"));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("erer" + count);
    }

}
