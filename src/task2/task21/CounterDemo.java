package task2.task21;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/7/15.
 */
public class CounterDemo {


  public static void main(String[] args) {
    Thread counter1 = new Thread(new Counter(1, 200));
    Thread counter2 = new Thread(new Counter(5, 100));
   // counter1.setPriority(Thread.MIN_PRIORITY);
    //counter2.setPriority(Thread.MAX_PRIORITY);
    counter1.start();
    counter2.start();
  }

}

class Counter implements Runnable {
  public static boolean flag = true;
  private final int from;
  private final int to;

  public Counter(int from, int to) {

    this.from = from;
    this.to = to;
  }

  @Override
  public void run() {
    for (int i = from; i <= to;i++) {
      if (!flag){
        break;
      }
        System.out.println(Thread.currentThread().getName() + " " + i);
    }
    flag=false;
  }
}