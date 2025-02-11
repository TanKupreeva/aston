package org.example.finder;

import org.example.entity.Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class FinderCar extends Finder<Car> {
    public FinderCar(BufferedReader bufferedReader, List<Car> originalList, Comparator<Car> comparator) {
        super(bufferedReader, originalList, comparator);
//        menuBuilder2
//                .append("Where:\n")
//                .append("1 - power.\n")
//                .append("2 - model.\n")
//                .append("3 - year.");
    }

    @Override
    protected Car getValue() {
        int power = 0;
        String model = "";
        int year = 0;
        boolean is = true;
        while (is) {
            try {
                System.out.println("Enter power:");
                power = Integer.parseInt(bufferedReader.readLine());
                System.out.println("Enter model:");
                model = bufferedReader.readLine();
                System.out.println("Enter year:");
                year = Integer.parseInt(bufferedReader.readLine());
                is = false;
            } catch (NumberFormatException ex) {
                System.out.println("This field only accepts numbers.\n\n" +
                        "Try again.");
            }
            catch (IOException ignored) {}
        }
        Car car = Car.builder()
                .power(power)
                .model(model)
                .year(year)
                .build();
        return car;
    }

//    @Override
//    protected Car getValue(int[] arr) {
//        Car car = null;
//        boolean is = true;
//        while (is) {
//            try {
//                int power = 0;
//                String model = "";
//                int year = 0;
//                for (int j : arr) {
//                    switch (j) {
//                        case 1: {
//                            System.out.println("Enter power:");
//                            power = Integer.parseInt(bufferedReader.readLine());
//                        }
//                        break;
//                        case 2: {
//                            System.out.println("Enter model:");
//                            model = bufferedReader.readLine();
//                        }
//                        break;
//                        case 3: {
//                            System.out.println("Enter year:");
//                            year = Integer.parseInt(bufferedReader.readLine());
//                        }
//                        break;
//                    }
//                }
//                car = Car.builder()
//                        .power(power)
//                        .model(model)
//                        .year(year)
//                        .build();
//                is = false;
//            } catch (NumberFormatException ex) {
//                System.out.println("This field only accepts numbers.\n\n" +
//                        "Try filling object again.");
//            }
//            catch (IOException ignored) {}
//        }
//
//        return car;
//    }

}