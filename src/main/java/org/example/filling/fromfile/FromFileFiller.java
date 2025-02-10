package org.example.filling.fromfile;

import org.example.filling.Filler;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.function.IntConsumer;

public class FromFileFiller<T> extends Filler<T> {

//    IntConsumer intConsumer = (i) -> originalList.add(listFromFile.get(i));

    protected List<T> listFromFile;

    public FromFileFiller(BufferedReader bufferedReader, List<T> originalList) {
        super(bufferedReader, originalList, null);
        this.originalList = originalList;
        this.bufferedReader = bufferedReader;
        this.intConsumer = (i) -> originalList.add(listFromFile.get(i));
        menuBuilder2.append("Enter the number of objects to add from the file.\n")
                .append("Or enter \"all\" to add all data from the file.\n")
                .append("Or enter \"exit\" for exit.");
    }

    public boolean checkInputData(String line) {
//        while (true) {
//            System.out.println("Enter the number of objects to add from the file.\n" +
//                    "Or enter \"all\" to add all data from the file.\n" +
//                    "Or enter \"exit\" for exit.\n");
//            try {
//                String line = bufferedReader.readLine();
//                if (line.equalsIgnoreCase("exit")) {
//                    System.out.println("***************************************************************************************\n" +
//                            "Exit filler.\n" +
//                            "***************************************************************************************\n");
//                    break;
//                } else {
                    if (line.equalsIgnoreCase("all")) {
                        fill(listFromFile.size());
                        return false;
                    } else {
                        int capacity = Integer.parseInt(line);
                        if (capacity != 0)  {
                            if (capacity < listFromFile.size()) {
                                fill(capacity);
                                return false;
                            } else System.out.println("Capacity exceeds the limit. Try again.");
                        }
                        else System.out.println("Capacity != 0. Try again.");

                    }
                    return true;
//                }
//
//            } catch (NumberFormatException ex) {
//                System.out.println("This handler only accepts numbers. Try again.\n");
//            }
//            catch (IOException ignored) {}
//        }
    }

}
