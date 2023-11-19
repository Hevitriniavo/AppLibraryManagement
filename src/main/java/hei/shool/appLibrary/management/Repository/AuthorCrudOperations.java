package hei.shool.appLibrary.management.Repository;


import hei.shool.appLibrary.management.DatabaseConfig.DatabaseConnection;
import hei.shool.appLibrary.management.Entity.Author;
import hei.shool.appLibrary.management.Entity.Sex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorCrudOperations extends DatabaseConnection implements CrudOperations<Author> {
     private Author transformResulToAuthor(ResultSet rs) throws SQLException {
        return new Author(
                rs.getLong("id"),
                rs.getString("name"),
                Sex.valueOf(rs.getString("sex"))
        );
    }

    private void setAuthorParams(PreparedStatement ps, Author author) throws SQLException {
        ps.setLong(1, author.getId());
        ps.setString(2, author.getName());
        ps.setString(3, author.getSex().toString()); 
    }
    

    @Override
    public List<Author> findAll() {
        List<Author> authors = new ArrayList<>();
            String query = "SELECT * FROM \"author\"";
            Connection connection = this.getConnection();
            try (ResultSet rs = connection.prepareStatement(query).executeQuery()) {
                while (rs.next()) {
                    Author author = transformResulToAuthor(rs);
                    authors.add(author);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return authors;
    }

    @Override
    public List<Author> saveAll(List<Author> toSave) {
        String query = "INSERT INTO \"author\" (id, name, sex) VALUES (?, ?, ?)";
        Connection connection = this.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for (Author author : toSave) {
                this.setAuthorParams(preparedStatement, author);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
    @Override
    public Author save(Author toSave) {
        String query = "INSERT INTO \"author\" (id, name, sex) VALUES (?, ?, ?)";
        Connection connection = this.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            this.setAuthorParams(preparedStatement, toSave);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return toSave;
    }

    @Override
    public Author delete(Author toDelete) {
        String query = "DELETE FROM \"author\" WHERE id = ?";
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

