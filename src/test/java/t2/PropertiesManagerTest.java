package t2;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.junit.Test;

public class PropertiesManagerTest {

    @Test
    public void testProps() throws ExecutionException, InterruptedException {
        ExecutorService ex1 = Executors.newCachedThreadPool();
        Future s1 = ex1.submit(new PropThread("src/main/resources/props.properties"));
        Future s2 = ex1.submit(new PropThread("src/main/resources/props.properties"));
        Properties prop1 = (Properties) s1.get();
        Properties prop2 = (Properties) s2.get();
        System.out.println(prop1.getProperty("one"));
        System.out.println(prop2.getProperty("one"));
    }

}