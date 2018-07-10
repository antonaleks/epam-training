package t1;

import static lombok.AccessLevel.PRIVATE;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = PRIVATE)
@AllArgsConstructor
public class OperatorDepositConc implements Runnable {

    Account account;
    List<BigDecimal> balances;
    static Lock lock = new ReentrantLock();

    public void run() {
        for (BigDecimal balance : balances) {
            lock.lock();
            account.deposit(balance);
            lock.unlock();
        }
    }
}
