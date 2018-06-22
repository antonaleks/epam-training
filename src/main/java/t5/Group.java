package t5;

import java.util.HashMap;
import java.util.Map;

public class Group {

    private final Disciplines discipline;
    private Map<Student, Mark<? extends Number>> students;

    public Disciplines getDiscipline() {
        return discipline;
    }

    public Map<Student, Mark<? extends Number>> getStudents() {
        return students;
    }

    public Group(Disciplines discipline) {
        this.discipline = discipline;
        this.students = new HashMap<>();
    }

    public Group(Disciplines discipline, Map<Student, Mark<? extends Number>> students) {
        this.discipline = discipline;
        this.students = students;
    }

    public void addStudent(Student student, Mark<? extends Number> mark) {
        students.put(student, mark);
    }

}
