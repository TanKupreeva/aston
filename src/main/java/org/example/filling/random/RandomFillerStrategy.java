package org.example.filling.random;

import org.example.entity.Book;
import org.example.entity.Car;
import org.example.entity.RootVegetable;
import org.example.filling.FillerStrategy;
import org.example.utils.ReadFilesUtils;

import java.util.List;

public class RandomFillerStrategy<T> extends FillerStrategy<T> {

    private List<T> listRandom;

    public RandomFillerStrategy(List<T> list) {
        super(list);
        T t = (T) list.get(0).getClass();
        if (t instanceof Book) {
            listRandom = (List<T>) ReadFilesUtils.getBooksFromFile();
        } else if (t instanceof Car) {
            listRandom = (List<T>) ReadFilesUtils.getCarsFromFile();
        } else if (t instanceof RootVegetable) {
            listRandom = (List<T>) ReadFilesUtils.getRootVegetablesFromFile();
        }
    }

    @Override
    protected T getValue() {
        int to = listRandom.size() - 1;
        int random_number = (int) (Math.random() * to);
        return listRandom.get(random_number);
    }
}
