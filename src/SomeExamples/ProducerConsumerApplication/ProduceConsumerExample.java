package SomeExamples.ProducerConsumerApplication;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/5/15.
 */
public class ProduceConsumerExample {
  public static void main(String[] args) {
    Drop drop = new Drop();
    (new Thread(new Producer(drop))).start();
    (new Thread(new Consumer(drop))).start();
  }
}
