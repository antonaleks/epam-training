package t2;

import org.junit.Test;

public class PropertiesManagerTest {

    @Test
    public void testProps() {
        PropertiesManager.loadProperties("src/main/resources/test.properties");
        System.out.println(PropertiesManager.getValue("one"));
        System.out.println(PropertiesManager.getValue("three"));

    }

}