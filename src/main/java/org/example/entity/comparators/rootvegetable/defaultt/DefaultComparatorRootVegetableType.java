package org.example.entity.comparators.rootvegetable.defaultt;

import org.example.entity.RootVegetable;

import java.util.Comparator;

public class DefaultComparatorRootVegetableType implements Comparator<RootVegetable> {
    @Override
    public int compare(RootVegetable o1, RootVegetable o2) {
        return o1.getType().compareToIgnoreCase(o2.getType());
    }
}