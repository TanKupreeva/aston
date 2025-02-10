package org.example.filling.random;

import org.example.entity.RootVegetable;
import org.example.utils.ReadFilesUtils;

import java.io.BufferedReader;
import java.util.List;

public class RandomFillerRootVegetable extends RandomFiller<RootVegetable> {
    public RandomFillerRootVegetable(BufferedReader bufferedReader, List<RootVegetable> list) {
        super(bufferedReader, list);
        listRandom = ReadFilesUtils.getRootVegetablesFromFile();
    }
}
