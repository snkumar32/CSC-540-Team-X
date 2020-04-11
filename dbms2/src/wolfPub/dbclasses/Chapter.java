package wolfPub.dbclasses;

public class Chapter {
    public Integer PID;
    public Integer ChapterID;
    public String Title;

    public Chapter(Integer PID,Integer ChapterID,String Title)
    {
        this.PID = PID;
        this.ChapterID = ChapterID;
        this.Title = Title;
    }
    public Integer getPID() { return this.PID; }
    public Integer getChapterID() { return this.ChapterID; }
    public String getTitle() { return this.Title; }

    public void setPID( Integer PID) {  this.PID =  PID;}
    public void setChapterID(Integer ChapterID) {  this.ChapterID =  ChapterID;}
    public void setTitle(String title) {  this.Title = title; }

}
