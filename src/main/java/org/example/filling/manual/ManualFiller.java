package org.example.filling.manual;

import org.example.filling.Filler;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.function.IntConsumer;

public abstract class ManualFiller<T> extends Filler<T> {

    IntConsumer supplier = (i) -> originalList.add(getValue());

    public ManualFiller(BufferedReader bufferedReader, List<T> originalList) {
        super(bufferedReader, originalList, supplier);
        this.originalList = originalList;
        this.bufferedReader = bufferedReader;
    }

    public void enterCapacity() {
        while (true) {
            System.out.println("Enter the number of objects to manual.\n" +
                    "Or enter \"exit\" for exit.\n");
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

    protected abstract T getValue();

}
