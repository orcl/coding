/* producer consumer problem:
 */


public class ProducerConsumer {

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

}//end ProducerConsumer


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


class Q {
    private Queue<Integer> q;
    private final int limit;
    public Q(int limit) {
        this.q = new LinkedList<>();
        this.limit = limit;
    }

    public synchronized void put(Integer ele) {
        //synchronized(this)
        while (q.size() == limit) {
            wait();   //this.wait();
        }
        if (q.size() == 0) {
            notifyAll();
        }
        q.offer(ele);
    }

    public synchronized Integer take() {
        while (q.size() == 0) {
            wait(); //wait() release the lock();
        }
        if (q.size(0 == limit) {
            notifyAll();
        }
        return q.poll();
    }
}


//pretty good, right? however, why the producer and the consumer wait on the same condition?
//this is hard to understand.
//






