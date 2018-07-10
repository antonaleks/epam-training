package t1;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
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
        Account acc1 = new Account("4321123443211234", new BigDecimal(15000));
        Account acc2 = new Account("1234123412341234", new BigDecimal(15000));
        List<String> text = Files.readAllLines(Paths.get("src/main/resources/transaction.txt"));
        List<BigDecimal> bigDecimals1 = new ArrayList<>();
        List<BigDecimal> bigDecimals2 = new ArrayList<>();
        fillBigDecimals(acc1, text, bigDecimals1, bigDecimals2);
        ExecutorService ex1 = Executors.newCachedThreadPool();
        Future s1 = ex1.submit(new OperatorDepositConc(acc1, bigDecimals1));
        Future s2 = ex1.submit(new OperatorWithdrawConc(acc1, bigDecimals2));
        Future s3 = ex1.submit(new OperatorDepositConc(acc2, bigDecimals2));
        Future s4 = ex1.submit(new OperatorWithdrawConc(acc2, bigDecimals1));
        s4.get();
        s3.get();
        s2.get();
        s1.get();

        System.out.println(acc1.getBalance());
        System.out.println(acc2.getBalance());
        System.out.println();
    }

    private void fillBigDecimals(Account acc1, List<String> text, List<BigDecimal> bigDecimals1,
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