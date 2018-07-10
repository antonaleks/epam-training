package t3;

import static lombok.AccessLevel.PRIVATE;

import java.util.ArrayList;
import java.util.List;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = PRIVATE)
public class SharedResource {

    private List<Integer> list;

    public SharedResource() {
        list = new ArrayList<>();
    }

    public void setElement(Integer element) {
        list.add(element);
    }

    public Integer getELement() {
        if (list.size() > 0) {
            return list.remove(0);
        }
        return null;
    }
}
