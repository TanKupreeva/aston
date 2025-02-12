package org.example.entity.comparators.rootvegetable;

import org.example.entity.RootVegetable;

import java.util.Comparator;

public class RootVegetableColorComparator implements Comparator<RootVegetable> {
    @Override
    public int compare (RootVegetable o1, RootVegetable o2){
        return o1.getColor().compareToIgnoreCase(o2.getColor());
    }
}
