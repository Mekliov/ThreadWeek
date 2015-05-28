package Task2;

import java.util.Random;

public class Block1 implements Runnable {
    @SuppressWarnings("static-access")
    @Override
    public void run() {
        Random rd = new Random();
        BlockingQueue bq2 = BlockingQueue.getQueue();
       for(int i=0;i<20;i++) {
            bq2.poll();
            if (bq2.q.isEmpty()) {
                try {
                    Thread.currentThread().sleep(rd.nextInt(1000));
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }

}
