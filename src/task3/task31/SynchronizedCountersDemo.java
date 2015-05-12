package task3.task31;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/8/15.
 */
public class SynchronizedCountersDemo {
  public static void main(String[] args) {
    Object lock = new Object();
    Thread counter1 = new Thread(new Counter(1, 200, lock));
    Thread counter2 = new Thread(new Counter(5, 100, lock));
    counter1.start();
    counter2.start();
  }

}

class Counter implements Runnable {
  public static boolean flag = true;
  private final int from;
  private final int to;
  private final Object lock;

  public Counter(int from, int to, Object lock) {

    this.from = from;
    this.to = to;
    this.lock = lock;
  }

  @Override
  public void run() {
    synchronized (lock) {
      for (int i = from; i <= to; i++) {
        System.out.println(Thread.currentThread().getName() + " " + i);
        lock.notify();
        if (i==to||!flag) {
          break;
        }

        try {
          lock.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      flag = false;
    }
  }
}
