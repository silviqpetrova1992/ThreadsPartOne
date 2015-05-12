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

  public static void main(String[] args) throws InterruptedException {
    TimeOutHashTable example=new TimeOutHashTable(3);
    System.out.println("postavqme 1");
    example.put("1");
    Thread.sleep(1000);
    System.out.println("postavqme 2");
    example.put("2");
    Thread.sleep(1000);
    example.get("1");
    Thread.sleep(1000);
    System.out.println("postavqme 3");
    example.put("3");
    Thread.sleep(1000);
    example.get("1");
    Thread.sleep(1000);
    System.out.println("postavqme 4");
    example.put("4");
    Thread.sleep(1000);
    example.get("1");
    Thread.sleep(1000);
    System.out.println("postavqme 5");
    example.put("5");
    Thread.sleep(1000);
    example.closeThreads();
  }
}
