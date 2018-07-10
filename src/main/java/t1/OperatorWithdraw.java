package t1;

import static lombok.AccessLevel.PRIVATE;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = PRIVATE)
@AllArgsConstructor
public class OperatorWithdraw extends Thread {

    Account account;
    List<BigDecimal> balances;

    public void run() {
        for (BigDecimal balance : balances) {
            synchronized (account) {
                account.withdraw(balance);
            }
        }
    }
}
