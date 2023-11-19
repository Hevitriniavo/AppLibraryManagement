package hei.shool.appLibrary.management.Entity;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Administrator extends User {
    private String role;
    private String email;
    private String password;
    private LocalDateTime createdAt;
    private List<Borrowing> borrowings;

    public Administrator(long id, String name, String role, String email, String password, LocalDateTime createdAt) {
        super(id, name);
        this.role = role;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.borrowings = new ArrayList<>();
    }

    public void addBorrowing(Borrowing borrowing) {
        borrowings.add(borrowing);
        borrowing.setAdministrator(this);
    }

    public void removeBorrowing(Borrowing borrowing) {
        borrowings.remove(borrowing);
        borrowing.setAdministrator(null);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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
        if (!(o instanceof Administrator that)) return false;
        return Objects.equals(role, that.role) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(createdAt, that.createdAt) && Objects.equals(borrowings, that.borrowings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, email, password, createdAt, borrowings);
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "role='" + role + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                ", borrowings=" + borrowings +
                super.toString() +
                '}';
    }
}