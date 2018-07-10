package t1;

import static lombok.AccessLevel.PRIVATE;

import java.math.BigDecimal;
import lombok.Value;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

@FieldDefaults(level = PRIVATE)
@Value
public class AccountConc extends Acc {

    String number;
    @NonFinal
    BigDecimal balance;

    public AccountConc(String number, BigDecimal balance) {
        this.number = number;
        this.balance = balance;
    }


    public void deposit(BigDecimal amount) {
        BigDecimal x = balance.add(amount);
        balance = x;
    }

    public void withdraw(BigDecimal amount) {
        BigDecimal x = balance.subtract(amount);
        balance = x;
    }

}
