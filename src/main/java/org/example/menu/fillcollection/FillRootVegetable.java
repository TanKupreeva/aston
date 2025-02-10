package org.example.menu.fillcollection;

import org.example.entity.RootVegetable;
import org.example.filling.fromfile.FromFileFiller;
import org.example.filling.fromfile.FromFileFillerRootVegetable;
import org.example.filling.manual.ManualFiller;
import org.example.filling.manual.ManualFillerRootVegetable;
import org.example.filling.random.RandomFiller;
import org.example.filling.random.RandomFillerRootVegetable;

import java.io.BufferedReader;
import java.util.List;

public class FillRootVegetable extends FillCollection<RootVegetable> {
    public FillRootVegetable(BufferedReader bufferedReader, List<RootVegetable> list) {
//        FromFileFiller<RootVegetable> fromFileFiller = new FromFileFillerRootVegetable(list);
//        RandomFiller<RootVegetable> randomFiller = new RandomFillerRootVegetable(list);
//        ManualFiller<RootVegetable> manualFiller = new ManualFillerRootVegetable(list);
//        super(bufferedReader, fromFileFiller, randomFiller, manualFiller);

        super(bufferedReader, new FromFileFillerRootVegetable(bufferedReader, list), new RandomFillerRootVegetable(bufferedReader, list), new ManualFillerRootVegetable(bufferedReader, list));
    }
}
