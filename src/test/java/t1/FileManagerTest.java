package t1;

import java.io.File;
import lombok.val;
import org.junit.Test;

public class FileManagerTest {

    @Test
    public void testFileManager() {
        val manager = new FileManager(new File("/home"));
        manager.getFilesInCurrentDirectory();
        manager.goToFileWithRelPath("anton");
        manager.getFilesInCurrentDirectory();
        manager.goToFileWithAbsPath("/home/anton/Документы");
        manager.getFilesInCurrentDirectory();
        manager.createNewTxtFile("test");
        manager.getCurrentFileName();
        manager.writeFile("Привет, как дела?");
        manager.removeTxtFile();
    }

}