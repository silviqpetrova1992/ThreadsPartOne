package task4.task41;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 3/21/15.
 */
public class ObjectListDemo {

  public static void main(String[] args) throws InterruptedException {
   BlockingQueue bq=new ArrayBlockingQueue(3);
    Thread add = new Thread(new AddThread(bq));
    Thread remove = new Thread(new RemoveThread(bq));
    add.start();
    add.join(1000);
    remove.start();
  }
}

class AddThread implements Runnable {
  private final BlockingQueue list;

  public AddThread(BlockingQueue list) {
    this.list = list;
  }
  @Override
  public void run() {

    try {
      System.out.println("put A");
      list.put("A");
      System.out.println(list.toString());
      System.out.println("put B");
      list.put("B");
      System.out.println(list.toString());
      System.out.println("put C");
      list.put("C");
      System.out.println(list.toString());
      System.out.println("put D");
      list.put("D");
      System.out.println(list.toString());
      System.out.println("put E");
      list.put("E");
      System.out.println(list.toString());
      System.out.println("put F");
      list.put("F");
      System.out.println(list.toString());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class RemoveThread implements Runnable {
  private final BlockingQueue list;

  public RemoveThread(BlockingQueue list) {
    this.list = list;
  }
  @Override
  public void run() {

    try {
      System.out.println("take");
      list.take();
      System.out.println(list.toString());
      System.out.println("take");
      list.take();
      System.out.println(list.toString());
      System.out.println("take");
      list.take();
      System.out.println(list.toString());
      System.out.println("take");
      list.take();
      System.out.println(list.toString());
      System.out.println("take");
      list.take();
      System.out.println(list.toString());
      System.out.println("take");
      list.take();
      System.out.println(list.toString());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }


  }
}