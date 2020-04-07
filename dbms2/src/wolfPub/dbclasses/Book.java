package wolfPub.dbclasses;

public class Book {
    public Integer PID;
    public String PublicationDate;
    public String ISBN;
    public Integer Edition;

    public Book(Integer PID,String PublicationDate,String ISBN, Integer Edition)
    {
        this.PID = PID;
        this.PublicationDate = PublicationDate;
        this.ISBN = ISBN;
        this.Edition = Edition;
    }
    public Integer getPID() { return this.PID; }
    public String getPublicationDate() { return this.PublicationDate; }
    public String getISBN() { return this.ISBN; }
    public Integer getEdition() { return this.Edition; }

    public void setPID( Integer PID) {  this.PID =  PID;}
    public void setPublicationDate(String PublicationDate) {  this.PublicationDate =  PublicationDate;}
    public void setISBN(String ISBN) {  this.ISBN = ISBN; }
    public void setEdition(Integer Edition) {  this.Edition = Edition; }

}
