package t1;

import static lombok.AccessLevel.PRIVATE;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = PRIVATE)
public class Operator {

    protected static Lock lock = new ReentrantLock();
}
