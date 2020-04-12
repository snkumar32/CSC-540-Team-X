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


public class WritesArticleOperations {


    public static Boolean insertWritesArticle(Integer StaffID, Integer PID, Integer ArticleID) {
        try {
            Connection conn = DbConnection.getConnection();
            String query = "insert into WRITES_ARTICLE(STAFFID, PID, ARTICLEID ) values (?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, StaffID);
            st.setInt(2, PID);
            st.setInt(3, ArticleID);
            st.executeUpdate();
            ResultSet rs = st.executeQuery("select STAFFID from WRITES_ARTICLE"); //Is this for displaying data being inserted or not
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

