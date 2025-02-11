package org.example.filling.random;

import org.example.filling.Filler;

import java.io.BufferedReader;
import java.util.List;

public class FillerRandom<T> extends Filler<T> {

    protected final List<T> listRandom;

    public FillerRandom(BufferedReader bufferedReader, List<T> originalList, List<T> listRandom) {
        super(bufferedReader, originalList, null);
        this.listRandom = listRandom;
        this.intConsumer = (i) -> {
            int to = listRandom.size() - 1;
            int random_number = (int) (Math.random() * to);
            T random_object = listRandom.get(random_number);
            originalList.add(random_object);
        };

        menuBuilder2.append("Objects will be added randomly.\n")
                .append("Attention! The data to fill in is taken from the file. The data may be repeated.");

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
