package hei.shool.appLibrary.management.Entity;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Book {
    private int id;
    private String name;
    private int pageNumbers;
    private LocalDate releaseDate;
    private Author author;
    private List<Topic> topics;
    private List<Borrowing> borrowings;

    public Book(int id, String name, int pageNumbers, LocalDate releaseDate, Author author) {
        this.id = id;
        this.name = name;
        this.pageNumbers = pageNumbers;
        this.releaseDate = releaseDate;
        this.author = author;
        this.topics = new ArrayList<>();
        this.borrowings = new ArrayList<>();
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
        topic.setBook(this);
    }

    public void removeTopics(Topic topic) {
        topics.remove(topic);
        topic.setTopic(null);
    }

    public int getId() {
        return id;
    }

    public void addBorrowing(Borrowing borrowing) {
        borrowings.add(borrowing);
        borrowing.setBook(this);
    }

    public void removeBorrowing(Borrowing borrowing) {
        borrowings.remove(borrowing);
        borrowing.setBook(null);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageNumbers() {
        return pageNumbers;
    }

    public void setPageNumbers(int pageNumbers) {
        this.pageNumbers = pageNumbers;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public List<Borrowing> getBorrowings() {
        return borrowings;
    }

    public void setBorrowings(List<Borrowing> borrowings) {
        this.borrowings = borrowings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return id == book.id && pageNumbers == book.pageNumbers && Objects.equals(name, book.name) && Objects.equals(releaseDate, book.releaseDate) && Objects.equals(author, book.author) && Objects.equals(topics, book.topics) && Objects.equals(borrowings, book.borrowings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, pageNumbers, releaseDate, author, topics, borrowings);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pageNumbers=" + pageNumbers +
                ", releaseDate=" + releaseDate +
                ", author=" + author +
                ", topics=" + topics +
                ", borrowings=" + borrowings +
                '}';
    }
}
