package Task2;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue implements Queue {
    static BlockingQueue bq = new BlockingQueue();
    Queue<Object> q = new LinkedList<Object>();

    Object lock = new Object();

    private BlockingQueue() {
    }

    public static BlockingQueue getQueue() {

        return bq;
    }

    @Override
    public boolean addAll(Collection arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean contains(Object arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsAll(Collection arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterator iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean remove(Object arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeAll(Collection arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean retainAll(Collection arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object[] toArray(Object[] arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean add(Object arg0) {

        synchronized (lock) {

            q.add(arg0);
            lock.notifyAll();

        }

        System.out.println("Add is complete...!");

        return false;
    }

    @Override
    public Object element() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean offer(Object arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Object peek() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object poll() {
        System.out.println(q.isEmpty());
        while (q.isEmpty() == true) {
            synchronized (lock) {
                try {

                    lock.wait();

                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        System.out.println(q.poll());
        return false;
    }

    @Override
    public Object remove() {
        // TODO Auto-generated method stub
        return null;
    }

}
