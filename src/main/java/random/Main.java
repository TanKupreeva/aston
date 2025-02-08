package random;


import static random.Util.readFile;

public class Main {
    public static void main(String[] args) {

        Book book = new Book();
//        book.fillByRandomVersion1("/Users/tatyanakupreeva/Documents/io_tests/books.txt");
        book.fillByRandomVersion2();
    }
}
