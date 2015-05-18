package task5.task52;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/8/15.
 */
public class TimeOut<K,T> {
  public final T value;
  public final ElementRemover<K> elementRemover;

  public TimeOut(T value, ElementRemover<K> elementRemover) {
    this.value=value;
    this.elementRemover = elementRemover;
  }

  public void reset() {
    elementRemover.reset();
  }

  public void interrupt() {
    elementRemover.interrupt();
  }
}
