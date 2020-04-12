package wolfPub.crud;

import wolfPub.connection.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InputOrders {




    public static boolean updateOrderpayment(Integer did2, Integer oid2) {
        try {
            Connection conn = DbConnection.getConnection();
            String query = "update ORDERS set TOTALPAYMENT= ? where OrderID = ?";

            PreparedStatement st = conn.prepareStatement(query);
            String query1 = "select NO_OF_COPIES from CONSISTSOF where OrderID = "+oid2;
            Integer noc =0;
            ResultSet rs = st.executeQuery(query1);
            while (rs.next()) {
                noc = rs.getInt("NO_OF_COPIES");
            }
            String query2 = "select Price, Shipping_Cost from ORDERS where OrderID = "+oid2;
            float price_val = 0;
            float shipping_cost = 0;
            ResultSet rs2 = st.executeQuery(query2);
            while (rs2.next()) {
                price_val = rs2.getFloat("Price");
                shipping_cost = rs2.getFloat("Shipping_Cost");
            }
            float val = (noc * price_val) + shipping_cost;
            st.setFloat(1, val);
            st.setInt(2, oid2);

            st.executeUpdate();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }





}
