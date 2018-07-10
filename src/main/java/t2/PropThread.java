package t2;

import static lombok.AccessLevel.PRIVATE;

import java.util.Properties;
import java.util.concurrent.Callable;
import lombok.Value;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = PRIVATE)
@Value
public class PropThread implements Callable<Properties> {

    String path;


    @Override
    public Properties call() throws Exception {
        return PropertiesManager.loadProperties(path);
    }
}
