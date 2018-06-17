package t4;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import t3.Pen;
import t3.Pencil;
import t3.Protractor;
import t3.Ruler;
import t3.Stationery;
import t3.Type;

public class StationaryTest {

    @Test
    public void checkCompareAndSort() {
        List<Stationery> newComerKit = new ArrayList<>();
        newComerKit.add(new Pen(50.0, "Pen1", Type.Auto, 10));
        newComerKit.add(new Ruler(25.0, 2, 10, "Ruler1"));
        newComerKit.add(new Pencil(25.0, "Pencil1", Type.Manual, 20));
        newComerKit.add(new Protractor(10.0, 1, 20, "Protractor1", 3.14));

        for (Stationery stationery : newComerKit) {
            System.out.println(stationery.getInfo());
        }
        System.out.println();
        newComerKit.sort(new StationaryComparatorByName());
        for (Stationery stationery : newComerKit) {
            System.out.println(stationery.getInfo());
        }
        System.out.println();
        newComerKit.sort(new StationaryComparatorByPriceAndName());
        for (Stationery stationery : newComerKit) {
            System.out.println(stationery.getInfo());
        }
        System.out.println();
        newComerKit.sort(new StationaryComparatorByPrice());
        for (Stationery stationery : newComerKit) {
            System.out.println(stationery.getInfo());
        }

    }
}
