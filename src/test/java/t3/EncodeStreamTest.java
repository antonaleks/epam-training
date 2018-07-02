package t3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import lombok.Cleanup;
import org.junit.Test;

public class EncodeStreamTest {

    static final String INPUT_FILE = "rus.txt";
    static final String OUTPUT_FILE = "rus16.txt";

    @Test
    public void testStream() throws IOException {
        @Cleanup FileReader fileReader = new FileReader(
            EncodeStreamTest.class.getClassLoader().getResource(INPUT_FILE).getFile());
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s;
        StringBuilder inText = new StringBuilder();
        while ((s = bufferedReader.readLine()) != null) {
            inText.append(s);
        }

        @Cleanup Writer fileOutputStream = new BufferedWriter(
            new OutputStreamWriter(new FileOutputStream("src/main/resources/" + OUTPUT_FILE),
                "UTF16"));
        fileOutputStream.write(inText.toString());
    }

}