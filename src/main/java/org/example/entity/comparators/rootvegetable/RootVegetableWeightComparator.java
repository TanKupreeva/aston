package org.example.entity.comparators.rootvegetable;

import org.example.entity.RootVegetable;

import java.util.Comparator;

public class RootVegetableWeightComparator implements Comparator<RootVegetable> {
    @Override
    public int compare(RootVegetable o1, RootVegetable o2) {
        return Double.compare(o1.getWeight(), o2.getWeight());
    }
}
