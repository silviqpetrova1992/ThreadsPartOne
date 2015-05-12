package SomeExamples;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/8/15.
 */
public class example1 {
    public static void main(String[] args) {
      ThreadB b = new ThreadB();
      b.start();

      System.out.println("Total is: " + b.total);

    }
  }

  class ThreadB extends Thread {
    int total;

    @Override
    public void run() {
      for (int i = 0; i < 100; i++) {
        total += i;
      }
    }
  }

