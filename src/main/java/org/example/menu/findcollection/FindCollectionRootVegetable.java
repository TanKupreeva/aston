package org.example.menu.findcollection;

import org.example.entity.RootVegetable;

import java.io.BufferedReader;
import java.util.List;

public class FindCollectionRootVegetable extends FindCollection<RootVegetable> {
    public FindCollectionRootVegetable(BufferedReader bufferedReader, List<RootVegetable> list) {
        super(bufferedReader, list);
    }
}
