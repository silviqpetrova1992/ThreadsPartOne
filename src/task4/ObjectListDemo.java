package task4;


/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 3/21/15.
 */
public class ObjectListDemo {

  public static void main(String[] args) throws InterruptedException {
    SynchronizedObjectList ol = new SynchronizedObjectList(3);
    Thread add = new Thread(new AddThread(ol));
    Thread remove = new Thread(new RemoveThread(ol));
    add.start();
    add.join(3000);
    remove.start();
  }
}

class AddThread implements Runnable {
  private final SynchronizedObjectList list;

  public AddThread(SynchronizedObjectList list) {
    this.list = list;
  }

  @Override
  public void run() {

    list.add("A");
    list.printAllElements();
    list.add("B");
    list.printAllElements();
    list.add("C");
    list.printAllElements();
    list.add("D");
    list.printAllElements();
    list.add("E");
    list.printAllElements();
    list.add("F");
    list.printAllElements();
  }
}

class RemoveThread implements Runnable {
  private final SynchronizedObjectList list;

  public RemoveThread(SynchronizedObjectList list) {
    this.list = list;
  }

  @Override
  public void run() {

    list.remove();
    list.printAllElements();
    list.remove();
    list.printAllElements();
    list.remove();
    list.printAllElements();
    list.remove();
    list.printAllElements();
    list.remove();
    list.printAllElements();
    list.remove();
    list.printAllElements();

  }
}