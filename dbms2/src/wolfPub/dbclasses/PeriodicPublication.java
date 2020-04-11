package wolfPub.dbclasses;

public class PeriodicPublication {
    public Integer PID;
    public String Type;
    public String IssueDate;
    public String Periodicity;

    public PeriodicPublication(Integer PID, String Type, String IssueDate, String Periodicity)
    {
        this.PID = PID;
        this.Type = Type;
        this.IssueDate = IssueDate;
        this.Periodicity = Periodicity;
    }
    public Integer getPID() { return this.PID; }
    public String getType() { return this.Type; }
    public String getIssueDate() { return this.IssueDate; }
    public String getPeriodicity() { return this.Periodicity; }

    public void setPID( Integer PID) {  this.PID =  PID;}
    public void setType(String type) {  this.Type = type;}
    public void setIssueDate(String IssueDate) {  this.IssueDate = IssueDate; }
    public void setPeriodicity(String Periodicity) {  this.Periodicity = Periodicity; }

}
