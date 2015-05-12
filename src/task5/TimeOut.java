package task5;

import java.sql.Time;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/8/15.
 */
public class TimeOut {
  public final Object value;
  public final long lastUsed;

  public TimeOut(Object value, long lastUsed) {
    this.value=value;
    this.lastUsed=lastUsed;
  }
}
