package task5.task52;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/13/15.
 */
public class Demo1 {
  public static void main(String[] args) throws InterruptedException {
    TimeOutHashTable<String,String> example=new TimeOutHashTable<String,String>(3);
    System.out.println("postavqme 1");
    example.put("1","element1");
    Thread.sleep(1000);
    System.out.println("postavqme 2");
    example.put("2","element2");
    Thread.sleep(1000);
    example.get("1");
    Thread.sleep(1000);
    System.out.println("postavqme 3");
    example.put("3","element3");
    Thread.sleep(1000);
    example.get("1");
    Thread.sleep(1000);
    System.out.println("postavqme 4");
    example.put("4","element4");
    Thread.sleep(1000);
    example.get("1");
    Thread.sleep(1000);
    System.out.println("postavqme 5");
    example.put("5","element5");
    Thread.sleep(1000);
    example.closeThreads();
  }
}
