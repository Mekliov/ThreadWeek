package Task1;

public class Threads implements Runnable {
    Mutex mutex = new Mutex();
    MyInteger integer = new MyInteger(0);
    int count = 0;
    String name;

    public Threads(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        for (int i = 0; i < 200; i++) {

            try {
                mutex.aquire();

                // incrementMethod();

            } catch (InterruptedException e) {

                e.printStackTrace();
            } catch (IllegalMonitorStateException e) {

                e.printStackTrace();
            }

            System.out.println(integer.increment() + "  " + name);
            mutex.release();

        }
    }

    public void incrementMethod() {
        count++;
        System.out.println(count + "    " + name);
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Threads("T1"));
        Thread t2 = new Thread(new Threads("T2"));
        t1.start();
        t2.start();

    }
}
