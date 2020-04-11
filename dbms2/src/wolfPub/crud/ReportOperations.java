package wolfPub.crud;

import wolfPub.connection.DbConnection;
import wolfPub.dbclasses.DistributorOrder;
import wolfPub.dbclasses.Payment;
import wolfPub.dbclasses.StaffPayment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ReportOperations {

    public static void viewTotalNumberOFCopiesPerDistributorPerMonth() {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(C.NO_OF_COPIES),SUM(O.PRICE), P.DID, MONTH(PLACEMENT_DATE), YEAR(PLACEMENT_DATE) FROM CONSISTSOF C NATURAL JOIN PLACES P NATURAL JOIN ORDERS O group by P.DID, MONTH(PLACEMENT_DATE), YEAR(PLACEMENT_DATE)");
            while (rs.next()) {
                System.out.println("( Number Of Copies = " + Integer.valueOf(rs.getInt(1)) + " , Price = " + Float.valueOf(rs.getFloat(2)) + " , Distributor ID = " + Integer.valueOf(rs.getInt(3)) + " , Month = " + rs.getString(4) + " , Year = " + rs.getInt(5) + " )");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }
    public static void viewTotalNumberOFCopiesPerDistributorPerMonth(Integer DID, Integer Month, Integer Year) {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(C.NO_OF_COPIES),SUM(O.PRICE), P.DID, MONTH(PLACEMENT_DATE) AS PMONTH, YEAR(PLACEMENT_DATE) AS PYEAR FROM CONSISTSOF C NATURAL JOIN PLACES P NATURAL JOIN ORDERS O group by P.DID, MONTH(PLACEMENT_DATE), YEAR(PLACEMENT_DATE) HAVING (DID = " + DID + " AND PMONTH =" + Month + " AND PYEAR = " + Year + ")");
            while (rs.next()) {
                System.out.println("( Number Of Copies = " + Integer.valueOf(rs.getInt(1)) + " , Price = " + Float.valueOf(rs.getFloat(2)) + " , Distributor ID = " + Integer.valueOf(rs.getInt(3)) + " , Month = " + rs.getString(4) + " , Year = " + rs.getInt(5) + " )");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }

    public static void viewTotalRevenue() {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(PRICE) AS REVENUE FROM ORDERS");
            while (rs.next()) {
                System.out.println(" TOTAL REVENUE  = " + Float.valueOf(rs.getFloat(1)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }

    public static void viewTotalExpense() {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT (SELECT SUM(SALARY) FROM PAYMENT) + (SELECT SUM(Shipping_Cost) FROM ORDERS) as TOTAL_EXPENSE");
            while (rs.next()) {
                System.out.println(" TOTAL EXPENSE  = " + Float.valueOf(rs.getFloat(1)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }

    public static void viewTotalNumberOfDistributors() {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) AS TOTAL_NO_DISTRIBUTORS FROM DISTRIBUTOR");
            while (rs.next()) {
                System.out.println(" DISTRIBUTOR COUNT  = " + Float.valueOf(rs.getFloat(1)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }
    public static void viewTotalRevenuePerCity() {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(O.PRICE) AS TOTAL_REVENUE, D.CITY  FROM DISTRIBUTOR D NATURAL JOIN PLACES P NATURAL JOIN ORDERS O GROUP BY D.CITY");
            while (rs.next()) {
                System.out.println("( TOTAL_REVENUE = " + Float.valueOf(rs.getFloat(1)) + " , City = " + rs.getString(2) + " )");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }

    public static void viewTotalRevenuePerCity(String city) {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(O.PRICE) AS TOTAL_REVENUE, D.CITY  FROM DISTRIBUTOR D NATURAL JOIN PLACES P NATURAL JOIN ORDERS O GROUP BY D.CITY HAVING CITY = '" + city + "'");
            while (rs.next()) {
                System.out.println("( TOTAL_REVENUE = " + Float.valueOf(rs.getFloat(1)) + " , City = " + rs.getString(2) + " )");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }
    public static void viewTotalRevenuePerDistributor() {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(O.PRICE) AS TOTAL_REVENUE,D.DID FROM DISTRIBUTOR D NATURAL JOIN PLACES P NATURAL JOIN ORDERS O GROUP BY D.DID");
            while (rs.next()) {
                System.out.println("( TOTAL_REVENUE = " + Float.valueOf(rs.getFloat(1)) + " , Distributor ID = " + Integer.valueOf(rs.getInt(2)) + " )");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }
    public static void viewTotalRevenuePerDistributor(Integer DID) {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(O.PRICE) AS TOTAL_REVENUE,D.DID FROM DISTRIBUTOR D NATURAL JOIN PLACES P NATURAL JOIN ORDERS O GROUP BY D.DID HAVING DID = " + DID);
            while (rs.next()) {
                System.out.println("( TOTAL_REVENUE = " + Float.valueOf(rs.getFloat(1)) + " , Distributor ID = " + Integer.valueOf(rs.getInt(2)) + " )");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }
    public static void viewTotalRevenuePerLocation() {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT D.STREET,D.CITY,SUM(O.Price) AS TOTAL_REVENUE FROM DISTRIBUTOR D NATURAL JOIN PLACES P NATURAL JOIN ORDERS O GROUP BY D.STREET,D.CITY");
            while (rs.next()) {
                System.out.println("( " + " STREET = " + (rs.getString(1)) +  " , CITY = " + (rs.getString(2)) + " , TOTAL_REVENUE = " + Float.valueOf(rs.getFloat(3)) + " )");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }
    public static void viewTotalRevenuePerLocation(String Location) {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT D.STREET,D.CITY,SUM(O.Price) AS TOTAL_REVENUE FROM DISTRIBUTOR D NATURAL JOIN PLACES P NATURAL JOIN ORDERS O GROUP BY D.STREET,D.CITY HAVING STREET = '" + Location + "'");
            while (rs.next()) {
                System.out.println("( " + " STREET = " + (rs.getString(1)) +  " , CITY = " + (rs.getString(2)) + " , TOTAL_REVENUE = " + Float.valueOf(rs.getFloat(3)) + " )");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }
}
