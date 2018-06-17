package t3;

import java.util.Objects;

public class Protractor extends MeasuringTool {

    private final double degreeCoeff;

    public Protractor(double price, int measure, int maxLength, String name, double degreeCoeff) {
        super(price, Form.Circle, measure, maxLength, name);
        this.degreeCoeff = degreeCoeff;
    }

    @Override
    public String getInfo() {
        return "I am " + name + " price " + price;
    }

    @Override
    public int getMeasuredSize(int length) {
        if (maxLength > length * measure * degreeCoeff) {
            return length * measure * (int) degreeCoeff;
        } else {
            return -1;
        }
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Protractor)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Protractor that = (Protractor) o;
        return Double.compare(that.degreeCoeff, degreeCoeff) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), degreeCoeff);
    }
}
