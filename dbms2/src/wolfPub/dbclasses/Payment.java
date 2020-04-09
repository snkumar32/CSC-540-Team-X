package wolfPub.dbclasses;

public class Payment {

    public Integer StaffID;
    public String PDate;
    public Float Salary;

    public Payment(Integer StaffID, String PDate, Float Salary)
    {
        this.StaffID = StaffID;
        this.PDate = PDate;
        this.Salary = Salary;
    }

    public Payment(Float Salary)
    {
        this.Salary = Salary;
    }

    public Integer getStaffID() { return this.StaffID; }
    public String getPDate() { return this.PDate; }
    public Float getSalary() { return this.Salary; }

    public void setStaffID(Integer StaffID) { this.StaffID = StaffID; }
    public void setPDate(String PDate) { this.PDate = PDate; }
    public void setSalary(Float Salary) { this.Salary = Salary; }

    public String toString()
    {
        return "PAYMENT (STAFF ID=" + this.StaffID + ", STAFF PAY DATE=" + this.PDate + ", STAFF SALARY=" + this.Salary + ")";
    }

}
