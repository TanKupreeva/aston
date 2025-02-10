package org.example.filling.fromfile;

import org.example.filling.Filler;

import java.io.BufferedReader;
import java.util.List;

public class FromFileFiller<T> extends Filler<T> {

    protected List<T> listFromFile;

    public FromFileFiller(BufferedReader bufferedReader, List<T> list) {
        super(bufferedReader, list);
    }

    @Override
    public String fill(int capacity){
        String flag = "";
        if (capacity <= listFromFile.size()) ;
        else {
            flag = "Capacity <= listFromFile.size()";
            capacity = listFromFile.size();
        }
        int j = 0;
        for (int i = 0; i < capacity; i++) {
            T t =listFromFile.get(j);
            list.add(t);
        }

        return "***************************************************************************************\n" +
                "Add " + capacity + " objects from file." + flag +
                "***************************************************************************************\n" ;
    }

    @Override
    protected T getValue() {
        return null;
    }

}
