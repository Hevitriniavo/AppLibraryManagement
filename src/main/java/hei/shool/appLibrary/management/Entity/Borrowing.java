package hei.shool.appLibrary.management.Entity;


import java.time.LocalDateTime;
import java.util.Objects;

public class Borrowing {
    private int id;
    private LocalDateTime borrowingDate;
    private LocalDateTime returnDate;
    private Subscriber subscriber;
    private Administrator administrator;
    private Book book;

    public Borrowing(int id, LocalDateTime borrowingDate, LocalDateTime returnDate, Subscriber subscriber, Administrator administrator, Book book) {
        this.id = id;
        this.borrowingDate = borrowingDate;
        this.returnDate = returnDate;
        this.subscriber = subscriber;
        this.administrator = administrator;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(LocalDateTime borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Borrowing borrowing)) return false;
        return id == borrowing.id && Objects.equals(borrowingDate, borrowing.borrowingDate) && Objects.equals(returnDate, borrowing.returnDate) && Objects.equals(subscriber, borrowing.subscriber) && Objects.equals(administrator, borrowing.administrator) && Objects.equals(book, borrowing.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, borrowingDate, returnDate, subscriber, administrator, book);
    }

    @Override
    public String toString() {
        return "Borrowing{" +
                "id=" + id +
                ", borrowingDate=" + borrowingDate +
                ", returnDate=" + returnDate +
                ", subscriber=" + subscriber +
                ", administrator=" + administrator +
                ", book=" + book +
                '}';
    }
}


