package t3;

public class Pen extends WritingTool {

    public Pen(double price, String name, Type type, int capacity) {
        super(price, Form.Circle, name, type, capacity);
    }

    @Override
    public void writeText(String text) {
        if (!isEmpty()) {
            int textSize = text.replaceAll(" ", "").length();
            if (capacity >= text.replaceAll(" ", "").length()) {
                System.out.println(text);
                capacity -= textSize;
            } else {
                System.out.println(text.substring(0, capacity) + (text.length() - textSize));
                capacity = 0;
            }
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
    public String getInfo() {
        return "Pen " + name + " price " + price;
    }
}
