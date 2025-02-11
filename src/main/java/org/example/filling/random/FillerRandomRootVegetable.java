package org.example.filling.random;

import org.example.entity.RootVegetable;
import org.example.utils.ReadFilesUtils;

import java.io.BufferedReader;
import java.util.List;

public class FillerRandomRootVegetable extends FillerRandom<RootVegetable> {
    public FillerRandomRootVegetable(BufferedReader bufferedReader, List<RootVegetable> list) {
        super(bufferedReader, list, ReadFilesUtils.getRootVegetablesFromFile());
    }
}
