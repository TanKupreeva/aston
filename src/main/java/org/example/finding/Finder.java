package org.example.finding;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public abstract class Finder<T> {

    private final int maxCountField = 3;

    private static final String regex = "^(1(23?|2?)?|2(3?)?|3)$";

    protected BufferedReader bufferedReader;

    protected List<T> originalList;

    private final Comparator<T>[] comparators;

    protected final StringBuilder menuBuilder2 = new StringBuilder().append("Sout 123 21 2132 or exit");

    public Finder(BufferedReader bufferedReader, List<T> originalList, Comparator<T>[] comparators) {
        this.bufferedReader = bufferedReader;
        this.originalList = originalList;
        this.comparators = comparators;
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
                    Matcher matcher = Pattern.compile(regex).matcher(line);
                   if (matcher.matches()) {
                       String[] arrStr = line.split("");
                       int[] arr = new int[maxCountField];
                       IntStream.range(0, arrStr.length).forEach(i -> arr[i] = Integer.parseInt(arrStr[i]));
                       createComparator(arr);
                       isWork = false;
                   } else System.out.println("Sout incorrect. Try again");

                }

            } catch (NumberFormatException ex) {
                System.out.println("This handler only accepts numbers. Try again.\n");
            }
            catch (IOException ignored) {}
        }
    }

    protected void createComparator(int[] arr) {
        Comparator<T> comparator = null;
        boolean isFirstComparator = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                if (isFirstComparator) {
                    comparator = comparators[i];
                    isFirstComparator = false;
                } else comparator.thenComparing(comparators[i]);
            }
        }

    }

}
