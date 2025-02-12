package org.example.filling.manual;

import org.example.entity.RootVegetable;
import org.example.soututils.GetValueRootVegetable;

import java.io.BufferedReader;
import java.util.List;

public class FillerManualRootVegetable extends FillerManual<RootVegetable> {
    public FillerManualRootVegetable(BufferedReader bufferedReader, List<RootVegetable> list) {
        super(bufferedReader,
                list,
                new GetValueRootVegetable(bufferedReader));
    }

}
