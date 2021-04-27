package pl.edu.pw.mini.wronadb;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource dataSource;

    static  {
        config.setJdbcUrl("jdbc:sqlserver://localhost\\MSSQLSERVER:1433;database=NORTHWND");
        config.setUsername("pwrona");
        config.setPassword("welcome2");
        config.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        dataSource = new HikariDataSource(config);
    }

    private DataSource() {
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
