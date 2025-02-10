package org.example.random;


public class Main {
    public static void main(String[] args) {

        Book book = new Book();
//        book.fillByRandomVersion1("/Users/tatyanakupreeva/Documents/io_tests/books.txt");
        book.fillByRandomVersion2();

//        Book[] books = (Book[]) book.fillByFile("/Users/tatyanakupreeva/Documents/io_tests/books.txt");
//        String []authors= new String[books.length];
//        for (int i = 0; i < books.length; i++) {
//            authors[i] = books[i].getAuthor();
//        }
//        MergeSortGeneric<String> stringSorter = new MergeSortGeneric<>();
//        stringSorter.mergeSort(authors, 0, authors.length - 1);
//        System.out.println(java.util.Arrays.toString(authors));

//        RootVegetable rootVegetable = new RootVegetable();
//        rootVegetable.fillByRandomVersion2();

//        Car car = new Car();
//        car.fillByRandomVersion2();
    }
}
