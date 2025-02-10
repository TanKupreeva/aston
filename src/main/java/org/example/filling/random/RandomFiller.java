package org.example.filling.random;

import org.example.filling.Filler;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.function.IntConsumer;


public class RandomFiller<T> extends Filler<T> {

    protected List<T> listRandom;

    private final IntConsumer supplier = (i) -> {
        int to = listRandom.size() - 1;
        int random_number = (int) (Math.random() * to);
        T random_object = listRandom.get(random_number);
        originalList.add(random_object);
    };

    public RandomFiller(BufferedReader bufferedReader, List<T> originalList) {
        super(bufferedReader, originalList, supplier);
    }

    public void enterCapacity() {
        while (true) {
            System.out.println("Enter the number of objects to be added randomly.\n" +
                    "Or enter \"exit\" for exit.\n" +
                    "Attention! The data to fill in is taken from the file. The data may be repeated.\n");
            try {
                String line = bufferedReader.readLine();
                if (line.equalsIgnoreCase("exit")) {
                    System.out.println("***************************************************************************************\n" +
                            "Exit filler.\n" +
                            "***************************************************************************************\n");
                    break;
                } else {
                    int capacity = Integer.parseInt(line);
                    if (capacity != 0)  {
                        fill(capacity);
                        break;
                    }
                    else System.out.println("Capacity != 0. Try again.");
                }

            } catch (NumberFormatException ex) {
                System.out.println("This handler only accepts numbers. Try again.\n");
            }
            catch (IOException ignored) {}
        }
    }

}
