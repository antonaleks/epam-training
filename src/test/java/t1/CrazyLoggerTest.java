package t1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.Test;

public class CrazyLoggerTest {

    @Test
    public void testLog() {
        CrazyLogger logger = new CrazyLogger();
        logger.addLogMessage("Hi");
        logger.addLogMessage("Mark");
        logger.showAll();
        logger.fingMessagesByDate(LocalDate.now());
        logger.fingMessageByDateTime(LocalDateTime.now());

    }

}