package org.example.filling.fromfile;

import org.example.entity.RootVegetable;
import org.example.utils.ReadFilesUtils;

import java.io.BufferedReader;
import java.util.List;

public class FromFileFillerRootVegetable extends FromFileFiller<RootVegetable> {
    public FromFileFillerRootVegetable(BufferedReader bufferedReader, List<RootVegetable> list) {
        super(bufferedReader, list);
        listFromFile = ReadFilesUtils.getRootVegetablesFromFile();
    }
}
