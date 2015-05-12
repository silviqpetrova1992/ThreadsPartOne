package task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/5/15.
 */
public class Counter implements Runnable {
  private int i = 1;
  private int max;

  /**
   * Initialize the max value,where the counting have to stop.
   * @param max The max value.
   */
  public Counter(int max) {
    this.max = max;
  }

  /**
   * The run method of the thread, which is counting to "max".
   */
  @Override
  public void run() {
    while (true) {
      try {
        Thread.sleep(1000);
        if (i < max) {
          i++;
        } else {
        }
      } catch (InterruptedException e) {
        System.out.println("This took " + i + " seconds!");
        break;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    Counter counter = new Counter(5);
    Thread t = new Thread(counter);
    t.start();
    System.out.println(System.in.read());
    t.interrupt();
  }
}
