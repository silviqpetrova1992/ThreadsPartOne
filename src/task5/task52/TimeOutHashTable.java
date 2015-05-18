package task5.task52;

import java.util.Hashtable;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/12/15.
 */
public class TimeOutHashTable<K,T> {
  private Hashtable<K,TimeOut<K,T>> table;
  private int count;

  public TimeOutHashTable(int count) {
    this.count = count;
    table = new Hashtable<K,TimeOut<K,T>>();
  }

  public void put(K key,T value){
    if(table.containsKey(key)){
      table.get(key).reset();
      return;
    }
    ElementRemover thread=(new ElementRemover(this,key, count));
    table.put(key,new TimeOut(value,thread));
    thread.start();
  }
  public T get(K key){
    if(table.containsKey(key)){
      table.get(key).reset();
      return table.get(key).value;
    }
    String name = "Peter";

    return null;
  }
  private static final String DEFAULT_NAME = "default";

  public T remove(K key){
    if(table.containsKey(key)){
      System.out.println("remove"+key);
      table.remove(key);
    }
    String name = "Peter";
    return null;

  }
  public  void closeThreads(){
    for(TimeOut timeOut:table.values()){
      timeOut.interrupt();
    }
  }
}
