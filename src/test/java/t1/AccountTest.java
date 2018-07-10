package t1;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import lombok.val;
import org.junit.Test;

public class AccountTest {

    @Test
    public void testAccountTransactions() throws IOException, InterruptedException {
        Account acc1 = new Account("4321123443211234", new BigDecimal(15000));
        Account acc2 = new Account("1234123412341234", new BigDecimal(15000));
        List<String> text = Files.readAllLines(Paths.get("src/main/resources/transaction.txt"));
        List<BigDecimal> bigDecimals1 = new ArrayList<>();
        List<BigDecimal> bigDecimals2 = new ArrayList<>();
        fillBigDecimals(acc1, text, bigDecimals1, bigDecimals2);
        OperatorDeposit opD1 = new OperatorDeposit(acc1, bigDecimals1);
        OperatorWithdraw opW1 = new OperatorWithdraw(acc1, bigDecimals2);
        OperatorDeposit opD2 = new OperatorDeposit(acc2, bigDecimals2);
        OperatorWithdraw opW2 = new OperatorWithdraw(acc2, bigDecimals1);
        opD1.start();
        opD2.start();
        opW1.start();
        opW2.start();
        opD1.join();
        opW1.join();
        opD2.join();
        opW2.join();
        System.out.println(acc1.getBalance());
        System.out.println(acc2.getBalance());
        System.out.println();
    }

    @Test
    public void testAccountTransactionsConcurrent()
        throws IOException, InterruptedException, ExecutionException {
        val acc1 = new AccountConc("4321123443211234", new BigDecimal(15000));
        val acc2 = new AccountConc("1234123412341234", new BigDecimal(15000));
        List<String> text = Files.readAllLines(Paths.get("src/main/resources/transaction.txt"));
        List<BigDecimal> bigDecimals1 = new ArrayList<>();
        List<BigDecimal> bigDecimals2 = new ArrayList<>();
        fillBigDecimals(acc1, text, bigDecimals1, bigDecimals2);
        Thread thread1 = new Thread(new OperatorDepositConc(acc1, bigDecimals1));
        Thread thread2 = new Thread(new OperatorWithdrawConc(acc1, bigDecimals2));
        Thread thread3 = new Thread(new OperatorDepositConc(acc2, bigDecimals2));
        Thread thread4 = new Thread(new OperatorWithdrawConc(acc2, bigDecimals1));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        System.out.println(acc1.getBalance());
        System.out.println(acc2.getBalance());
        System.out.println();
    }

    private void fillBigDecimals(Acc acc1, List<String> text, List<BigDecimal> bigDecimals1,
        List<BigDecimal> bigDecimals2) {
        for (String row : text) {
            String[] textArr = row.split(" ");
            if (textArr[0].equals(acc1.getNumber())) {
                bigDecimals1.add(new BigDecimal(textArr[2]));
            } else {
                bigDecimals2.add((new BigDecimal(textArr[2])));
            }
        }
    }

}