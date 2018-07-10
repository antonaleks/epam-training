package t1;

import static lombok.AccessLevel.PRIVATE;

import java.math.BigDecimal;
import lombok.Value;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

@FieldDefaults(level = PRIVATE)
@Value
public class Account {

    String number;
    @NonFinal
    BigDecimal balance;

    public Account(String number, BigDecimal balance) {
        this.number = number;
        this.balance = balance;
    }

    Object lock = new Object();

    public void deposit(BigDecimal amount) {
        synchronized (lock) {
            BigDecimal x = balance.add(amount);
            balance = x;
        }
    }

    public void withdraw(BigDecimal amount) {
        synchronized (lock) {
            BigDecimal x = balance.subtract(amount);
            balance = x;
        }
    }

}
