package task2;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/7/15.
 */
public class Counters implements Runnable {

  private final int from;
  private final int to;

  public Counters(int from, int to) {

    this.from = from;
    this.to = to;
  }

  @Override
  public void run() {

    for (int i = from; i <= to; i++) {
      if (Thread.currentThread().isInterrupted()) {
        break;
      }
      System.out.println(Thread.currentThread().getName() + " -> " + i);
    /*  try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        break;
      }*/
    }
  }

  public static void main(String[] args) throws InterruptedException {
    Thread t = new Thread(new Counters(10,12));
    t.start();
    for (int j = 20; j <= 30; j++) {
      if (!t.isAlive()) {
        break;
      }
      System.out.println(Thread.currentThread().getName() + " -> " + j);
     // t.join(1000);
    }
    t.interrupt();
  }
}
