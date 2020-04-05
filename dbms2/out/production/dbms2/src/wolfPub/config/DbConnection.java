package wolfPub.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    static Connection conn = null;

    private DbConnection() {
        Variables var = new Variables();
        String url = var.getUrl();
        String user = var.getUser();
        String password = var.getPassword();
        System.out.println("conneciton about tio start");

        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("this is ");
    }

    public static Connection getConnection() throws SQLException {
        if (conn == null);
        return conn;
    }
}


