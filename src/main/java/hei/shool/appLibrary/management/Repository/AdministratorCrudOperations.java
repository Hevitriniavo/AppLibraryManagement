package hei.shool.appLibrary.management.Repository;

import hei.shool.appLibrary.management.DatabaseConfig.DatabaseConnection;
import hei.shool.appLibrary.management.Entity.Administrator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdministratorCrudOperations extends DatabaseConnection implements CrudOperations<Administrator> {

    private Administrator transformResulToAdmin(ResultSet rs) throws SQLException {
        return new Administrator(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("role"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getTimestamp("created_at").toLocalDateTime()
        );
    }

    private void setAdminParams(PreparedStatement preparedStatement, Administrator administrator) throws SQLException {
        preparedStatement.setString(1, administrator.getName());
        preparedStatement.setString(2, administrator.getRole());
        preparedStatement.setString(3, administrator.getEmail());
        preparedStatement.setString(4, administrator.getPassword());
        preparedStatement.setTimestamp(5, Timestamp.valueOf(administrator.getCreatedAt()));
    }

    @Override
    public List<Administrator> findAll() {
        List<Administrator> administrators = new ArrayList<>();
            String query = "SELECT * FROM \"administrator\"";
            Connection connection = this.getConnection();
            try (ResultSet rs = connection.prepareStatement(query).executeQuery()) {
                while (rs.next()) {
                    Administrator administrator = transformResulToAdmin(rs);
                    administrators.add(administrator);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return administrators;
    }

    @Override
    public List<Administrator> saveAll(List<Administrator> toSave) {
        String query = "INSERT INTO \"administrator\" (name, role, email, password, created_at) VALUES (?, ?, ?, ?, ?)";
        Connection connection = this.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for (Administrator admin : toSave) {
                this.setAdminParams(preparedStatement, admin);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
    @Override
    public Administrator save(Administrator toSave) {
        String query = "INSERT INTO \"administrator\" (name, role, email, password, created_at) VALUES (?, ?, ?, ?, ?)";
        Connection connection = this.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            this.setAdminParams(preparedStatement, toSave);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return toSave;
    }

    @Override
    public Administrator delete(Administrator toDelete) {
        String query = "DELETE FROM \"administrator\" WHERE id = ?";
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
