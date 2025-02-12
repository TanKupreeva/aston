package org.example.finder;

import org.example.entity.RootVegetable;
import org.example.soututils.GetValueRootVegetable;

import java.io.BufferedReader;
import java.util.Comparator;
import java.util.List;

public class FinderRootVegetable extends Finder<RootVegetable> {
    public FinderRootVegetable(BufferedReader bufferedReader, List<RootVegetable> originalList, Comparator<RootVegetable> comparator) {
        super(bufferedReader,
                originalList,
                new GetValueRootVegetable(bufferedReader),
                comparator);
    }

}
