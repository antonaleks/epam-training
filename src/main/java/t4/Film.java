package t4;

import static lombok.AccessLevel.PRIVATE;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import lombok.experimental.FieldDefaults;
import lombok.experimental.Wither;

@FieldDefaults(level = PRIVATE)
@Data
@AllArgsConstructor
@Builder
public class Film implements Serializable {

    @Singular
    List<Actor> actors = new ArrayList<>();
    @Wither
    final String name;
}
