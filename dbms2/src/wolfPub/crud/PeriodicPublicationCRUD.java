package wolfPub.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import wolfPub.dbclasses.PeriodicPublication;
import wolfPub.connection.*;
import wolfPub.dbclasses.Staff;


public class PeriodicPublicationCRUD {


    public static ArrayList<PeriodicPublication> viewPeriodicPublication() {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from PERIODICPUBLICATION");
            ArrayList<PeriodicPublication> list = new ArrayList<>();
            while (rs.next()) {
                PeriodicPublication p = new PeriodicPublication(Integer.valueOf(rs.getInt("PID")), rs.getString("TYPE"), rs.getString("ISSUEDATE"), rs.getString("PERIODICITY"));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static ArrayList<PeriodicPublication> viewPeriodicPublication(Integer PID) {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from PERIODICPUBLICATION where PID = " +  PID);
            ArrayList<PeriodicPublication> list = new ArrayList<>();
            while (rs.next()) {
                PeriodicPublication p = new PeriodicPublication(Integer.valueOf(rs.getInt("PID")), rs.getString("TYPE"), rs.getString("ISSUEDATE"), rs.getString("PERIODICITY"));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



    public static Integer insertPeriodicPublication(Integer PID, String type, String issuedate, String periodicity) {
        try {
            Connection conn = DbConnection.getConnection();
            String query = "insert into PERIODICPUBLICATION(PID, TYPE, ISSUEDATE, PERIODICITY ) values (?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, PID);
            st.setString(2, type);
            st.setString(3, issuedate);
            st.setString(4, periodicity);
            st.executeUpdate();
            ResultSet rs = st.executeQuery("select PID from PERIODICPUBLICATION");
            int p_id = 0;
            while (rs.next())
                p_id = rs.getInt("PID");
            return Integer.valueOf(p_id);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }


    public static Boolean updatePeriodicPublication(Integer PID, String type, String issuedate, String periodicity) {
        try {
            Connection conn = DbConnection.getConnection();
            String query = "Update PERIODICPUBLICATION set TYPE=?, ISSUEDATE=?, PERIODICTY=? where PID =" + PID;
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, type);
            st.setString(2, issuedate);
            st.setString(3, periodicity);

            st.executeUpdate();
            return Boolean.valueOf(true);
        } catch (SQLException e) {
            e.printStackTrace();
            return Boolean.valueOf(false);
        }
    }

    public static Boolean deletePeriodicPublication(Integer PID) {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM PERIODICPUBLICATION WHERE PID= " + PID);
            return Boolean.valueOf(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return Boolean.valueOf(false);
        }
    }

}

