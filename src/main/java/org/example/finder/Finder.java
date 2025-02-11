package org.example.finder;

import org.example.utils.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public abstract class Finder<T> {

    private final static int MAX_COUNT_FIELD = 3;

    private static final String REGEX = "^(1(2|3|23)?|2(3)?|3)$";

    protected BufferedReader bufferedReader;

    protected List<T> originalList;

    private final Comparator<T> comparator;

    protected final StringBuilder menuBuilder2 = new StringBuilder()
//            .append("\nEnter a continuous combination of fields in ascending order.\n")
//            .append("Example \"1\" \"2\" \"3\" \"12\" \"13\" \"23\" \"123\"\n")
//            .append("Or enter \"all\" to add all fields.\n")
            .append("Enter data for the fields\n")
            .append("Or enter \"exit\" for exit.\n");

    public Finder(BufferedReader bufferedReader, List<T> originalList, Comparator<T> comparator) {
        this.bufferedReader = bufferedReader;
        this.originalList = originalList;
        this.comparator = comparator;
    }

    public void enterCapacity() {
        boolean isWork = true;
        while (isWork) {
            System.out.println(menuBuilder2);
            try {
                String line = bufferedReader.readLine();
                if (line.equalsIgnoreCase("exit")) {
                    System.out.print("***************************************************************************************\n" +
                            "Exit finder.\n" +
                            "***************************************************************************************\n");
                    isWork = false;
                } else {
                    createComparator();
                    isWork = false;
                }

            } catch (NumberFormatException ex) {
                System.out.print("ERROR. This handler only accepts numbers. Try again.\n");
            }
            catch (IOException ignored) {}
        }
    }

    private void createComparator() {
        T key = getValue();

        originalList.sort(comparator);
        int index = BinarySearch.search(originalList, key, comparator);

        if (index != -1) {
            System.out.print("***************************************************************************************\n" +
                    "Element found! Element=" + originalList.get(index) + "\n" +
                    "***************************************************************************************\n");
        } else System.out.print("***************************************************************************************\n" +
                "Element not found! Try again...\n"+
                "***************************************************************************************\n");
    }

    protected abstract T getValue();

    //select field
//    public void enterCapacity() {
//        boolean isWork = true;
//        while (isWork) {
//            System.out.println(menuBuilder2);
//            try {
//                String line = bufferedReader.readLine();
//                if (line.equalsIgnoreCase("exit")) {
//                    System.out.print("***************************************************************************************\n" +
//                            "Exit finder.\n" +
//                            "***************************************************************************************\n");
//                    isWork = false;
//                } else {
//
//                    if (/*1 >= line.length() && */line.length() <= MAX_COUNT_FIELD) {
//                        Matcher matcher = Pattern.compile(REGEX).matcher(line);
//                        if (matcher.matches()) {
//                            String[] arrStr = line.split("");
//                            int[] arr = new int[MAX_COUNT_FIELD];
//                            IntStream.range(0, arrStr.length).forEach(i -> {
//                                int j = Integer.parseInt(arrStr[i]);
//                                arr[j-1] = j;
//                            });
//                            createComparator(arr);
//                            isWork = false;
//                        } else System.out.print("ERROR. Enter incorrect. Try again\n");
//                    } else System.out.print("ERROR. Too large. try again...\n");
//
//                }
//
//            } catch (NumberFormatException ex) {
//                System.out.print("ERROR. This handler only accepts numbers. Try again.\n");
//            }
//            catch (IOException ignored) {}
//        }
//    }
//
//    private void createComparator(int[] arr) {
//        Comparator<T> comparator = null;
//        boolean isFirstComparator = true;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] != 0) {
//                if (isFirstComparator) {
//                    comparator = comparators[i];
//                    isFirstComparator = false;
//                } else comparator.thenComparing(comparators[i]);
//            }
//        }
//
//        T key = getValue(arr);
//
//        originalList.sort(comparator);
//        int index = BinarySearch.search(originalList, key, comparator);
//
//        if (index != -1) {
//            System.out.print("***************************************************************************************\n" +
//                    "Element found! Element=" + originalList.get(index) + "\n" +
//                    "***************************************************************************************\n");
//        } else System.out.print("***************************************************************************************\n" +
//                "Element not found! Try again...\n"+
//                "***************************************************************************************\n");
//    }

}
