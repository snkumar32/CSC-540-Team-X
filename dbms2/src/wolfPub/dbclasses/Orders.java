package wolfPub.dbclasses;

public class Orders {
    public Integer OrderID;
    public String Deadline_Date;
    public String Placement_Date;
    public Float Shipping_cost;
    public Float Price;

    public Orders(Integer OrderID, String Deadline_Date, String Placement_Date, Float Shipping_cost, Float Price)
    {
        this.OrderID = OrderID;
        this.Deadline_Date = Deadline_Date;
        this.Placement_Date = Placement_Date;
        this.Shipping_cost = Shipping_cost;
        this.Price = Price;
    }
    public Integer getOrderID() { return this.OrderID; }
    public String getDeadline_Date() { return this.Deadline_Date; }
    public String getPlacement_Date() { return this.Placement_Date; }
    public Float getPrice() { return this.Price; }
    public Float getShipping_cost() { return this.Shipping_cost; }

    public void setOrderID(Integer OrderID) { this.OrderID = OrderID; }
    public void setDeadline_Date(String Deadline_Date) { this.Deadline_Date = Deadline_Date; }
    public void setPlacement_Date(String Placement_Date) { this.Placement_Date = Placement_Date; }
    public void setPrice(Float Shipping_cost) { this.Shipping_cost = Shipping_cost; }
    public void setShipping_cost(Float Price) { this.Price = Price; }

}
