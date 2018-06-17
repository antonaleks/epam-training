package t4;

import java.util.Comparator;
import t3.Stationery;

public class StationaryComparatorByName implements Comparator<Stationery> {

    @Override
    public int compare(Stationery o1, Stationery o2) {
        String name1 = o1.getName();
        String name2 = o2.getName();
        return name1.compareTo(name2);
    }
}
