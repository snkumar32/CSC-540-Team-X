package wolfPub.dbclasses;

public class WritesBook {
    public Integer WBStaffID;
    public Integer WBPID;

    public WritesBook(Integer WBStaffID,Integer WBPID)
    {
        this.WBStaffID = WBStaffID;
        this.WBPID = WBPID;
    }
    public Integer getWBStaffID() { return this.WBStaffID; }
    public Integer getWBPID() { return this.WBPID; }

    public void setWBStaffID( Integer WBStaffID) {  this.WBStaffID =  WBStaffID;}
    public void setWBPID(Integer WBPID) {  this.WBPID =  WBPID;}
}
