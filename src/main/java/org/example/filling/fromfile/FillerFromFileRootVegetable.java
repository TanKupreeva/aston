package org.example.filling.fromfile;

import org.example.entity.RootVegetable;
import org.example.utils.ReadFilesUtils;

import java.io.BufferedReader;
import java.util.List;

public class FillerFromFileRootVegetable extends FillerFromFile<RootVegetable> {
    public FillerFromFileRootVegetable(BufferedReader bufferedReader, List<RootVegetable> list) {
        super(bufferedReader, list, ReadFilesUtils.getRootVegetablesFromFile());
    }
}
