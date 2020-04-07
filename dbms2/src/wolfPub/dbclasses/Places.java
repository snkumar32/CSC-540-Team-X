package wolfPub.dbclasses;

public class Places {

    public Integer POrderID;
    public Integer PDistributorID;

    public Places(Integer POrderID,Integer PDistributorID)
    {
        this.POrderID = POrderID;
        this.PDistributorID = PDistributorID;
    }
    public Integer getPOrderID() { return this.POrderID; }
    public Integer getPDistributorID() { return this.PDistributorID; }

    public void setPOrderID( Integer POrderID) {  this.POrderID =  POrderID;}
    public void setPDistributorID(Integer PDistributorID) {  this.PDistributorID =  PDistributorID;}
}
