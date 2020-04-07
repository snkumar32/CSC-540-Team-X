package wolfPub.dbclasses;

public class Publication {

    public Integer PID;
    public String topic;
    public String title;
    public String pub_no;

    public Publication(Integer PID,String topic,String title, String pub_no)
    {
        this.PID = PID;
        this.topic = topic;
        this.title = title;
        this.pub_no = pub_no;
    }
    public Integer getPID() { return this.PID; }
    public String getTopic() { return this.topic; }
    public String getTitle() { return this.title; }
    public String getPub_no() { return this.pub_no; }

    public void setPID( Integer PID) {  this.PID =  PID;}
    public void setTopic(String topic) {  this.topic =  topic;}
    public void setTitle(String title) {  this.title = title; }
    public void setPub_no(String pub_no) {  this.pub_no = pub_no; }

}
