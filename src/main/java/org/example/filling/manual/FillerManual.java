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
        menuBuilder2
                .append("Objects will be added manually.\n")
                .append("You can only create 2 objects at a time.");
    }

    @Override
    protected boolean checkInputData(String line) {
        int quantity = Integer.parseInt(line);
        if (quantity > 0 && quantity <= 2)  {
            fill(quantity);
            return false;
        }
        else System.out.println("ERROR. The quantity should not be equal to " + line + ". Try again.");
        return true;
    }

}
