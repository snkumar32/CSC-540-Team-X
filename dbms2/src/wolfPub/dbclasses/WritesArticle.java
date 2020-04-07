package wolfPub.dbclasses;

public class WritesArticle {
    public Integer WAStaffID;
    public Integer WAPID;
    public Integer WAArticleID;

    public WritesArticle(Integer WAStaffID,Integer WAPID, Integer WAArticleID)
    {
        this.WAStaffID = WAStaffID;
        this.WAPID = WAPID;
        this.WAArticleID = WAArticleID;
    }
    public Integer getWAStaffID() { return this.WAStaffID; }
    public Integer getWAPID() { return this.WAPID; }
    public Integer getWAArticleID() { return this.WAArticleID; }

    public void setWAStaffID( Integer WAStaffID) {  this.WAStaffID =  WAStaffID;}
    public void setWAPID(Integer WAPID) {  this.WAPID =  WAPID;}
    public void setWAArticleID(Integer WAArticleID) {  this.WAArticleID =  WAArticleID;}
}
