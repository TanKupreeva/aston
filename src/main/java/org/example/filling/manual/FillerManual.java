package org.example.filling.manual;

import org.example.filling.Filler;
import org.example.soututils.GetValue;

import java.io.BufferedReader;
import java.util.List;

public class FillerManual<T> extends Filler<T> {

    public FillerManual(BufferedReader bufferedReader,
                        List<T> originalList,
                        GetValue<T> function) {
        super(bufferedReader, originalList, null);
        this.intConsumer =
                (i) -> {
            System.out.println("Object №" + (i+1));
            T value = function.getFunction().apply(i);
            originalList.add(value);
        };
        menuBuilder2.append("Objects will be added manually.");
    }

    protected boolean checkInputData(String line) {
        int capacity = Integer.parseInt(line);
        if (capacity != 0)  {
            fill(capacity);
            return false;
        }
        else System.out.println("ERROR. Capacity != 0. Try again.");
        return true;
    }

}
