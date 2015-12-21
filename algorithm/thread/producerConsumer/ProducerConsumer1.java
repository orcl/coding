/* problem2:
 */


public class ProducerConsumer1 {

    public static void main(String[] args) {
    
        Q q = new Q();
        List<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < 100; i++) {
            threads.add(new Thread(new Producer(q)));
        }
        for (int i = 0; i < 100; i++) {
            threads.add(new Thread(new Consumer(q)));
        }
        for (Thread t: threads) {
            t.start();
        }
    }
}//end class ProducerConsumer1


class Producer implements Runnable {
    Q q;
    public Producer(Q q) {
        super();
        this.q = q;
    }
    @Override
    public void run() {
        q.put(0);
    }
}


class Consumer implements Runnable {
    Q q;
    public Consumer(Q q) {
        super();
        this.q = q;
    }
    @Override
    public void run() {
        System.out.println(q.take());
    }
}

//because each object is only associated with one condition. 
//when q.size() == 0, the condition is "queue empty". when q.size() == limit, the condition is "queue full".
//we can decouple these two conditions by the Condition class associated with a Lock:
//
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Q {
    private Queue<Integer> q;
    private final int limit;
    private Lock lock;
    private Condition full;
    private Condition empty;

    public Q(int limit) {
        this.q = new LinkedList<>();
        this.limit = limit;
        this.lock = new ReentrantLock();
        this.full = lock.newCondition();
        this.empty = lock.newCondition();
    }


    public void put(integer ele) {
        lock.lock();
        try {
            while (q.size() == limit) {
                full.await();
            }
            if (q.size() == 0) {
                empty.signalAll();
            }
            q.offer(ele);
        }catch(Exception e) {
            //ignore
        }finally {
            lock.unlock();
        }
    }


    public Integer take() {
        lock.lock();
        try {
            while (q.size() == 0) {
                empty.await();
            }
            if (q.size() = limit) {
                full.signalAll();
            }
            return q.poll();
        }catch(Exception e) {
            //ignore
        }finally {
            lock.unlock();
        }
    }


}




