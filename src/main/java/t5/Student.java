package t5;

import java.util.Objects;

public class Student {

    private String name;

    @Override
    public String toString() {
        return "Student{" +
            "name='" + name + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    public String getName() {

        return name;
    }

    public Student(String name) {

        this.name = name;
    }

    public void findStudentsEstimates(Group... groups) {
        System.out.println(name + "'s marks: ");
        for (Group group : groups) {
            System.out
                .println("in " + group.getDiscipline() + " is " + group.getStudents().get(this));
        }
    }
}
