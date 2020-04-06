package wolfPub.dbclasses;

public class Staff {
    public Integer StaffID;
    public String Name;
    public String SType;

    public Staff(Integer StaffID, String Name, String SType)
    {
        this.StaffID = StaffID;
        this.Name = Name;
        this.SType = SType;
    }

    public Integer getStaffID() { return this.StaffID; }
    public String getName() { return this.Name; }
    public String getType() { return this.SType; }

    public void setStaffID(Integer StaffID) { this.StaffID = StaffID; }
    public void setName(String Name) { this.Name = Name; }
    public void setSType(String SType) { this.SType = SType; }

}

