package wolfPub.crud;

import wolfPub.connection.DbConnection;
import wolfPub.dbclasses.Payment;
import wolfPub.dbclasses.Staff;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import wolfPub.dbclasses.StaffPayment;

public class PaymentOperations {

    public static ArrayList<StaffPayment> viewStaffPaymnet() {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from STAFF NATURAL JOIN PAYMENT");
            ArrayList<StaffPayment> list = new ArrayList<>();
            while (rs.next()) {
                StaffPayment sp = new StaffPayment(Integer.valueOf(rs.getInt("STAFFID")), rs.getString("NAME"), rs.getString("TYPE"), Integer.valueOf(rs.getString("AGE")), rs.getString("GENDER"), rs.getString("PAYMENT_DATE"), Float.valueOf(rs.getString("SALARY")));
                list.add(sp);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void viewStaffTotalPaymnet(String startDate, String endDate) {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(SALARY) AS TOTAL_SALARY FROM PAYMENT P WHERE PAYMENT_DATE  BETWEEN '" + startDate + "' AND '" + endDate + "'");
            ArrayList<Payment> list = new ArrayList<>();
            while (rs.next()) {
                System.out.println(Float.valueOf(rs.getFloat(1)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }

    public static void viewEditorTotalPaymnet(String startDate, String endDate) {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(SALARY) FROM PAYMENT NATURAL JOIN EDITOR WHERE PAYMENT_DATE BETWEEN '" + startDate + "' AND '" + endDate + "'");
            ArrayList<Payment> list = new ArrayList<>();
            while (rs.next()) {
                System.out.println(Float.valueOf(rs.getFloat(1)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }

    public static void viewBookAuthorTotalPaymnet(String startDate, String endDate) {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(SALARY) FROM PAYMENT NATURAL JOIN AUTHOR NATURAL JOIN WRITES_BOOK WHERE PAYMENT_DATE BETWEEN'" + startDate + "' AND '" + endDate + "'");
            ArrayList<Payment> list = new ArrayList<>();
            while (rs.next()) {
                System.out.println(Float.valueOf(rs.getFloat(1)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }
    public static void viewArticleAuthorTotalPaymnet(String startDate, String endDate) {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(SALARY) FROM PAYMENT NATURAL JOIN AUTHOR NATURAL JOIN WRITES_ARTICLE WHERE PAYMENT_DATE BETWEEN'" + startDate + "' AND '" + endDate + "'");
            ArrayList<Payment> list = new ArrayList<>();
            while (rs.next()) {
                System.out.println(Float.valueOf(rs.getFloat(1)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }
}
