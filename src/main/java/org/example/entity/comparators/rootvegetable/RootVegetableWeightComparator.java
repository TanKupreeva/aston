package org.example.entity.comparators.rootvegetable;

import org.example.entity.RootVegetable;

import java.util.Comparator;

import static org.example.entity.comparators.AllComparator.isBothOrSwitch;

public class RootVegetableWeightComparator implements Comparator<RootVegetable> {
    @Override
    public int compare(RootVegetable o1, RootVegetable o2) {
        boolean isEven1 = o1.getWeight() % 2 == 0;
        boolean isEven2 = o2.getWeight() % 2 == 0;
        int other = Double.compare(o1.getWeight(), o2.getWeight());
        return isBothOrSwitch(isEven1, isEven2, other);
//        return Double.compare(o1.getWeight(), o2.getWeight());
    }
}
