package wolfPub.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static java.lang.Class.forName;

public class DbConnection {
    public static Connection getConnection() throws SQLException
    {
        Connection connection = null;
        String jdbcUrl = ConnVariables.getUrl();
        String user = ConnVariables.getUser();
        String password = ConnVariables.getPassword();
        System.out.println("Connection about to start");
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, user, password);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("CONN: " + connection);
        return connection;
    }

}




