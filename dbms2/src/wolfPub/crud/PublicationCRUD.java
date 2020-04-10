package wolfPub.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import wolfPub.dbclasses.Publication;
import wolfPub.connection.*;


public class PublicationCRUD {

    public static ArrayList<Publication> viewPublication() {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from PUBLICATION");
            ArrayList<Publication> list = new ArrayList<>();
            while (rs.next()) {
                Publication p = new Publication(Integer.valueOf(rs.getInt("PID")), rs.getString("TOPIC"), rs.getString("TITLE"), rs.getString("PUB_NO"));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static ArrayList<Publication> viewPublication(Integer PID) {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from PUBLICATION where PID = " +  PID);
            ArrayList<Publication> list = new ArrayList<>();
            while (rs.next()) {
                Publication p = new Publication(Integer.valueOf(rs.getInt("PID")), rs.getString("TOPIC"), rs.getString("TITLE"), rs.getString("PUB_NO"));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



    public static Integer insertPublication(Integer PID, String topic, String title, String pub_no) {
        try {
            Connection conn = DbConnection.getConnection();
            String query = "insert into PUBLICATION(PID, TOPIC, TITLE, PUB_NO) values (?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, PID);
            st.setString(2, topic);
            st.setString(3, title);
            st.setString(4, pub_no);
            st.executeUpdate();
            ResultSet rs = st.executeQuery("select PID from PUBLICATION");
            int p_id = 0;
            while (rs.next())
                p_id = rs.getInt("PID");
            return Integer.valueOf(p_id);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }


    public static Boolean updatePublication(Integer PID, String topic, String title, String pub_no) {
        try {
            Connection conn = DbConnection.getConnection();
            String query = "Update PUBLICATION set TOPIC=?, TITLE=?, PUB_NO=? where PUBLICATION =" + PID;
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, topic);
            st.setString(2, title);
            st.setString(3, pub_no);

            st.executeUpdate();
            return Boolean.valueOf(true);
        } catch (SQLException e) {
            e.printStackTrace();
            return Boolean.valueOf(false);
        }
    }

    public static Boolean deletePublication(Integer PID) {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM PUBLICATION WHERE PID= " + PID);
            return Boolean.valueOf(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return Boolean.valueOf(false);
        }
    }

}

