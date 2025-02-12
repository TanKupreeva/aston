package org.example.entity.comparators.rootvegetable.additional;

import org.example.entity.RootVegetable;

import java.util.Comparator;

public class Additional1ComparatorRootVegetable {

    private final Comparator<RootVegetable> comparator;

    public Additional1ComparatorRootVegetable() {
        comparator = new Additional1ComparatorRootVegetableWeight();
    }

    public Comparator<RootVegetable> getComparator() {
        return comparator;
    }

}
