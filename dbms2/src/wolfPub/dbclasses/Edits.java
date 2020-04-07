package wolfPub.dbclasses;

public class Edits {
    public Integer EStaffID;
    public Integer EPID;

    public Edits(Integer EStaffID,Integer EPID)
    {
        this.EStaffID = EStaffID;
        this.EPID = EPID;
    }
    public Integer getEStaffID() { return this.EStaffID; }
    public Integer getEPID() { return this.EPID; }

    public void setEStaffID( Integer EStaffID) {  this.EStaffID =  EStaffID;}
    public void setEPID(Integer EPID) {  this.EPID =  EPID;}

}
