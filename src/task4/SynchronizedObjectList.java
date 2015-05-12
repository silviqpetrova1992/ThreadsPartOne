package task4;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/7/15.
 */
public class SynchronizedObjectList {
  private int n = 0;
  private Object[] array;

  /**
   * Constructor with one parameter
   *
   * @param n The length of the array.
   */
  public SynchronizedObjectList(int n) {
    this.array = new Object[n];
  }

  /**
   * Add an Object to the list
   *
   * @param obj The object that we want to add.
   */
  public synchronized void add(Object obj)  {
    while(n >= array.length){
      try {
        wait();
      } catch (InterruptedException e) {
      }
    }
    array[n] = obj;
    System.out.println("put "+obj);
    n++;
    notifyAll();
  }

  /**
   * Remove an element from the list
   */
  public synchronized void remove(){
    while(n==0){
      try {
        wait();
      } catch (InterruptedException e) {
      }
    }
    System.out.println("delete "+array[n-1]);
    n--;
    notifyAll();
  }

  /**
   * Print the list.
   */
  public synchronized void printAllElements() {
    for (int i = 0; i < n; i++) {
      System.out.println(array[i]);
    }
  }
}
