package random;


import static random.Util.readFile;

public class Main {
    public static void main(String[] args) {

        Book book = new Book();
        book.fillByRandom("/Users/tatyanakupreeva/Documents/io_tests/books.txt");
    }
}
