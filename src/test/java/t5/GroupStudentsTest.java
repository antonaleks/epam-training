package t5;

import org.junit.Test;

public class GroupStudentsTest {

    @Test
    public void findAndPrintStudentsEstimate() {
        Student anton = new Student("Anton");
        Student elena = new Student("Elena");
        Group group1 = new Group(Disciplines.Physics);
        group1.addStudent(anton, new Mark<>(2));
        group1.addStudent(elena, new Mark<>(4));
        Group group2 = new Group(Disciplines.Programming);
        group2.addStudent(anton, new Mark<>(2.0));
        group2.addStudent(elena, new Mark<>(4.0));
        anton.findStudentsEstimates(group1, group2);
        System.out
            .println(group1.getStudents().get(anton).sameAny(group2.getStudents().get(anton)));
    }
}