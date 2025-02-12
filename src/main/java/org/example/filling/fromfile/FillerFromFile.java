package org.example.filling.fromfile;

import org.example.filling.Filler;

import java.io.BufferedReader;
import java.util.List;

public class FillerFromFile<T> extends Filler<T> {

    protected final List<T> listFromFile;

    public FillerFromFile(BufferedReader bufferedReader,
                          List<T> originalList,
                          List<T> listFromFile) {
        super(bufferedReader, originalList, null);
        this.listFromFile = listFromFile;
        this.intConsumer = (i) -> originalList.add(listFromFile.get(i));
        menuBuilder2.append("Objects will be added from the file.\n")
                .append("Or enter \"all\" to add all data from the file.");
    }

    @Override
    public boolean checkInputData(String line) {
        if (line.equalsIgnoreCase("all")) {
            fill(listFromFile.size());
            return false;
        } else {
            int quantity = Integer.parseInt(line);
            if (quantity > 0)  {
                if (quantity < listFromFile.size()) {
                    fill(quantity);
                    return false;
                } else System.out.println("ERROR. Capacity exceeds the limit. Max=" + (listFromFile.size()-1) + ". Try again.");
            }
            else System.out.println("ERROR. The quantity should not be equal to " + line + ". Try again.");
        }
        return true;
    }

}
