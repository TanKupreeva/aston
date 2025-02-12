package org.example.entity.comparators.rootvegetable.defaultt;

import org.example.entity.RootVegetable;

import java.util.Comparator;

public class DefaultComparatorRootVegetable {

    private final Comparator<RootVegetable> comparator;

    public DefaultComparatorRootVegetable() {
        comparator = new DefaultComparatorRootVegetableType()
                .thenComparing(new DefaultComparatorRootVegetableColor())
                .thenComparing(new DefaultComparatorRootVegetableWeight());
    }

    public Comparator<RootVegetable> getComparator() {
        return comparator;
    }

}
