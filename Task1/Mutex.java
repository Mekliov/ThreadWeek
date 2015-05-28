package Task1;

public class Mutex {
    private Object lock = new Object();
    private Thread t;

    public void aquire() throws InterruptedException {
        while (t != null) {

            lock.wait();
        }
        if (t == null) {
            t = Thread.currentThread();
        }
    }

    public void release() {
        t = null;
        synchronized (lock) {
            lock.notifyAll();
        }

    }
}
