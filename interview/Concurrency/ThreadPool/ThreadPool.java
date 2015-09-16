/* Thread pools
 * Thread pools are useful when you need to limit the number of threads running in your application at the same time.
 * there is a performance overhead associated with starting a new thread, and each thread is also allocated some memory for its stack etc.
 *
 * instead of starting a new thread for every task to execute concurrently, the task can be passed to a thread pool. 
 * as soon as the pool has any idle threads the task is assigned to one of them and executed. 
 * internally the tasks are inserted into a blocking queue which the threads in the pool are dequeue from. when a new task is inserted into the queue one of the idle threads 
 * will dequeue it successfully and execute it. the rest of the idle threads in the pool will be blocked waiting to dequeue tasks.
 *
 * Thread pools are often used in multi threaded servers. each connection arriving at the server via the network is wrapped as a task and passed on to a thread pool
 * the threads in the thread pool will process the requests on the connections concurrently. 
 * a later trail will get into the detail about implementing multithreaded servers in java.
 *
 *
 *
 *
 */


public class ThreadPool {
  
  private BlockingQueue taskQueue = null;
  private List<PoolThread> threads = new ArrayList<PoolThread>();
  private boolean isStopped = false;

  public ThreadPool(int noOfThreads, int maxNoOfTasks) {
    taskQueue = new BlockingQueue(maxNoOfTasks);

    for (int i = 0; i < noOfThreads; i++) {
      threads.add(new PoolThread(taskQueue));
    }
    for (PoolThread thread: threads) {
      thread.start();
    }
  }

  public synchronized void execute(Runnable task) throws Exception {
  
    if (this.isStopped) throw new IllegalStateException("ThreadPool is stopped");


    this.taskQueue.enqueue(task);
  }

  public synchronized void stop() {
    this.isStopped = true;
    for (PoolThread thread: threads) {
      thread.stop();
    }
  }

}//end class ThreadPool














