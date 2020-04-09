package wolfPub.crud;

import wolfPub.connection.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InputOrders {


    public static Integer insertOrder(Integer orderid,String deadline_date,String placement_date,Float shipping_cost,Float price,Float total_pay) {
        try {
            Connection conn = DbConnection.getConnection();
            String query = "insert into ORDERS values (?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, orderid);
            st.setString(2, deadline_date);
            st.setString(3, placement_date);
            st.setFloat(4, shipping_cost);
            st.setFloat(5, price);
            st.setFloat(6, total_pay);

            st.executeUpdate();
            ResultSet rs = st.executeQuery("select ORDERID from ORDERS");
            int order_id = 0;
            while (rs.next())
                order_id = rs.getInt("STAFFID");
            return Integer.valueOf(order_id);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

    }

        public static Integer insertPlaces(Integer orderid, Integer did) {
            try {
                Connection conn = DbConnection.getConnection();
                String query = "insert into PLACES values (?,?)";
                PreparedStatement st = conn.prepareStatement(query);
                st.setInt(1, orderid);
                st.setInt(2, did);


                st.executeUpdate();
                ResultSet rs = st.executeQuery("select ORDERID from PLACES");
                int order_id = 0;
                while (rs.next())
                    order_id = rs.getInt("STAFFID");
                return Integer.valueOf(order_id);
            } catch (SQLException ex) {
                ex.printStackTrace();
                return null;
            }
    }
    public static Integer insertConsistsOf(Integer orderid,Integer pid,Integer noc) {
        try {
            Connection conn = DbConnection.getConnection();
            String query = "insert into CONSISTSOF values (?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, orderid);
            st.setInt(2, pid);
            st.setInt(3, noc);

            st.executeUpdate();
            ResultSet rs = st.executeQuery("select ORDERID from PLACES");
            int order_id = 0;
            while (rs.next())
                order_id = rs.getInt("STAFFID");
            return Integer.valueOf(order_id);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }





}
