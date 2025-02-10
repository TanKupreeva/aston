package org.example.filling.manual;

import org.example.filling.Filler;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.function.IntConsumer;

public abstract class ManualFiller<T> extends Filler<T> {

//    IntConsumer intConsumer = (i) -> originalList.add(getValue());

    public ManualFiller(BufferedReader bufferedReader, List<T> originalList) {
        super(bufferedReader, originalList, null);
        this.originalList = originalList;
        this.bufferedReader = bufferedReader;

        this.intConsumer = (i) -> originalList.add(getValue());
        menuBuilder2.append("Enter the number of objects to manual.\n")
                .append("Or enter \"exit\" for exit.\n");
    }

    public boolean checkInputData(String line) {
//        while (true) {
//            System.out.println("Enter the number of objects to manual.\n" +
//                    "Or enter \"exit\" for exit.\n");
//            try {
//                String line = bufferedReader.readLine();
//                if (line.equalsIgnoreCase("exit")) {
//                    System.out.println("***************************************************************************************\n" +
//                            "Exit filler.\n" +
//                            "***************************************************************************************\n");
//                    break;
//                } else
//                {
                    int capacity = Integer.parseInt(line);
                    if (capacity != 0)  {
                        fill(capacity);
                        return false;
                    }
                    else System.out.println("Capacity != 0. Try again.");
                    return true;
//                }
//
//            } catch (NumberFormatException ex) {
//                System.out.println("This handler only accepts numbers. Try again.\n");
//            }
//            catch (IOException ignored) {}
//        }
    }

    protected abstract T getValue();

}
