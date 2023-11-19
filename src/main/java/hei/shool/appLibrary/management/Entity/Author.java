package hei.shool.appLibrary.management.Entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Author extends User{
    private List<Book> books;

    public Author(long id, String name, Sex sex) {
        super(id, name, sex);
        this.books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
        book.setAuthor(this);
    }

    public void removeBook(Book book) {
        books.remove(book);
        book.setAuthor(null);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author author)) return false;
        return Objects.equals(books, author.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books);
    }

    @Override
    public String toString() {
        return "Author{" +
                "books=" + books +
                super.toString()+
                '}';
    }
}
