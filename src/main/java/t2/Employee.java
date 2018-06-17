package t2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Employee {

    private final String name;
    private List<Stationery> stationeryList;

    public String getName() {
        return name;
    }

    public List<Stationery> getStationeryList() {
        return stationeryList;
    }

    public Employee(String name) {
        this.name = name;
        this.stationeryList = new ArrayList();
    }

    public double getAllStationeryPrice() {
        double price = 0.0;
        for (Stationery stationery : stationeryList) {
            price += stationery.getPrice();
        }
        return price;
    }

    public void addStationery(Stationery stationery) {
        stationeryList.add(stationery);
    }

    public void addStationery(Stationery... stationerys) {
        for (Stationery stationery : stationerys) {
            stationeryList.add(stationery);
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
