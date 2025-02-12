package org.example.filling.fromfile;

import org.example.filling.Filler;

import java.io.BufferedReader;
import java.util.List;

public class FillerFromFile<T> extends Filler<T> {

    protected final List<T> listFromFile;

    public FillerFromFile(BufferedReader bufferedReader, List<T> originalList, List<T> listFromFile) {
        super(bufferedReader, originalList, null);
        this.listFromFile = listFromFile;
        this.intConsumer = (i) -> originalList.add(listFromFile.get(i));
        menuBuilder2.append("Objects will be added from the file.\n")
                .append("Or enter \"all\" to add all data from the file.");
    }

    public boolean checkInputData(String line) {
        if (line.equalsIgnoreCase("all")) {
            fill(listFromFile.size());
            return false;
        } else {
            int capacity = Integer.parseInt(line);
            if (capacity != 0) {
                if (capacity < listFromFile.size()) {
                    fill(capacity);
                    return false;
                } else System.out.println("ERROR. Capacity exceeds the limit. Try again.");
            } else System.out.println("ERROR. Capacity != 0. Try again.");
        }
        return true;
    }

}
