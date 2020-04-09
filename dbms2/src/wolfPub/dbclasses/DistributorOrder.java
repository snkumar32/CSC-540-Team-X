package wolfPub.dbclasses;

public class DistributorOrder {
    public Integer DistributorID;
    public String Name;
    public String DType;
    public Integer Phone;
    public Float Balance;
    public String Contact_Person;
    public String Street;
    public String City;
    public Integer OrderID;
    public String Deadline_Date;
    public String Placement_Date;
    public Float Shipping_cost;
    public Float Price;
    public Integer PID;
    public String topic;
    public String title;
    public String pub_no;


    public DistributorOrder(Integer DistributorID,String Name,String DType, Integer Phone, Float Balance, String Contact_Person, String Street,String City)
    {
        this.DistributorID = DistributorID;
        this.Name = Name;
        this.DType = DType;
        this.Phone = Phone;
        this.Balance = Balance;
        this.Contact_Person = Contact_Person;
        this.Street = Street;
        this.City = City;
        this.OrderID = OrderID;
        this.Deadline_Date = Deadline_Date;
        this.Placement_Date = Placement_Date;
        this.Shipping_cost = Shipping_cost;
        this.Price = Price;
        this.PID = PID;
        this.topic = topic;
        this.title = title;
        this.pub_no = pub_no;
    }
}
