package random;

import java.util.Scanner;

import static random.Util.readFile;

public class FillClassBook implements FillTheArray {
    @Override
    public Book[] fillByFile(String path) {
        String sb = readFile(path);
        String[] word = sb.split("\\;|\\n");

        Book[] books = new Book[word.length / 3];
        for (int i = 0, j = 0; i < word.length; i++, j++) {
            Book book = new Book.BookBuilder(word[i].trim(), word[++i].trim(), Integer.parseInt(word[++i].trim())).build();
//            book.setAuthor(word[i].trim());
//            book.setBook(word[++i].trim());
//            book.setPage(Integer.parseInt(word[++i].trim()));
            books[j] = book;
            System.out.println(j + " " + books[j]);
        }
        return books;
    }

    @Override
    public void fillByRandomVersion2() {

        String[] authorArr = {"Иванов", "Петров", "Сидоров", "Павлов", "Александров", "Смирнов", "Попов", "Васильев", "Волков"};
        String[] bookArr = {"Сказки", "Повести", "Рассказы", "Поэмы", "Стихи", "Новеллы", "Романы"};

        System.out.println("Введите количество необходимых объектов");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Введите начальное значение количества страниц");
        int a = sc.nextInt();
        System.out.println("Введите конечное значение количества страниц");
        int b = sc.nextInt();
        Book[] books = new Book[n];
        for (int i = 0; i < n; i++) {
            Book book = new Book.BookBuilder(authorArr[Util.genRandom(bookArr.length - 1)], bookArr[Util.genRandom(bookArr.length - 1)], Util.genRandom(a, b)).build();
            books[i] = book;
            System.out.println(books[i]);
        }
    }

    @Override
    public void fillByRandomVersion1(String path) {

        FillClassBook fillClassBook = new FillClassBook();
        Book[] books = fillClassBook.fillByFile(path);
        System.out.println("Введите количество необходимых объектов");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        System.out.println("Выберите интересующий критерий 1-АВТОР, 2-НАЗВАНИЕ, 3-КОЛИЧЕСТВО СТРАНИЦ");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int counter = 0;
        switch (x) {
            case 1: {
                System.out.println("Введите имя автора");
                String str = sc.next();

                for (Book book : books) {
                    if (book.getAuthor().toLowerCase().contains(str.toLowerCase())) {
                        book.getAuthor().indexOf(str);
                        System.out.println(book);
                    }
                    if (counter == n) {
                        break;
                    }
                }
                break;
            }
            case 2: {
                System.out.println("Введите название книги");
                String str2 = sc.next();

                for (Book book : books) {
                    if (book.getBook().toLowerCase().contains(str2.toLowerCase())) {
                        book.getBook().indexOf(str2);
                        System.out.println(book);
                        counter++;
                    }
                    if (counter == n) {
                        break;
                    }
                }
                break;
            }
            case 3: {
                System.out.println("Введите начальное значение");
                int a = sc.nextInt();
                System.out.println("Введите конечное значение");
                int b = sc.nextInt();
                for (Book book : books) {
                    if (book.getPage() > a && book.getPage() < b) {
                        System.out.println(book);
                        counter++;
                        if (counter > n) {
                            break;
                        }
                    }
                }
                break;
            }
            default:
                System.out.println("Неверный ввод");
        }

    }


    @Override
    public void fillByManually() {

    }
}
