package wolfPub.menu;

import wolfPub.connection.DbConnection;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection connection = DbConnection.getConnection();
            Statement statement = null;
            ResultSet result = null;
            try {
                statement = connection.createStatement();
                result = statement.executeQuery("SELECT * FROM PUBLICATION");

                while (result.next()) {
                    String name = result.getString("PID");
                    String title = result.getString("TITLE");
                    System.out.println(name + "  " + title);
                }


            } catch (Throwable oops) {
                oops.printStackTrace();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

