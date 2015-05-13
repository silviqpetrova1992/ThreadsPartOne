package task5.task52;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/12/15.
 */
public class ElementRemover implements Runnable {
  private TimeOutHashTable table;
   private String key;
  private int countTo;

  public ElementRemover(TimeOutHashTable table, String key, int countTo) {
    this.table = table;
    this.key = key;
    this.countTo = countTo;
  }

  @Override
  public void run() {
    for(int i=1;i<=countTo;i++){
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        return;
      }
    }
    table.remove(key);
  }
}
