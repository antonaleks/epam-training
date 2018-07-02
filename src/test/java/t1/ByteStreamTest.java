package t1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import lombok.Cleanup;
import org.junit.Test;
import util.JavaKey;

public class ByteStreamTest {

    static final String INPUT_FILE = "NotePad.java";
    static final String OUTPUT_FILE = "testByte.txt";
    static final int SIZE_ARR = 5000;

    @Test
    public void testStream() throws IOException {
        @Cleanup FileInputStream inputStream = new FileInputStream(
            ByteStreamTest.class.getClassLoader().getResource(INPUT_FILE).getFile());
        System.out.println("Файл открыт для чтения");
        int byteAvailable = inputStream.available();
        System.out.println("Готово к считыванию: " + byteAvailable);
        byte[] arr = new byte[SIZE_ARR];
        int count = inputStream.read(arr, 0, byteAvailable);
        System.out.println("Считано " + count);
        String text = new String(arr);
        String outText = JavaKey.findKeysInText(text);
        byte[] bytesToWrite = outText.getBytes();
        @Cleanup FileOutputStream fileOutputStream = new FileOutputStream(
            "src/main/resources/" + OUTPUT_FILE);
        fileOutputStream.write(bytesToWrite);
    }
}