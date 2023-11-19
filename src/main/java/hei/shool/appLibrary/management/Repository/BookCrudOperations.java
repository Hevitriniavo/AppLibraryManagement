package hei.shool.appLibrary.management.Repository;

import hei.shool.appLibrary.management.DatabaseConfig.DatabaseConnection;
import hei.shool.appLibrary.management.Entity.Author;
import hei.shool.appLibrary.management.Entity.Book;
import hei.shool.appLibrary.management.Entity.Sex;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookCrudOperations extends DatabaseConnection implements CrudOperations<Book> {
  
    private Book transformResulToBook(ResultSet rs) throws SQLException {
        Author author = new Author(
                rs.getLong("id"), 
                rs.getString("name"), 
                Sex.valueOf(rs.getString("sex")) 
        );

        return new Book(
                rs.getInt("id"),
                rs.getString("book_name"),
                rs.getInt("page_numbers"),
                rs.getDate("release_date").toLocalDate(), 
                author
        );
    }

    private void setBookParams(PreparedStatement ps, Book book) throws SQLException {
        ps.setInt(1, book.getId());
        ps.setString(2, book.getName());
        ps.setInt(3, book.getPageNumbers());
        ps.setDate(4, Date.valueOf(book.getReleaseDate())); 
        ps.setLong(5, book.getAuthor().getId());

    }

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
            String query = "SELECT * FROM \"book\"";
            Connection connection = this.getConnection();
            try (ResultSet rs = connection.prepareStatement(query).executeQuery()) {
                while (rs.next()) {
                    Book book = transformResulToBook(rs);
                    books.add(book);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return books;
    }

    @Override
    public List<Book> saveAll(List<Book> toSave) {
        String query = "INSERT INTO \"book\" (id, book_name, page_number, release_date, author_id) VALUES (?, ?, ?, ?, ?)";
        Connection connection = this.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for (Book book : toSave) {
                this.setBookParams(preparedStatement, book);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
    @Override
    public Book save(Book toSave) {
        String query = "INSERT INTO \"book\" (id, book_name, page_number, release_date, author_id) VALUES (?, ?, ?, ?, ?)";
        Connection connection = this.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            this.setBookParams(preparedStatement, toSave);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return toSave;
    }

    @Override
    public Book delete(Book toDelete) {
        String query = "DELETE FROM \"book\" WHERE id = ?";
        Connection connection = this.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, toDelete.getId());
           preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return toDelete;
    }

}
