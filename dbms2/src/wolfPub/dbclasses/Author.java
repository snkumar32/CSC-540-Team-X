package wolfPub.dbclasses;

public class Author {
    public Integer StaffID;

    public Author(Integer StaffID)
    {
        this.StaffID = StaffID;
    }

    public Integer getStaffID() { return this.StaffID; }

    public void setStaffID(Integer StaffID) { this.StaffID = StaffID; }
}
