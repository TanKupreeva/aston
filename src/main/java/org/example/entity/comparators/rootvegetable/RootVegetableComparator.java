package org.example.entity.comparators.rootvegetable;

import org.example.entity.RootVegetable;
import org.example.entity.comparators.AllComparator;

public class RootVegetableComparator extends AllComparator<RootVegetable> {
    public RootVegetableComparator() {
        super(new RootVegetableTypeComparator()
                .thenComparing(new RootVegetableColorComparator())
                .thenComparing(new RootVegetableWeightComparator()));
    }
}
