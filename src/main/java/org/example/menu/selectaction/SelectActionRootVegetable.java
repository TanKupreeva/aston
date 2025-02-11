package org.example.menu.selectaction;

import org.example.entity.RootVegetable;
import org.example.entity.comparators.rootvegetable.RootVegetableComparator;
import org.example.finder.FinderRootVegetable;
import org.example.menu.fillcollection.FillRootVegetable;

import java.io.BufferedReader;
import java.util.List;

public class SelectActionRootVegetable extends SelectAction<RootVegetable> {
    public SelectActionRootVegetable(BufferedReader bufferedReader, List<RootVegetable> list) {
        super(bufferedReader, RootVegetable.class,
                new FillRootVegetable(bufferedReader, list),
                new FinderRootVegetable(bufferedReader, list, new RootVegetableComparator().getComparator()),
                new RootVegetableComparator());
        this.list = list;
    }
}
