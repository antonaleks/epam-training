package t1;


import static lombok.AccessLevel.PRIVATE;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.val;


@FieldDefaults(level = PRIVATE)
public class CrazyLogger {

    StringBuilder logger;
    @Getter
    static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter
        .ofPattern("dd-MM-YYYY : kk-mm");
    @Getter
    static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-YYYY");

    public CrazyLogger() {
        this.logger = new StringBuilder();
    }

    private String toFormat(String message) {
        return LocalDateTime.now().format(DATE_TIME_FORMATTER) + " - " + message + ";\n";
    }

    public String addLogMessage(String message) {
        logger.append(toFormat(message));
        return logger.toString();
    }

    public String fingMessageByDateTime(LocalDateTime dateTime) {
        val begin = logger.indexOf(dateTime.format(DATE_TIME_FORMATTER));
        String output = logger.substring(begin, logger.indexOf("\n", begin) + 1);
        System.out.println(output);
        return output;
    }

    public void showAll() {
        System.out.println(logger);
    }

    public String fingMessagesByDate(LocalDate date) {
        val output = new StringBuilder();
        int begin = 0;
        while (true) {
            begin = logger.indexOf(date.format(DATE_FORMATTER), begin);
            if (begin == -1) {
                break;
            }
            val end = logger.indexOf("\n", begin) + 1;
            output.append(logger.substring(begin, end));
            begin = end;
        }
        System.out.println(output);
        return output.toString();
    }

}
