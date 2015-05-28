package Task2;

public class QueueExample {

    public static void main(String[] args) {
        Thread t2 = new Thread(new Block1());
        Thread t1 = new Thread(new Block());
        t1.start();
        t2.start();
    }

}
