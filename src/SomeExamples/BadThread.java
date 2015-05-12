package SomeExamples;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/12/15.
 */
public class BadThread {
  static String message;

  private static class CorrectorThread
          extends Thread {

    public void run() {
      try {
        sleep(1000);
      } catch (InterruptedException e) {}
      // Key statement 1:
      message = "Mares do eat oats.";
    }
  }

  public static void main(String args[])
          throws InterruptedException {

    (new CorrectorThread()).start();
    message = "Mares do not eat oats.";
    Thread.sleep(2000);
    // Key statement 2:
    System.out.println(message);
  }
}
