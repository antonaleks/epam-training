package t3;

public class Pencil extends WritingTool {

    public Pencil(double price, String name, Type type, int capacity) {
        super(price, Form.Square, name, type, capacity);
    }

    @Override
    public void writeText(String text) {
        if (!isEmpty()) {
            System.out.println(text.substring(0, capacity));
            capacity -= text.length();
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
        return "It's pen with name " + name + " price " + price;
    }
}
