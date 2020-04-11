package wolfPub.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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



    public static Integer insertBook(Integer PID, String publicationdate, String isbn, Integer edition) {
        try {
            Connection conn = DbConnection.getConnection();
            String query = "insert into BOOK(PID, PUBLICATIONDATE, ISBN, EDITION) values (?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, PID);
            st.setString(2, publicationdate);
            st.setString(3, isbn);
            st.setInt(4, edition);
            st.executeUpdate();
            ResultSet rs = st.executeQuery("select PID from BOOK");
            int p_id = 0;
            while (rs.next())
                p_id = rs.getInt("PID");
            return Integer.valueOf(p_id);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
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

