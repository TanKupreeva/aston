package org.example.soututils;

import org.example.entity.Car;

import java.io.BufferedReader;
import java.io.IOException;

public class GetValueCar extends GetValue<Car>{

    public GetValueCar(BufferedReader bufferedReader) {
        super(bufferedReader, null);
        function = this::getValue;
    }

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
                System.out.print("This field only accepts numbers.\n\n" +
                        (i != -1 ? "Try filling object number " + i + " again." : "Try again."));
            } catch (IOException e) {
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
