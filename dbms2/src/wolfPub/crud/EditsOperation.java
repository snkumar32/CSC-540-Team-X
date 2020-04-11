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


public class EditsOperation {



    public static ArrayList<Edits> viewEdits() {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from EDITS");
            ArrayList<Edits> list = new ArrayList<>();
            while (rs.next()) {
                Edits p = new Edits(Integer.valueOf(rs.getInt("STAFFID")), Integer.valueOf(rs.getInt("PID")));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



    public static Integer insertEdits(Integer StaffID, Integer PID) {
        try {
            Connection conn = DbConnection.getConnection();
            String query = "insert into EDITS(STAFFID, PID ) values (?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, StaffID);
            st.setInt(2, PID);
            st.executeUpdate();
            ResultSet rs = st.executeQuery("select STAFFID from EDITS"); //Is this for displaying data being inserted or not
            int staff_id = 0;
            while (rs.next())
                staff_id = rs.getInt("STAFFID");
            return Integer.valueOf(staff_id);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void viewEditorPubInfo(Integer StaffID){
        try{

            Connection conn = DbConnection.getConnection();
            String query = "Select * from PUBLICATION where PID IN (Select PID from EDITS where STAFFID=" + StaffID +")";
            Statement st = conn.createStatement();
            ResultSet rs =  st.executeQuery(query);

            while(rs.next()){
                System.out.println("( PID = " + Integer.valueOf(rs.getInt(1)) + " , TOPIC = " + rs.getString(2) + " , TITLE = " + rs.getString(3)  + " , PUB_NO = " + rs.getString(4) + " )");
            }


        }catch (SQLException ex){
            ex.printStackTrace();
            return;
        }
    }



}

