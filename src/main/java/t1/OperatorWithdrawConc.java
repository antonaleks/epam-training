package t1;

import static lombok.AccessLevel.PRIVATE;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = PRIVATE)
@AllArgsConstructor
public class OperatorWithdrawConc extends Operator implements Runnable {

    AccountConc account;
    List<BigDecimal> balances;

    public void run() {

        for (BigDecimal balance : balances) {
            lock.lock();
            account.withdraw(balance);

            lock.unlock();
        }
    }
}
