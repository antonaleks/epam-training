package t2;

import java.util.Objects;

public class Stationery {

    private final String name;
    private double price;

    public Stationery(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setPrice(double price) {

        this.price = price;
    }

    public String getName() {

        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Stationery that = (Stationery) o;
        return Double.compare(that.price, price) == 0 &&
            Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "name=" + name + " with price: " + price;
    }
}
