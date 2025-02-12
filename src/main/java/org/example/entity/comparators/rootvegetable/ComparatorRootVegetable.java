package org.example.entity.comparators.rootvegetable;

import org.example.entity.Book;
import org.example.entity.RootVegetable;
import org.example.entity.comparators.AllComparator;
import org.example.entity.comparators.rootvegetable.additional.Additional1ComparatorRootVegetable;
import org.example.entity.comparators.rootvegetable.defaultt.DefaultComparatorRootVegetable;

import java.util.Comparator;

public class ComparatorRootVegetable extends AllComparator<RootVegetable> {

    public ComparatorRootVegetable(Comparator<Book> comparatorDefault, Comparator<Book> comparatorAdditional) {
        super(new DefaultComparatorRootVegetable().getComparator(), new Additional1ComparatorRootVegetable().getComparator());
    }

}
