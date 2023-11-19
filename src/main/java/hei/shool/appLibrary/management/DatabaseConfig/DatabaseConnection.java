package hei.shool.appLibrary.management.DatabaseConfig;


import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {
    protected Connection getConnection(){
        try  {
            return DatabaseSettings.connect();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}