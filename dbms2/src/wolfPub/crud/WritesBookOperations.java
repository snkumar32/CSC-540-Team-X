package wolfPub.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import wolfPub.dbclasses.*;
import wolfPub.connection.*;
import wolfPub.dbclasses.Article;
import wolfPub.dbclasses.Chapter;
import wolfPub.dbclasses.Staff;


public class WritesBookOperations {


    public static Boolean insertWritesBook(Integer StaffID, Integer PID) {
        try {
            Connection conn = DbConnection.getConnection();
            String query = "insert into WRITES_BOOK(STAFFID, PID ) values (?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, StaffID);
            st.setInt(2, PID);
            st.executeUpdate();
            ResultSet rs = st.executeQuery("select STAFFID from WRITES_BOOK"); //Is this for displaying data being inserted or not
            int staff_id = 0;
            while (rs.next())
                staff_id = rs.getInt("STAFFID");
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }





}

