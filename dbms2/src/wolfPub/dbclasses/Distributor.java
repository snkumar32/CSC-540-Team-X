package wolfPub.dbclasses;

public class Distributor {
    public Integer DistributorID;
    public String Name;
    public String DType;
    public Integer Phone;
    public Float Balance;
    public String Contact_Person;
    public String Street;
    public String City;

    public Distributor(Integer DistributorID,String Name,String DType, Integer Phone, Float Balance, String Contact_Person, String Street,String City)
    {
        this.DistributorID = DistributorID;
        this.Name = Name;
        this.DType = DType;
        this.Phone = Phone;
        this.Balance = Balance;
        this.Contact_Person = Contact_Person;
        this.Street = Street;
        this.City = City;
    }
    public Integer getDistributorID() { return this.DistributorID; }
    public String getName() { return this.Name; }
    public String getType() { return this.DType; }
    public Integer getPhone() { return this.Phone; }
    public Float getBalance() { return this.Balance; }
    public String getContact_Person() { return this.Contact_Person; }
    public String getStreet() { return this.Street; }
    public String getCity() { return this.City; }

    public void setDistributorID( Integer DistributorID) {  this.DistributorID =  DistributorID;}
    public void setName(String Name) {  this.Name =  Name;}
    public void setDType(String DType) {  this.DType = DType; }
    public void setPhone(Integer Phone) {  this.Phone = Phone; }
    public void setBalance(Float Balance) {  this.Balance = Balance ;}
    public void setContact_Person(String Contact_Person) {  this.Contact_Person = Contact_Person ;}
    public void setStreet( String Street) {  this.Street = Street; }
    public void setCity(String City) {  this.City =  City;}


}
