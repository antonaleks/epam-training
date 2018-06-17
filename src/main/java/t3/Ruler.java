package t3;

public class Ruler extends MeasuringTool {

    public Ruler(double price, int measure, int maxLength, String name) {
        super(price, Form.Rectangle, measure, maxLength, name);
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
        return "Ruler " + name + " with price: " + this.price + " and length: " + maxLength;
    }


    @Override
    public int getMeasuredSize(int length) {
        if (maxLength > length * measure) {
            return length * measure;
        } else {
            return -1;
        }
    }

    public void affixStraight() {
        System.out.println("ruler is affix");
    }
}
