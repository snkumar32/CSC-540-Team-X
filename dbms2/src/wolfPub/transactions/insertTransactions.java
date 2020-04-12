package wolfPub.transactions;

import wolfPub.connection.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class insertTransactions {

    public static boolean insertOrder(Integer orderid,String deadline_date,String placement_date,Float shipping_cost,Float price,Float total_pay,Integer did,Integer pid,Integer noc) throws SQLException {
        Connection conn = null;
        boolean first = false,second = false,third = false;
        try {
            conn = DbConnection.getConnection();
            conn.setAutoCommit(false);
            //Savepoint savepoint = conn.setSavepoint();
            try {
                String query = "insert into ORDERS values (?,?,?,?,?,?)";
                PreparedStatement st = conn.prepareStatement(query);
                st.setInt(1, orderid);
                st.setString(2, deadline_date);
                st.setString(3, placement_date);
                st.setFloat(4, shipping_cost);
                st.setFloat(5, price);
                st.setFloat(6, total_pay);

                st.executeUpdate();


                first = true;
            }
            catch(SQLException ex){
                System.out.println("First Insertion Failed");
                first = false;
                return false;
            }
            /////// end of one insertion

            try {
                String query1 = "insert into PLACES values (?,?)";
                PreparedStatement st1 = conn.prepareStatement(query1);
                st1.setInt(1, orderid);
                st1.setInt(2, did);

                st1.executeUpdate();


                second = true;
            }
            catch(SQLException ex1){
                System.out.println("Second Insertion Failed");
                conn.rollback();
                second = false;
                return false;
            }
            // end of second insertion
            try {
                String query2 = "insert into CONSISTSOF values (?,?,?)";
                PreparedStatement st2 = conn.prepareStatement(query2);
                st2.setInt(1, orderid);
                st2.setInt(2, pid);
                st2.setInt(3, noc);

                st2.executeUpdate();
                ResultSet rs2 = st2.executeQuery("select count(*) as count_val from PLACES where ORDERID=" + orderid);
                int order_id2 = 0;
                while (rs2.next())
                    order_id2 = rs2.getInt("count_val");

                if (order_id2 != 1) {
                    System.out.println("Third Insertion Failed");
                    //conn.rollback();
                }

                third = true;

            }
            catch(SQLException ex2){
                System.out.println("Third Insertion Failed");
                conn.rollback();
                return false;
            }
        if(first && second && third){
            conn.commit();
            System.out.println("Transaction Successful!");
        }
        else{
            conn.rollback();
            System.out.println("Transaction Failed");
        }

            conn.setAutoCommit(true);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            conn.rollback();
            return false;
        }

        finally {
            if(conn!=null) {
                conn.setAutoCommit(true);
            }
        }

    }

}
