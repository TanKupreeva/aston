package random;

import java.util.Objects;

public class Book extends Prog {
    private String author;
    private String book;
    private int page;

    private Book (BookBuilder bookBuilder) {
        author = bookBuilder.author;
        book = bookBuilder.book;
        page = bookBuilder.page;
    }
    public String getAuthor() {
        return author;
    }

    public String getBook() {
        return book;
    }

    public int getPage() {
        return page;
    }


    public static class BookBuilder {
        private String author;
        private String book;
        private int page;
        public BookBuilder(String author, String book, int page) {
            this.author = author;
            this.book = book;
            this.page = page;
        }
        public Book build() {
            return new Book(this);
        }

    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book1 = (Book) o;
        return page == book1.page && Objects.equals(author, book1.author) && Objects.equals(book, book1.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, book, page);
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", book='" + book + '\'' +
                ", page=" + page +
                '}';
    }
}
