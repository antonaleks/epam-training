package t4;

import static lombok.AccessLevel.PRIVATE;

import io.vavr.CheckedConsumer;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.Value;
import lombok.experimental.FieldDefaults;
import lombok.experimental.Wither;
import lombok.val;

@FieldDefaults(level = PRIVATE)
@Value
public class Application implements Serializable {

    @Getter
    ArrayList<Film> films = new ArrayList<>();

    @Wither
    static final String pathToFile = "src/main/resources/films.txt";

    public Application() throws Throwable {
        withObjectInputStream(objectInputStream -> {
                val obj = objectInputStream.readObject();
                films.addAll((Collection<? extends Film>) obj);
            }
        );
    }

    @SneakyThrows
    public void withObjectOutputStream(
        CheckedConsumer<ObjectOutputStream> objectOutputSteamCheckedConsumer)
        throws Throwable {
        try (val fileOutputStream = new FileOutputStream(pathToFile);
            val objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputSteamCheckedConsumer.accept(objectOutputStream);
        }
    }

    @SneakyThrows
    public void withObjectInputStream(
        CheckedConsumer<ObjectInputStream> objectInputSteamCheckedConsumer)
        throws Throwable {
        try (val fileInputStream = new FileInputStream(pathToFile);
            val objectInputStream = new ObjectInputStream(fileInputStream)) {
            objectInputSteamCheckedConsumer.accept(objectInputStream);
        }
    }

    public void addFilm(Film film) {
        films.add(film);
    }

    public void removeFilm(Film film) {
        films.remove(film);
    }

    public void showFilms() {
        films.stream().forEach(elem -> System.out.println(elem));
    }

    public void saveFilms() throws Throwable {
        withObjectOutputStream(objectOutputStream ->
            objectOutputStream.writeObject(getFilms())
        );
    }
}
