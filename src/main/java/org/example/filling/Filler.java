package org.example.filling;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public abstract class Filler<T>{

    protected IntConsumer intConsumer;

    protected final BufferedReader bufferedReader;

    protected final List<T> originalList;

    protected final StringBuilder menuBuilder2 = new StringBuilder()
            .append("\nEnter the quantity of items.\n")
            .append("Or enter \"exit\" for exit.\n");

    public Filler(BufferedReader bufferedReader, List<T> originalList, IntConsumer intConsumer) {
        this.originalList = originalList;
        this.bufferedReader = bufferedReader;
        this.intConsumer = intConsumer;
    }

    public void enterCapacity() {
        boolean isWork = true;
        while (isWork) {
            System.out.println(menuBuilder2);
            try {
                String line = bufferedReader.readLine();
                if (line.equalsIgnoreCase("exit")) {
                    System.out.print("***************************************************************************************\n" +
                            "Exit filler.\n" +
                            "***************************************************************************************\n");
                    isWork = false;
                } else {
                    isWork = checkInputData(line);
                }

            } catch (NumberFormatException ex) {
                System.out.print("ERROR. This handler only accepts numbers. Try again.\n");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    protected abstract boolean checkInputData(String line);

    protected void fill(int capacity) {
        IntStream.range(0, capacity).forEach(intConsumer);
        System.out.print("***************************************************************************************\n" +
                "Add " + capacity + " objects.\n" +
                "***************************************************************************************\n");
    }
}
