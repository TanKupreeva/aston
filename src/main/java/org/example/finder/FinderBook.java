package org.example.finder;

import org.example.entity.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class FinderBook extends Finder<Book> {
    public FinderBook(BufferedReader bufferedReader, List<Book> originalList, Comparator<Book> comparator) {
        super(bufferedReader, originalList, comparator);
//        menuBuilder2
//                .append("Where:\n")
//                .append("1 - author.\n")
//                .append("2 - title.\n")
//                .append("3 - pages.");
    }

    @Override
    protected Book getValue() {
        String author = "";
        String title = "";
        int pages = 0;
        boolean is = true;
        while (is) {
            try {
                System.out.println("Enter author:");
                author = bufferedReader.readLine();
                System.out.println("Enter title:");
                title = bufferedReader.readLine();
                System.out.println("Enter pages:");
                pages = Integer.parseInt(bufferedReader.readLine());
                is = false;
            } catch (NumberFormatException ex) {
                System.out.println("This field only accepts numbers.\n\n" +
                        "Try again.");
            }
            catch (IOException ignored) {}
        }
        Book book = Book.builder()
                .author(author)
                .title(title)
                .pages(pages)
                .build();
        return book;
    }


//    @Override
//    protected Book getValue(int[] arr) {
//        Book book = null;
//        boolean is = true;
//        while (is) {
//            try {
//                String author = "";
//                String title = "";
//                int pages = 0;
//                for (int j : arr) {
//                    switch (j) {
//                        case 1: {
//                            System.out.println("Enter author:");
//                            author = bufferedReader.readLine();
//                        }
//                        break;
//                        case 2: {
//                            System.out.println("Enter title:");
//                            title = bufferedReader.readLine();
//                        }
//                        break;
//                        case 3: {
//                            System.out.println("Enter pages:");
//                            pages = Integer.parseInt(bufferedReader.readLine());
//                        }
//                        break;
//                    }
//                }
//                book = Book.builder()
//                        .author(author)
//                        .title(title)
//                        .pages(pages)
//                        .build();
//                is = false;
//            } catch (NumberFormatException ex) {
//                System.out.println("This field only accepts numbers.\n\n" +
//                        "Try filling object again.");
//            }
//            catch (IOException ignored) {}
//        }
//
//        return book;
//    }

}
