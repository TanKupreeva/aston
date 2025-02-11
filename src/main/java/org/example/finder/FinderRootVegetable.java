package org.example.finder;

import org.example.entity.RootVegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class FinderRootVegetable extends Finder<RootVegetable> {
    public FinderRootVegetable(BufferedReader bufferedReader, List<RootVegetable> originalList, Comparator<RootVegetable> comparator) {
        super(bufferedReader, originalList, comparator);
    }

    @Override
    protected RootVegetable getValue() {
        String type = "";
        double weight = 0;
        String color = "";
        boolean is = true;
        while (is) {
            try {
                System.out.println("Enter type:");
                type = bufferedReader.readLine();
                System.out.println("Enter weight:");
                weight = Double.parseDouble(bufferedReader.readLine());
                System.out.println("Enter color:");
                color = bufferedReader.readLine();
                is = false;
            } catch (NumberFormatException ex) {
                System.out.println("This field only accepts numbers.\n\n" +
                        "Try again.");
            }
            catch (IOException ignored) {}
        }
        RootVegetable rootVegetable = RootVegetable.builder()
                .type(type)
                .weight(weight)
                .color(color)
                .build();
        return rootVegetable;
    }

}
