package t1;

import static lombok.AccessLevel.PRIVATE;

import lombok.experimental.FieldDefaults;

@FieldDefaults(level = PRIVATE)
public abstract class Acc {

    public abstract String getNumber();

}
