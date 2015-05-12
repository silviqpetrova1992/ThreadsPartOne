package task5;

import java.util.Hashtable;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/8/15.
 */
public class TimeOutHashTable {
  //Sled kato hashtable e concurrent nujno li e da slagame synchronized?
  public final Hashtable<String, TimeOut> table = new Hashtable<String, TimeOut>();

  public synchronized void put(String key, Object value) {
    TimeOut obj = new TimeOut(value, System.currentTimeMillis());
    table.put(key, obj);
  }

  public synchronized Object get(String key) {

    if (table.containsKey(key)) {
      table.put(key, new TimeOut(table.get(key).value, System.currentTimeMillis()));
      return table.get(key);
    } else {
      return null;
    }
  }

  public synchronized Object remove(String key) {
    if (table.containsKey(key)) {
      return table.remove(key);
    } else {
      return null;
    }
  }

  public synchronized void print() {
    for (Object obj : table.values()) {
      System.out.println(((TimeOut) obj).value + " last use " + ((TimeOut) obj).lastUsed);
    }
  }

  public static void main(String[] args) throws InterruptedException {
    TimeOutHashTable example = new TimeOutHashTable();
    Thread t = new Thread(new ElementsRemover(example,3));
    t.start();
    System.out.println("slagame 1");
    example.put("1", "value1");
    Thread.sleep(1000);
    System.out.println("slagame 2");
    example.put("2", "value2");
    Thread.sleep(1000);
    System.out.println("slagame 3");
    example.put("3", "value3");
    System.out.println("Using 1");
    example.get("1");
    Thread.sleep(1000);
    System.out.println("slagame 4");
    example.put("4", "value4");
    Thread.sleep(1000);
    System.out.println("slagame 5");
    example.put("5", "value5");
    System.out.println("Using 1");
    example.get("1");
    Thread.sleep(1000);
    System.out.println("slagame 6");
    example.put("6", "value6");
    Thread.sleep(1000);
    System.out.println("slagame 7");
    example.put("7", "value7");
    System.out.println("Using 1");
    example.get("1");
    Thread.sleep(1000);
    System.out.println("slagame 8");
    example.put("8", "value8");
    Thread.sleep(1000);
    System.out.println("slagame 9");
    example.put("9", "value9");
    System.out.println("Using 1");
    example.get("1");
    Thread.sleep(1000);
    System.out.println("slagame 10");
    example.put("10", "value10");
    example.print();
    t.interrupt();
  }
}
