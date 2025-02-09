package org.example.random;

import java.util.Scanner;

public class FillClassRootVegetable implements FillTheArray{
    @Override
    public Object[] fillByFile(String path) {
        return new Object[0];
    }

    @Override
    public void fillByRandomVersion1(String path) {

    }

    @Override
    public void fillByRandomVersion2() {
        String[] typeArr = {"Морковь", "Редька", "Редис", "Картофель", "Репа", "Свекла", "Брюква", "Турнепс"};
        String[] colorArr = {"Белый", "Красный", "Зеленый", "Коричневый", "Оранжевый", "Желтый", };

        System.out.println("Введите количество необходимых объектов");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Введите начальное значение веса корнеплода");
        int a = sc.nextInt();
        System.out.println("Введите конечное значение веса корнеплода");
        int b = sc.nextInt();
        RootVegetable[] rootVegetables = new RootVegetable[n];
        for (int i = 0; i < n; i++) {
            RootVegetable rootVegetable = new RootVegetable.RootVegetableBuilder(typeArr[Util.genRandom(typeArr.length - 1)], Util.genRandom(a, b), colorArr[Util.genRandom(colorArr.length - 1)]).build();
            rootVegetables[i] = rootVegetable;
            System.out.println(rootVegetables[i]);
        }
    }

    @Override
    public void fillByManually() {

    }
}
