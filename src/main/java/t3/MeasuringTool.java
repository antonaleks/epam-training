package t3;

import java.util.Objects;

public abstract class MeasuringTool extends Stationery {

    protected final int measure;
    protected final int maxLength;

    protected MeasuringTool(double price, Form form, int measure, int maxLength, String name) {
        super(price, form, name);
        this.measure = measure;
        this.maxLength = maxLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MeasuringTool)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        MeasuringTool that = (MeasuringTool) o;
        return measure == that.measure &&
            maxLength == that.maxLength;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), measure, maxLength);
    }

    public abstract int getMeasuredSize(int length);

}
