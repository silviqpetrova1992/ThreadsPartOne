package task5.task52;

import java.util.Hashtable;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/12/15.
 */
public class TimeOutHashTable {
  private Hashtable<String,ElementRemover> table=new Hashtable<String,ElementRemover>();
  private int count;

  public TimeOutHashTable(int count) {
    this.count = count;
  }

  public void put(String key){
    if(table.containsKey(key)){
      table.get(key).reset();
      return;
    }
    ElementRemover thread=(new ElementRemover(this,key, count));
    table.put(key, thread);
    thread.start();
  }
  public Object get(String key){
    if(table.containsKey(key)){
      table.get(key).reset();
      return table.get(key);
    }
    return null;
  }
  public Object remove(String key){
    if(table.containsKey(key)){
      System.out.println("remove"+key);
      table.remove(key);
    }
    return null;
  }
  public  void closeThreads(){
    for(Thread th:table.values()){
      th.interrupt();
    }
  }
}
