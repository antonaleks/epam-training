package t4;

import java.util.Comparator;
import t3.Stationery;

public class StationaryComparatorByPriceAndName implements Comparator<Stationery> {

    @Override
    public int compare(Stationery o1, Stationery o2) {
        int compare = Double.compare(o1.getPrice(), o2.getPrice());
        if (compare == 0) {
            o1.getName().compareTo(o2.getName());
        }
        return compare;
    }
}
