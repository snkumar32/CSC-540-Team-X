package wolfPub.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import wolfPub.dbclasses.Article;
import wolfPub.connection.*;
import wolfPub.dbclasses.Chapter;
import wolfPub.dbclasses.Staff;


public class ArticleCRUD {



    public static ArrayList<Article> viewArticle() {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from ARTICLE");
            ArrayList<Article> list = new ArrayList<>();
            while (rs.next()) {
                Article p = new Article(Integer.valueOf(rs.getInt("PID")), Integer.valueOf(rs.getString("ArticleID")), rs.getString("Text"));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



    public static Integer insertArticle(Integer PID, Integer ArticleID, String Text) {
        try {
            Connection conn = DbConnection.getConnection();
            String query = "insert into STAFF(PID, ARTICLEID, TEXT ) values (?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, PID);
            st.setInt(2, ArticleID);
            st.setString(3, Text);
            st.executeUpdate();
            ResultSet rs = st.executeQuery("select ARTICLEID from ARTICLE"); //Is this for displaying data being inserted or not
            int article_id = 0;
            while (rs.next())
                article_id = rs.getInt("ARTICLEID");
            return Integer.valueOf(article_id);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }


    public static Boolean updateArticle(Integer PID, Integer ArticleID, String Text) {
        try {
            Connection conn = DbConnection.getConnection();
            String query = "Update ARTICLE set TEXT=? where ARTICLEID=" + ArticleID;
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, Text);
            st.executeUpdate();
            return Boolean.valueOf(true);
        } catch (SQLException e) {
            e.printStackTrace();
            return Boolean.valueOf(false);
        }
    }

    public static Boolean deleteArticle(Integer ArticleID) {
        try {
            Connection conn = DbConnection.getConnection();
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM ARTICLE WHERE ARTICLEID= " + ArticleID);
            return Boolean.valueOf(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return Boolean.valueOf(false);
        }
    }

}

