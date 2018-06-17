package t4;

import java.util.Comparator;
import t3.Stationery;

public class StationaryComparatorByPrice implements Comparator<Stationery> {

    @Override
    public int compare(Stationery o1, Stationery o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
