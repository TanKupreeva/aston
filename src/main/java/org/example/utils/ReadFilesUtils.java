package org.example.utils;

import org.example.entity.Book;
import org.example.entity.Car;
import org.example.entity.RootVegetable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFilesUtils {

    private static final List<Book> booksFromFile = new ArrayList<>();
    private static final List<Car> carsFromFile = new ArrayList<>();
    private static final List<RootVegetable> rootVegetablesFromFile = new ArrayList<>();

    static {
        File dir = new File("src/main/resources/examples"); //path указывает на директорию
        File[] arrFiles = dir.listFiles();

        for (File file : arrFiles) {
            switch (file.getName().toLowerCase().replaceAll("_examples.txt", "")) {
                case "book": setBooksFromFile(file);
                break;
                case "car": setCarsFromFile(file);
                break;
                case "rootvegetable": setRootVegetablesFromFile(file);
                break;
                default: {
                    System.out.println("ERROR: Check name files");
                    System.exit(0);
                }
            }
        }
    }


    private static List<String[]> setObjectsFromFile(File file) {
        List<String[]> fileContent = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));){
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                String[] arr = line.split("; ");
                fileContent.add(arr);
            }

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: FileNotFoundException");
            e.printStackTrace();
            System.exit(0);
        } catch (IOException e) {
            System.out.println("ERROR: IOException");
            e.printStackTrace();
            System.exit(0);
        }
        return fileContent;
    }
    
    
    private static void setBooksFromFile(File file) {
        List<String[]> fileContent = setObjectsFromFile(file);
        for (String[] s : fileContent) {
            String author = s[0];
            String title = s[1];
            int pages = Integer.parseInt(s[2]);

            Book book = Book.builder()
                    .author(author)
                    .title(title)
                    .pages(pages)
                    .build();
            booksFromFile.add(book);
        }
    }

    private static void setCarsFromFile(File file) {
        List<String[]> fileContent = setObjectsFromFile(file);
        for (String[] s : fileContent) {
            int power = Integer.parseInt(s[0]);
            String model = s[1];
            int year = Integer.parseInt(s[2]);

            Car car = Car.builder()
                    .power(power)
                    .model(model)
                    .year(year)
                    .build();
            carsFromFile.add(car);
        }
    }

    private static void setRootVegetablesFromFile(File file) {
        List<String[]> fileContent = setObjectsFromFile(file);
        for (String[] s : fileContent) {
            String type = s[0];
            double weight = Double.parseDouble(s[1]);
            String color = s[2];

            RootVegetable rootVegetable = RootVegetable.builder()
                    .type(type)
                    .weight(weight)
                    .color(color)
                    .build();
            rootVegetablesFromFile.add(rootVegetable);
        }
    }

    public static List<Book> getBooksFromFile() {
        return booksFromFile;
    }

    public static List<Car> getCarsFromFile() {
        return carsFromFile;
    }

    public static List<RootVegetable> getRootVegetablesFromFile() {
        return rootVegetablesFromFile;
    }
}
