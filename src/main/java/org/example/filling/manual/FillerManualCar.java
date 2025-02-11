package org.example.filling.manual;

import org.example.entity.Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class FillerManualCar extends FillerManual<Car> {

    public FillerManualCar(BufferedReader bufferedReader, List<Car> list) {
        super(bufferedReader, list);
    }

    @Override
    protected Car getValue(int i) {
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
                        "Try filling object number " + i + " again.");
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

}
