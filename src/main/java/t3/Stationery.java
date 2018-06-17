package t3;

import java.util.Objects;

public abstract class Stationery {

    protected double price;
    protected final Form form;
    protected final String name;

    public abstract double getPrice();

    public abstract String getName();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Stationery)) {
            return false;
        }
        Stationery that = (Stationery) o;
        return Double.compare(that.price, price) == 0 &&
            form == that.form &&
            Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(price, form, name);
    }

    public Stationery(double price, Form form, String name) {
        this.price = price;
        this.form = form;
        this.name = name;
    }

    public abstract String getInfo();

}

enum Form {
    Trianlge,
    Square,
    Circle,
    Rectangle
}
