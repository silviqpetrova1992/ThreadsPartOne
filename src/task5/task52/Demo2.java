package task5.task52;


/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/13/15.
 */
public class Demo2 implements Runnable {
  private final int from;
  private final int to;
  private final TimeOutHashTable table;
  private final Object lock;

  public Demo2(int from, int to, TimeOutHashTable table, Object lock) {
    this.from = from;
    this.to = to;
    this.table = table;
    this.lock = lock;
  }

  @Override
  public  void run() {
    synchronized (lock) {
      for (int i = from; i <= to; i++) {

        System.out.println("postavqme " + i);
        table.put(String.valueOf(i),String.valueOf(i)+"element");

        try {
          Thread.sleep(1000);
          lock.notifyAll();
          lock.wait();
        } catch (InterruptedException e) {
          return;
        }
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    TimeOutHashTable example = new TimeOutHashTable(5);
    Object lock=0;
    Thread th1 = (new Thread(new Demo2(1, 4, example, lock)));
    Thread th2 = (new Thread(new Demo2(3, 8, example, lock)));
    th1.start();
    th2.start();
    Thread.sleep(10000);
    th1.interrupt();
    th2.interrupt();
    example.closeThreads();
  }
}
