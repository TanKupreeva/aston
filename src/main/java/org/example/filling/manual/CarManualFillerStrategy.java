package org.example.filling.manual;

import org.example.entity.Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class CarManualFillerStrategy extends ManualFillerStrategy<Car> {

    public CarManualFillerStrategy(List<Car> list) {
        super(list);
    }

    @Override
    protected Car getV() {
        int power = 0;
        String model = "";
        int year = 0;
        boolean is = true;
        while (is) {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));){
                System.out.println("Enter power:\n");
                power = Integer.parseInt(bufferedReader.readLine());
                System.out.println("Enter model:\n");
                model = bufferedReader.readLine();
                System.out.println("Enter year:\n");
                year = Integer.parseInt(bufferedReader.readLine());
                is = false;
            } catch (NumberFormatException ex) {
                System.out.println("This field only accepts numbers. Try again.\n");
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
