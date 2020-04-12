package wolfPub.crud;

import java.sql.*;
import java.util.ArrayList;
import wolfPub.dbclasses.Book;
import wolfPub.connection.*;




public class BookCRUD {

    public static ArrayList<Book> viewBook() {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from BOOK");
            ArrayList<Book> list = new ArrayList<>();
            while (rs.next()) {
                Book p = new Book(Integer.valueOf(rs.getInt("PID")), rs.getString("PUBLICATIONDATE"), rs.getString("ISBN"), Integer.valueOf(rs.getString("EDITION")));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static ArrayList<Book> viewBook(Integer PID) {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from BOOK where PID = " +  PID);
            ArrayList<Book> list = new ArrayList<>();
            while (rs.next()) {
                Book p = new Book(Integer.valueOf(rs.getInt("PID")), rs.getString("PUBLICATIONDATE"), rs.getString("ISBN"), Integer.valueOf(rs.getInt("EDITION")));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



    public static boolean insertBook(Connection conn, Integer PID, String publicationdate, String isbn, Integer edition) throws SQLException {
        try {
//            Connection conn = DbConnection.getConnection();
            String query = "insert into BOOK(PID, PUBLICATIONDATE, ISBN, EDITION) values (?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, PID);
            st.setString(2, publicationdate);
            st.setString(3, isbn);
            st.setInt(4, edition);
            st.executeUpdate();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }


    public static Boolean updateBook(Integer PID, String publicationdate, String isbn, Integer edition) {
        try {
            Connection conn = DbConnection.getConnection();
            String query = "Update BOOK set PUBLICATIONDATE=?, ISBN=?, EDITION=? where PID =?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, publicationdate);
            st.setString(2, isbn);
            st.setInt(3, edition);
            st.setInt(4, PID);
            st.executeUpdate();
            return Boolean.valueOf(true);
        } catch (SQLException e) {
            e.printStackTrace();
            return Boolean.valueOf(false);
        }
    }

    public static Boolean deleteBook(Integer PID) {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM BOOK WHERE PID= " + PID);
            return Boolean.valueOf(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return Boolean.valueOf(false);
        }
    }

}

