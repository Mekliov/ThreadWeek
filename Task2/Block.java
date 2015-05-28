package Task2;

import java.util.Random;

public class Block implements Runnable {

    @SuppressWarnings("static-access")
    @Override
    public void run() {

        BlockingQueue bq1 = BlockingQueue.getQueue();
        Random rd = new Random();
        for(int i=0;i<20;i++) {

            bq1.add(i);
            
            if (bq1.q.size() >= 6) {
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
