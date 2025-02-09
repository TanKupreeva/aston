package org.example.filling.fromfile;

import org.example.entity.Book;
import org.example.entity.Car;
import org.example.entity.RootVegetable;
import org.example.filling.FillerStrategy;
import org.example.utils.ReadFilesUtils;

import java.util.List;

public class FromFileFillerStrategy<T> extends FillerStrategy<T> {

    private List<T> listFromFile;

    public FromFileFillerStrategy(List<T> list) {
        super(list);
        if (t instanceof Book) {
            listFromFile = (List<T>) ReadFilesUtils.getBooksFromFile();
        } else if (t instanceof Car) {
            listFromFile = (List<T>) ReadFilesUtils.getCarsFromFile();
        } else if (t instanceof RootVegetable) {
            listFromFile = (List<T>) ReadFilesUtils.getRootVegetablesFromFile();
        }
    }

    @Override
    public String fill(){
        list.addAll(listFromFile);
        return "Add all objects from file";
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

        return "Add " + capacity + " objects from file." + flag;
    }

    @Override
    protected T getValue() {
        return null;
    }

}
