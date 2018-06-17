package t5;

import java.util.Map;
import org.junit.Test;

public class GroupStudentsTest {

    @Test
    public void findAndPrintStudentsEstimate() {
        Student anton = new Student("Anton");
        Student elena = new Student("Elena");
        Group<Integer> group1 = new Group<>(Disciplines.Chemistry, Map.of(anton, 2, elena, 5));
        Group<Double> group2 = new Group<>(Disciplines.Biology, Map.of(anton, 10.0, elena, 100.0));
        anton.findStudentsEstimates(group1, group2);
    }
}