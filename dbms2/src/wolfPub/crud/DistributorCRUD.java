package wolfPub.crud;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import wolfPub.dbclasses.Staff;
import wolfPub.connection.*;
import wolfPub.dbclasses.*;




public class DistributorCRUD {

    public static ArrayList<Distributor> viewDistributor() {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from DISTRIBUTOR");
            ArrayList<Distributor> list = new ArrayList<>();
            while (rs.next()) {
                Distributor p = new Distributor(Integer.valueOf(rs.getInt("DID")), rs.getString("NAME"), rs.getString("TYPE"), rs.getString("PHONE"), Float.valueOf(rs.getFloat("BALANCE")) ,rs.getString("CONTACT_PERSON"),rs.getString("STREET"),rs.getString("CITY"));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



    public static Integer insertDistributor(Integer did, String NAME, String TYPE, String phone, float balance,String contact_person,String street, String city) {
        try {
            Connection conn = DbConnection.getConnection();
            String query = "insert into DISTRIBUTOR values (?,?,?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, did);
            st.setString(2, NAME);
            st.setString(3, TYPE);
            st.setString(4, phone);
            st.setFloat(5, balance);
            st.setString(6, contact_person);
            st.setString(7, street);
            st.setString(8, city);
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


    public static Boolean updateDistributor(Integer did, String NAME, String TYPE, String phone, float balance,String contact_person,String street, String city) {
        try {
            Connection conn = DbConnection.getConnection();
            String query = "Update DISTRIBUTOR set NAME=?, TYPE=?, PHONE=?, BALANCE=?,CONTACT_PERSON = ?, STREET = ? ,CITY = ? where DID =" + did;
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, NAME);
            st.setString(2, TYPE);
            st.setString(3, phone);
            st.setFloat(4, balance);
            st.setString(5, contact_person);
            st.setString(6, street);
            st.setString(7, city);

            st.executeUpdate();
            return Boolean.valueOf(true);
        } catch (SQLException e) {
            e.printStackTrace();
            return Boolean.valueOf(false);
        }
    }

    public static Boolean deleteDistributor(Integer id) {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM DISTRIBUTOR WHERE DID= " + id);
            return Boolean.valueOf(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return Boolean.valueOf(false);
        }
    }
    public static Boolean updateDistributorBalance(Integer did, float balance) {
        try {
            Connection conn = DbConnection.getConnection();
            String query = "Update DISTRIBUTOR set  BALANCE=? where DID =" + did;
            PreparedStatement st = conn.prepareStatement(query);

            st.setFloat(1, balance);

            st.executeUpdate();

            ResultSet rs = st.executeQuery("select count(*) as count_val from DISTRIBUTOR where DID="+did +" and balance="+balance);
            int staff_id = 0;
            while (rs.next())
                staff_id = rs.getInt("COUNT_VAL");

            if(staff_id == 1){
                return true;
            }
            else{
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return Boolean.valueOf(false);
        }
    }


}
