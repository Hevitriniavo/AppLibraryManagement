package hei.shool.appLibrary.management.Entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Author extends User{
    private List<Book> books;
    private Sex sex;

    public Author(long id, String name) {
        super(id, name);
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        book.setAuthor(this);
    }

    public void removeBook(Book book) {
        books.remove(book);
        book.setAuthor(null);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author author)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(books, author.books) && sex == author.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), books, sex);
    }

    @Override
    public String toString() {
        return "Author{" +
                "books=" + books +
                ", sex=" + sex +
                super.toString()+
                '}';
    }
}
