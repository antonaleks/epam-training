package t3;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class StationaryTest {

    @Test
    public void checkToolKit() {
        List<Stationery> newComerKit = new ArrayList<>();
        newComerKit.add(new Pen(50.0, "Pen1", Type.Auto, 10));
        newComerKit.add(new Ruler(20, 2, 10, "Ruler1"));
        newComerKit.add(new Pencil(25.0, "Pencil1", Type.Manual, 20));
        newComerKit.add(new Protractor(10, 1, 20, "Protractor1", 3.14));

        for (Stationery stationery : newComerKit) {
            System.out.println(stationery.getInfo());
        }

        Pen pen = (Pen) newComerKit.get(0);
        pen.writeText("Hi");

        Ruler ruler = (Ruler) newComerKit.get(1);
        ruler.getMeasuredSize(2);

    }
}
