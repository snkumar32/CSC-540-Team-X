package wolfPub.dbclasses;

public class StaffPayment {
    public Integer StaffID;
    public String PDate;
    public Float Salary;
    public String Name;
    public String SType;
    public Integer Age;
    public String Gender;

    public StaffPayment(Integer StaffID, String Name, String SType, Integer Age, String Gender, String PDate, Float Salary)
    {
        this.StaffID = StaffID;
        this.Name = Name;
        this.SType = SType;
        this.Age = Age;
        this.Gender = Gender;
        this.PDate = PDate;
        this.Salary = Salary;
    }

    public String toString()
    {
        return "STAFF (id=" + this.StaffID + ", STAFF NAME=" + this.Name + ", STAFF TYPE=" + this.SType +  ", AGE =" + this.Age  + ", GENDER=" + this.Gender + ", PAYMENT_DATE=" + this.PDate + ", SALARY=" + this.Salary + ")";

    }

}
