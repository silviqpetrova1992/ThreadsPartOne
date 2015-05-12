package task3.task32;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/11/15.
 */
public class CounterDemo {
  public static void main(String[] args) {
    Object lock = new Object();
    Counter c = new Counter(1, 200, lock);
    Counter c1 = new Counter(5, 100, lock);
    c.set(c1);
    c1.set(c);


    // counter1.setPriority(Thread.MIN_PRIORITY);
    //counter2.setPriority(Thread.MAX_PRIORITY);
    c.start();
    c1.start();
  }
}

class Counter extends Thread {

  private final int from;
  private final int to;
  private Counter th;
  private Object lock;

  public Counter(int from, int to, Object lock) {

    this.from = from;
    this.to = to;
    this.lock = lock;
  }

  public void set(Counter th) {

    this.th = th;
  }

  @Override
  public void run() {
    synchronized (lock) {

      for (int i = from; i <= to; i++) {
        lock.notifyAll();
        if (Thread.currentThread().isInterrupted()) {
          return;
        }
        System.out.println(Thread.currentThread().getName() + "-" + i);

        try {
          if (i != to) {
            lock.wait();
          }
        } catch (InterruptedException e) {
        }
      }
      th.interrupt();
    }
  }
}
