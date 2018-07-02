package t4;

import static lombok.AccessLevel.PRIVATE;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = PRIVATE, makeFinal = true)
@Value
@AllArgsConstructor
public class Actor implements Serializable {

    String name;
}
