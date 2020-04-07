package wolfPub.dbclasses;

public class PeriodicPublication {
    public Integer PID;
    public String PPtype;
    public String IssueDate;
    public String Periodicity;

    public PeriodicPublication(Integer PID,String PPtype,String IssueDate, String Periodicity)
    {
        this.PID = PID;
        this.PPtype = PPtype;
        this.IssueDate = IssueDate;
        this.Periodicity = Periodicity;
    }
    public Integer getPID() { return this.PID; }
    public String getPPtype() { return this.PPtype; }
    public String getIssueDate() { return this.IssueDate; }
    public String getPeriodicity() { return this.Periodicity; }

    public void setPID( Integer PID) {  this.PID =  PID;}
    public void setPPtype(String PPtype) {  this.PPtype =  PPtype;}
    public void setIssueDate(String IssueDate) {  this.IssueDate = IssueDate; }
    public void setPeriodicity(String Periodicity) {  this.Periodicity = Periodicity; }

}
