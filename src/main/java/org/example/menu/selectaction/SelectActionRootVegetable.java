package org.example.menu.selectaction;

import org.example.entity.RootVegetable;
import org.example.entity.comparators.rootvegetable.ComparatorRootVegetable;
import org.example.finder.FinderRootVegetable;
import org.example.menu.SelectSort;
import org.example.menu.fillcollection.FillRootVegetable;

import java.io.BufferedReader;
import java.util.List;

public class SelectActionRootVegetable extends SelectAction<RootVegetable> {
    public SelectActionRootVegetable(BufferedReader bufferedReader, List<RootVegetable> list) {
        super(bufferedReader,
                RootVegetable.class,
                list,
                new FillRootVegetable(bufferedReader, list),
                new FinderRootVegetable(bufferedReader, list, new ComparatorRootVegetable().getComparatorDefault()),
                new SelectSort<>(bufferedReader, RootVegetable.class, list, new ComparatorRootVegetable()));
    }
}
