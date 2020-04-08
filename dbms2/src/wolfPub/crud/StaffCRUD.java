package wolfPub.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import wolfPub.dbclasses.Staff;
import wolfPub.connection.*;



public class StaffCRUD {



    public static ArrayList<Staff> viewStaff() {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from STAFF");
            ArrayList<Staff> list = new ArrayList<>();
            while (rs.next()) {
                Staff p = new Staff(Integer.valueOf(rs.getInt("STAFFID")), rs.getString("NAME"), rs.getString("TYPE"), Integer.valueOf(rs.getString("AGE")), rs.getString("GENDER"));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static ArrayList<Staff> viewStaff(Integer staffId) {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from STAFF where STAFFID = " +  staffId);
            ArrayList<Staff> list = new ArrayList<>();
            while (rs.next()) {
                Staff p = new Staff(Integer.valueOf(rs.getInt("STAFFID")), rs.getString("NAME"), rs.getString("TYPE"),Integer.valueOf(rs.getString("AGE")), rs.getString("GENDER"));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



    public static Integer insertStaff(Integer id, String NAME, String TYPE, Integer AGE, String GENDER) {
        try {
            Connection conn = DbConnection.getConnection();
            String query = "insert into STAFF(STAFFID, NAME, TYPE, AGE, GENDER ) values (?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id);
            st.setString(2, NAME);
            st.setString(3, TYPE);
            st.setInt(4, AGE);
            st.setString(5, GENDER);
            st.executeUpdate();
            ResultSet rs = st.executeQuery("select STAFFID from STAFF");
            int staff_id = 0;
            while (rs.next())
                staff_id = rs.getInt("STAFFID");
            return Integer.valueOf(staff_id);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }


    public static Boolean updateStaff(Integer id, String Name, String type, Integer age, String gender) {
        try {
            Connection conn = DbConnection.getConnection();
            String query = "Update STAFF set NAME=?, TYPE=?, AGE=?, GENDER=? where STAFFID =" + id;
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, Name);
            st.setString(2, type);
            st.setInt(3, age);
            st.setString(4, gender);

            st.executeUpdate();
            return Boolean.valueOf(true);
        } catch (SQLException e) {
            e.printStackTrace();
            return Boolean.valueOf(false);
        }
    }

    public static Boolean deleteStaff(Integer id) {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM STAFF WHERE STAFFID= " + id);
            return Boolean.valueOf(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return Boolean.valueOf(false);
        }
    }

}

