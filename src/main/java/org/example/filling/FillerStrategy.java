package org.example.filling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public abstract class FillerStrategy<T>{

    protected int defaultCapacity;

    protected List<T> list;

    public FillerStrategy(List<T> list) {
        this.list = list;
    }

    public String fill() {
        boolean is = true;
        defaultCapacity = 1;
        while (is) {
            System.out.println("Enter capacity:");
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));){
                defaultCapacity = Integer.parseInt(bufferedReader.readLine());
                is = false;
            } catch (NumberFormatException ex) {
                System.out.println("This field only accepts numbers. Try again.\n");
            }
            catch (IOException ignored) {}
        }
        return fill(defaultCapacity);
    }

    public String fill(int capacity){
        defaultCapacity = capacity;
        for (int i = 0; i < capacity; i++) {
            list.add(getValue());
        }
        return "Add " + capacity + " objects.";
    }

    protected abstract T getValue();
}
