package org.example.menu.fillcollection;

import org.example.entity.RootVegetable;
import org.example.filling.fromfile.FillerFromFileRootVegetable;
import org.example.filling.manual.FillerManualRootVegetable;
import org.example.filling.random.FillerRandomRootVegetable;

import java.io.BufferedReader;
import java.util.List;

public class FillRootVegetable extends FillCollection<RootVegetable> {
    public FillRootVegetable(BufferedReader bufferedReader, List<RootVegetable> list) {
        super(bufferedReader, RootVegetable.class,
                new FillerFromFileRootVegetable(bufferedReader, list),
                new FillerRandomRootVegetable(bufferedReader, list),
                new FillerManualRootVegetable(bufferedReader, list));
    }
}
