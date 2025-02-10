package org.example.menu.selectaction;

import org.example.entity.RootVegetable;
import org.example.menu.fillcollection.FillCollection;
import org.example.menu.fillcollection.FillRootVegetable;
import org.example.menu.findcollection.FindCollection;
import org.example.menu.findcollection.FindCollectionRootVegetable;

import java.io.BufferedReader;
import java.util.List;

public class SelectActionRootVegetable extends SelectAction<RootVegetable> {
    public SelectActionRootVegetable(BufferedReader bufferedReader, List<RootVegetable> list) {
//        FillCollection<RootVegetable> filler = new FillRootVegetable(bufferedReader, list);
//        FindCollection<RootVegetable> finder = new FindCollectionRootVegetable(bufferedReader, list));
//        super(bufferedReader, filler, finder);

        super(bufferedReader, new FillRootVegetable(bufferedReader, list), new FindCollectionRootVegetable(bufferedReader, list));
        this.list = list;
    }
}
