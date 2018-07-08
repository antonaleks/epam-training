package t2;

import static lombok.AccessLevel.PRIVATE;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.security.InvalidKeyException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import lombok.experimental.FieldDefaults;
import lombok.experimental.UtilityClass;

@FieldDefaults(level = PRIVATE)
@UtilityClass
public class PropertiesManager {

    static Properties props;

    static Map<String, String> map;

    public static Properties loadProperties(String path) {
        if (props == null) {
            props = new Properties();
        }
        try {
            if (!path.substring(path.lastIndexOf('.') + 1).equals("properties")) {
                throw new FileSystemException("Не поддерживаемый формат");
            }
            props.load(new FileInputStream(new File(path).getAbsolutePath()));
            map = new HashMap<>();
            for (Object key : props.keySet()) {
                map.put((String) key, props.getProperty((String) key));
            }
        } catch (FileSystemException e) {
            System.out.println("Формат не поддерживается");
        } catch (IOException e) {
            System.out.println("Файл отсутствует");
        }
        return props;
    }

    public static void putKey(String key, String value) {
        map.put(key, value);
    }

    public static String getValue(String key) {

        try {
            if (!props.containsKey(key)) {
                throw new InvalidKeyException();
            }
            return map.get(key);
        } catch (InvalidKeyException e) {
            System.out.println("Нет такого ключа");
        }
        return null;
    }

}
