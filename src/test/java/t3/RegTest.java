package t3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.val;
import org.junit.Test;

public class RegTest {

    String fileDir = "/home/anton/IdeaProjects/epam-training/src/test/resources/example.html";

    @Test
    public void readAndFind() throws IOException {
        //regexp \b(Р|р)ис(\S*)\s\d+(\sи\s\d*)*
        val p = Pattern.compile("\\b(Р|р)ис(\\S*)\\s\\d+((\\sи\\s\\d*)*|(\\,\\s*\\d+))*",
            Pattern.CASE_INSENSITIVE);

        BufferedReader in = new BufferedReader(
            new InputStreamReader(
                new FileInputStream(fileDir), "CP1251"));
        val text = new StringBuilder();
        String str;

        while ((str = in.readLine()) != null) {
            text.append(str);
        }
        Matcher m = p.matcher(text);
        val numbers = new LinkedHashSet<Integer>();
        while (m.find()) {
            System.out.println("Found " + m.group(0));
            for (String s : m.group(0).split("[\\s\\,]")) {
                try {
                    numbers.add(Integer.parseInt(s));
                } catch (NumberFormatException e) {
                }
            }
        }
        val sortedSet = new HashSet<Integer>(numbers);
        val iterSort = sortedSet.iterator();
        val iterSet = numbers.iterator();
        while (iterSet.hasNext()) {
            if (!iterSet.next().equals(iterSort.next())) {
                System.out.println("Не посследовательно");
                break;
            }
        }
        System.out.println("Конец");

    }

    @Test
    public void readAllLinks() throws IOException {
        //reg [А-Я].*([рР]ис(\S*)\s\d+((\sи\s\d*)*|(\,\s*\d+))).*\.
        val p = Pattern
            .compile("[А-Я]\\W*([рР]ис(\\S*)\\s\\d+((\\sи\\s\\d*)*|(\\,\\s*\\d+)))[\\s\\W]*\\.");

        BufferedReader in = new BufferedReader(
            new InputStreamReader(
                new FileInputStream(fileDir), "CP1251"));
        val text = new StringBuilder();
        String str;

        while ((str = in.readLine()) != null) {
            text.append(str);
        }
        Matcher m = p.matcher(text);
        while (m.find()) {
            System.out.println("Found " + m.group(0));
        }
        System.out.println("Конец");
    }
}