package wolfPub.dbclasses;

public class Staff {
    public Integer StaffID;
    public String Name;
    public String SType;
    public Integer Age;
    public String Gender;

    public Staff(Integer StaffID, String Name, String SType, Integer Age, String Gender)
    {
        this.StaffID = StaffID;
        this.Name = Name;
        this.SType = SType;
        this.Age = Age;
        this.Gender = Gender;
    }

    public Integer getStaffID() { return this.StaffID; }
    public String getName() { return this.Name; }
    public String getType() { return this.SType; }
    public Integer getAge() { return this.Age; }
    public String getGender() { return this.Gender; }

    public void setStaffID(Integer StaffID) { this.StaffID = StaffID; }
    public void setName(String Name) { this.Name = Name; }
    public void setSType(String SType) { this.SType = SType; }
    public void setAge() { this.Age = Age; }
    public void setGender() { this.Gender = Gender; }

    public String toString()
    {
       return "STAFF (id=" + this.StaffID + ", STAFF NAME=" + this.Name + ", STAFF TYPE=" + this.SType +  ", AGE =" + this.Age  + ", GENDER=" + this.Gender + ")";

    }

}

