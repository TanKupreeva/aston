package org.example.random;

import java.util.Scanner;

public class FillClassCar implements FillTheArray{

    @Override
    public Object[] fillByFile(String path) {
        return new Object[0];
    }

    @Override
    public void fillByRandomVersion1(String path) {

    }

    @Override
    public void fillByRandomVersion2() {
        String[] modelArr = {"BMW", "Mercedes", "Audi", "Ford", "Porche", "Toyota", "Volkswagen", "Ferrari", "Tesla"};


        System.out.println("Введите количество необходимых объектов");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Введите начальное значение мощности");
        int powerStart = sc.nextInt();
        System.out.println("Введите конечное значение мощности");
        int powerEnd = sc.nextInt();
        System.out.println("Введите начальное значение года выпуска");
        int yearStart = sc.nextInt();
        System.out.println("Введите конечное знаение года выпуска");
        int yearEnd = sc.nextInt();


        Car[] cars = new Car[n];
        for (int i = 0; i < n; i++) {
            Car car = new Car.CarBuilder(Util.genRandom(powerStart, powerEnd), modelArr[Util.genRandom(modelArr.length - 1)], Util.genRandom(yearStart, yearEnd)).build();
            cars[i] = car;
            System.out.println(cars[i]);
        }
    }

    @Override
    public void fillByManually() {

    }
}
