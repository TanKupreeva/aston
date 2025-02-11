package org.example.entity.comparators.rootvegetable;

import org.example.entity.RootVegetable;
import org.example.entity.comparators.AllComparator;

public class RootVegetableComparator extends AllComparator<RootVegetable> {
    public RootVegetableComparator() {
        super(new RootVegetableColorComparator()
                .thenComparing(new RootVegetableTypeComparator())
                .thenComparing(new RootVegetableWeightComparator()));
    }
}
