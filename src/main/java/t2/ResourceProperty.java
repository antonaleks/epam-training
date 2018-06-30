package t2;

import static lombok.AccessLevel.PRIVATE;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = PRIVATE)
public class ResourceProperty {

    Locale curLocale;
    ResourceBundle bundle;

    public ResourceProperty(String language, String file) {
        curLocale = new Locale(language);
        bundle = ResourceBundle.getBundle(file, curLocale);
    }

    public String getValue(String key) {
        return bundle.getString(key);
    }

    public Set<String> getQuizKeys() {
        return bundle.keySet();
    }
}
