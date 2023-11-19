package hei.shool.appLibrary.management.DatabaseConfig;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseSettings {
    public static Connection connect() throws SQLException {
        String jdbcUrl = System.getenv("JDBC_URL");
        String user = System.getenv("JDBC_USER");
        String password = System.getenv("JDBC_PASSWORD");
        if (jdbcUrl == null || user == null || password == null) {
            throw new IllegalStateException("Eurrer de user , url ou password");
        }
        return DriverManager.getConnection(jdbcUrl, user, password);
    }
}
