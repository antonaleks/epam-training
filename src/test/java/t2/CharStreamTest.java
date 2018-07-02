package t2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import lombok.Cleanup;
import org.junit.Test;
import util.JavaKey;

public class CharStreamTest {

    static final String INPUT_FILE = "NotePad.java";
    static final String OUTPUT_FILE = "testChar.txt";

    @Test
    public void testStream() throws IOException {
        @Cleanup FileReader fileReader = new FileReader(
            CharStreamTest.class.getClassLoader().getResource(INPUT_FILE).getFile());
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s;
        StringBuilder inText = new StringBuilder();
        while ((s = bufferedReader.readLine()) != null) {
            inText.append(s);
        }
        String outText = JavaKey.findKeysInText(inText.toString());

        @Cleanup Writer fileOutputStream = new BufferedWriter(
            new OutputStreamWriter(new FileOutputStream("src/main/resources/" + OUTPUT_FILE),
                "UTF8"));
        fileOutputStream.write(outText);
    }

}