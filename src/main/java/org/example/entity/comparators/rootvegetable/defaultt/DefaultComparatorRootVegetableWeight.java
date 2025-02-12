package org.example.entity.comparators.rootvegetable.defaultt;

import org.example.entity.RootVegetable;

import java.util.Comparator;

public class DefaultComparatorRootVegetableWeight implements Comparator<RootVegetable> {
    @Override
    public int compare(RootVegetable o1, RootVegetable o2) {
        return Double.compare(o1.getWeight(), o2.getWeight());
    }
}
