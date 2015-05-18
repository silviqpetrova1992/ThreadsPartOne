package task5.task52;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/12/15.
 */
public class ElementRemover<K> extends Thread {
  private TimeOutHashTable table;
   private K key;
  private int countTo;
  private int count;

  public ElementRemover(TimeOutHashTable table, K key, int countTo) {
    this.table = table;
    this.key = key;
    this.countTo = countTo;
    this.count=1;
  }
  public void reset(){
    count=1;
  }

  @Override
  public void run() {
    for(count=1;count<=countTo;count++){
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        return;
      }
    }
    table.remove(key);
  }
}
