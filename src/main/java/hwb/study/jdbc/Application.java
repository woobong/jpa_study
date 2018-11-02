package hwb.study.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Application {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/springdata?characterEncoding=UTF-8&serverTimezone=UTC";
        String user = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection created: " + connection);
            // String sql = "CREATE TABLE ACCOUNT (id int, username varchar(255), password varchar(255))";
            String sql = "INSERT INTO ACCOUNT VALUES(1, 'woobeom', '1234qwer')";
            // String sql = "CREATE TABLE ACCOUNT (id int, username varchar(255), password varchar(255))";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.execute();
            }
        }
    }
}
