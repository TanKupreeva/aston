package org.example.filling;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public abstract class Filler<T>{

    protected BufferedReader bufferedReader;

    protected List<T> list;

    public Filler(BufferedReader bufferedReader, List<T> list) {
        this.list = list;
        this.bufferedReader = bufferedReader;
    }

    public String enterCapacity() {
        boolean is = true;
        int capacity = 0;
        while (is) {
            System.out.println("Enter capacity, or 0 for exit:");
            try {
                capacity = Integer.parseInt(bufferedReader.readLine());
                is = false;
            } catch (NumberFormatException ex) {
                System.out.println("This handler only accepts numbers. Try again.\n");
            }
            catch (IOException ignored) {}
        }
        return fill(capacity);
    }

    public String fill(int capacity){
        if (capacity != 0) {
            for (int i = 0; i < capacity; i++) {
                list.add(getValue());
            }
            return "***************************************************************************************\n" +
                    "Add " + capacity + " objects."+
                    "***************************************************************************************\n";
        }
        else return "***************************************************************************************\n" +
                "Exit from filling." +
                "***************************************************************************************\n";

    }

    protected abstract T getValue();
}
