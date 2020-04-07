package wolfPub.dbclasses;

public class Article {

    public Integer PID;
    public Integer ArticleID;
    public String Text;

    public Article(Integer PID,Integer ArticleID,String Text)
    {
        this.PID = PID;
        this.ArticleID = ArticleID;
        this.Text = Text;
    }
    public Integer getPID() { return this.PID; }
    public Integer getArticleID() { return this.ArticleID; }
    public String getText() { return this.Text; }

    public void setPID( Integer PID) {  this.PID =  PID;}
    public void setArticleID(Integer ArticleID) {  this.ArticleID =  ArticleID;}
    public void setText(String Text) {  this.Text = Text; }
}
