package t1;

import static lombok.AccessLevel.PRIVATE;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.FileSystemException;
import lombok.Cleanup;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

@FieldDefaults(level = PRIVATE)
@Value
public class FileManager {

    @NonFinal
    @NonNull
    File currentFile;

    public String getCurrentFileName() {
        return currentFile.getName();
    }

    public void goToFileWithAbsPath(String path) {
        currentFile = new File(path);
        if (!currentFile.exists()) {
            try {
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                System.out.println("Не существует такого файла");
            }
        }
    }

    public void goToFileWithRelPath(String path) {
        currentFile = new File(currentFile.getAbsoluteFile() + File.separator + path);
        if (!currentFile.exists()) {
            try {
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                System.out.println("Не существует такого файла");
            }
        }
    }

    public void getFilesInCurrentDirectory() {
        for (String fileName : currentFile.list()) {
            System.out.println(fileName);
        }
    }

    public void createNewTxtFile(String name) {
        File newFile = new File(currentFile.getAbsolutePath() + File.separator + name + ".txt");
        try {
            newFile.createNewFile();
            currentFile = newFile;
        } catch (IOException e) {
            System.out.println("Файл не создан");
        }
    }

    public void removeTxtFile() {
        if (currentFile.getName().substring(currentFile.getName().lastIndexOf('.') + 1)
            .equals("txt")) {
            currentFile.delete();
        } else {
            try {
                throw new FileSystemException("Поддерживает только формат txt");
            } catch (FileSystemException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeFile(String text) {
        try {
            @Cleanup Writer writer = new OutputStreamWriter(new FileOutputStream(currentFile));
            writer.write(text);
        } catch (FileNotFoundException e) {
            System.out.println("Не существует такого файла");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл");
        }
    }
}
