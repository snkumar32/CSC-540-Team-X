package wolfPub.dbclasses;

public class ConsistsOf {

    public Integer OrderID;
    public Integer PID;
    public Integer NO_OF_COPIES;

    public ConsistsOf(Integer OrderID, Integer PID, Integer NO_OF_COPIES)
    {
        this.OrderID = OrderID;
        this.PID = PID;
        this.NO_OF_COPIES = NO_OF_COPIES;
    }
    public Integer getOrderID() { return this.OrderID; }
    public Integer getPID() { return this.PID; }
    public Integer getNO_OF_COPIES() { return this.NO_OF_COPIES; }

    public void setOrderID(Integer OrderID) { this.OrderID = OrderID; }
    public void setPID(Integer PID) { this.PID = PID; }
    public void setgetNO_OF_COPIES(Integer NO_OF_COPIES) { this.NO_OF_COPIES = NO_OF_COPIES; }


}
