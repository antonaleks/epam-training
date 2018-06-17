package t3;

import java.util.Objects;

public abstract class WritingTool extends Stationery {

    protected Type type;
    protected int capacity;

    public WritingTool(double price, Form form, String name, Type type, int capacity) {
        super(price, form, name);
        this.type = type;
        this.capacity = capacity;
    }

    public abstract void writeText(String text);

    public boolean isEmpty() {
        return capacity == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WritingTool)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        WritingTool that = (WritingTool) o;
        return capacity == that.capacity &&
            type == that.type;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), type, capacity);
    }
}
