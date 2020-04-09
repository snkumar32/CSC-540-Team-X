package wolfPub.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import wolfPub.dbclasses.Chapter;
import wolfPub.connection.*;
import wolfPub.dbclasses.Staff;


public class ChapterCRUD {



    public static ArrayList<Chapter> viewChapter() {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from CHAPTER");
            ArrayList<Chapter> list = new ArrayList<>();
            while (rs.next()) {
                Chapter p = new Chapter(Integer.valueOf(rs.getInt("PID")), Integer.valueOf(rs.getString("ChapterID")), rs.getString("CTitle"));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



    public static Integer insertChapter(Integer PID, Integer ChapterID, String CTitle) {
        try {
            Connection conn = DbConnection.getConnection();
            String query = "insert into CHAPTER(PID, CHAPTERID, CTITLE) values (?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, PID);
            st.setInt(2, ChapterID);
            st.setString(3, CTitle);
            st.executeUpdate();
            ResultSet rs = st.executeQuery("select CHAPTERID from CHAPTER");
            int chapter_id = 0;
            while (rs.next())
                chapter_id = rs.getInt("CHAPTERID");
            return Integer.valueOf(chapter_id);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }


    public static Boolean updateChapter(Integer PID, Integer ChapterID, String CTitle) {
        try {
            Connection conn = DbConnection.getConnection();
            String query = "Update CHAPTER set CTITLE=? where CHAPTERID=" + ChapterID + "and PID=" + PID;
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, CTitle);
            st.executeUpdate();
            return Boolean.valueOf(true);
        } catch (SQLException e) {
            e.printStackTrace();
            return Boolean.valueOf(false);
        }
    }

    public static Boolean deleteChapter(Integer PID, Integer ChapterID) {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM CHAPTER WHERE CHAPTERID= " + ChapterID + "and PID=" + PID);
            return Boolean.valueOf(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return Boolean.valueOf(false);
        }
    }

}

