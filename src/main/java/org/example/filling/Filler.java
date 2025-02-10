package org.example.filling;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public abstract class Filler<T>{

    protected IntConsumer intConsumer;

    protected BufferedReader bufferedReader;

    protected List<T> originalList;

    protected final StringBuilder menuBuilder2 = new StringBuilder();

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
                    System.out.println("***************************************************************************************\n" +
                            "Exit filler.\n" +
                            "***************************************************************************************\n");
                    isWork = false;
                } else {
                    isWork = checkInputData(line);
                }

            } catch (NumberFormatException ex) {
                System.out.println("This handler only accepts numbers. Try again.\n");
            }
            catch (IOException ignored) {}
        }
    }


    abstract protected boolean checkInputData(String line);

    protected void fill(int capacity) {
        IntStream.range(0, capacity).forEach(intConsumer);
        System.out.println("***************************************************************************************\n" +
                "Add " + capacity + " objects.\n" +
                "***************************************************************************************\n");
    }
}
