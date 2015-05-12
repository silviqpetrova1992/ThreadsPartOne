package task2.task22;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/11/15.
 */
public class CounterDemo {
  public static void main(String[] args) {
    Counter c=new Counter(1, 200);
    Counter c1=new Counter(5, 100);
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

  public Counter(int from, int to) {

    this.from = from;
    this.to = to;
  }

  public void set(Counter th) {

    this.th = th;
  }

  @Override
  public void run() {
    for(int i=from;i<=to;i++){
      if(Thread.currentThread().isInterrupted()){
        return;
      }
      System.out.println(Thread.currentThread().getName()+"-"+i);
    }
th.interrupt();
  }
}
