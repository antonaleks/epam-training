package t2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class EmployeeStationaryTest {

    Employee elena = new Employee("Elena");
    Employee anton = new Employee("Anton");

    List<Employee> employees = Arrays.asList(anton,
        elena);

    @Test
    public void addNewStationaryToAnton() {
        assertThat(anton.getStationeryList().size(), is(0));
        anton.addStationery(new Stationery("Pen", 20.0),
            new Stationery("Pencil", 50.0),
            new Stationery("Ruler", 100.0));
        assertThat(anton.getStationeryList().size(), is(3));
        assertThat(anton.getAllStationeryPrice(), is(170.0));
    }

    @Test
    public void addNewStationaryToElena() {
        assertThat(elena.getStationeryList().size(), is(0));
        elena.addStationery(new Stationery("Pen", 25.0),
            new Stationery("Pencil", 90.0),
            new Stationery("Ruler", 100.0));
        assertThat(elena.getStationeryList().size(), is(3));
        assertThat(elena.getAllStationeryPrice(), is(215.0));
    }

}
