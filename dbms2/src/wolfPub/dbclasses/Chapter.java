package wolfPub.dbclasses;

public class Chapter {
    public Integer PID;
    public Integer ChapterID;
    public String CTitle;

    public Chapter(Integer PID,Integer ChapterID,String CTitle)
    {
        this.PID = PID;
        this.ChapterID = ChapterID;
        this.CTitle = CTitle;
    }
    public Integer getPID() { return this.PID; }
    public Integer getChapterID() { return this.ChapterID; }
    public String getCTitle() { return this.CTitle; }

    public void setPID( Integer PID) {  this.PID =  PID;}
    public void setChapterID(Integer ChapterID) {  this.ChapterID =  ChapterID;}
    public void setCTitle(String CTitle) {  this.CTitle = CTitle; }

}
