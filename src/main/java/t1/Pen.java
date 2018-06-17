package t1;


import java.util.Objects;

public class Pen {

    private double capacity;
    private final String color;
    private final InkPenType inkType;
    private final UsePenType useType;
    private final double lineDepth;

    public double getCapacity() {
        return capacity;
    }

    public String getColor() {
        return color;
    }

    public InkPenType getInkType() {
        return inkType;
    }

    public UsePenType getUseType() {
        return useType;
    }

    public double getLineDepth() {
        return lineDepth;
    }

    public Pen(double capacity, String color, InkPenType inkType, UsePenType useType,
        double lineDepth) {
        this.capacity = capacity;
        this.color = color;
        this.inkType = inkType;
        this.useType = useType;
        this.lineDepth = lineDepth;
    }

    public boolean isEmpty() {
        return capacity < lineDepth;
    }

    public boolean writeLetter(char letter) {
        if (!isEmpty()) {
            System.out.println(letter);
            capacity -= lineDepth;
        } else {
            return false;
        }
        return true;
    }

    public boolean writeText(String text) {
        if (!isEmpty()) {
            int textSize = text.replaceAll(" ", "").length();
            if (capacity * lineDepth >= text.replaceAll(" ", "").length()) {
                System.out.println(text);
                capacity -= textSize * lineDepth;
            } else {
                System.out.println(
                    text.substring(0, (int) (capacity * lineDepth) + (text.length() - textSize)));
                capacity = 0;
            }
            return true;
        }
        return false;
    }

    public void fillPen(double count) {
        capacity += count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pen pen = (Pen) o;
        return Double.compare(pen.capacity, capacity) == 0 &&
            Double.compare(lineDepth, pen.lineDepth) == 0 &&
            color.equals(pen.color) &&
            inkType == pen.inkType &&
            useType == pen.useType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(capacity, color, inkType, useType, lineDepth);
    }

    @Override
    public String toString() {
        return "Pen{" +
            "capacity=" + capacity +
            ", color='" + color + '\'' +
            ", inkType=" + inkType +
            ", useType=" + useType +
            ", lineDepth=" + lineDepth +
            '}';
    }
}

enum InkPenType {
    Gel,
    Fountain,
    Ball
}

enum UsePenType {
    Automatic,
    Manual
}
