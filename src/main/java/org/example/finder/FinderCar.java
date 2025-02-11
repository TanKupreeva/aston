package org.example.finder;

import org.example.entity.Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class FinderCar extends Finder<Car> {
    public FinderCar(BufferedReader bufferedReader, List<Car> originalList, Comparator<Car> comparator) {
        super(bufferedReader, originalList, comparator);
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
                System.out.print("This field only accepts numbers.\n\n" +
                        "Try again.");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        Car car = Car.builder()
                .power(power)
                .model(model)
                .year(year)
                .build();
        return car;
    }

}