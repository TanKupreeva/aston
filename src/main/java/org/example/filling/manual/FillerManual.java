package org.example.filling.manual;

import org.example.filling.Filler;

import java.io.BufferedReader;
import java.util.List;

public abstract class FillerManual<T> extends Filler<T> {

    public FillerManual(BufferedReader bufferedReader, List<T> originalList) {
        super(bufferedReader, originalList, null);
        this.intConsumer =
                (i) -> {
            System.out.println("Object №" + (i+1));
            originalList.add(getValue(i));
        };
        menuBuilder2.append("Objects will be added manually.");
    }

    public boolean checkInputData(String line) {
        int capacity = Integer.parseInt(line);
        if (capacity != 0)  {
            fill(capacity);
            return false;
        }
        else System.out.println("ERROR. Capacity != 0. Try again.");
        return true;
    }

    protected abstract T getValue(int i);

}
