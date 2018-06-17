package t5;

import java.util.HashMap;
import java.util.Map;

public class Group<T> {

    private final Disciplines discipline;
    private Map<Student, T> students;

    public Disciplines getDiscipline() {
        return discipline;
    }

    public Map<Student, T> getStudents() {
        return students;
    }

    public Group(Disciplines discipline) {
        this.discipline = discipline;
        this.students = new HashMap<>();
    }

    public Group(Disciplines discipline, Map<Student, T> students) {
        this.discipline = discipline;
        this.students = students;
    }

}
