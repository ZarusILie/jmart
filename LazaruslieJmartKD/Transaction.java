package LazaruslieJmartKD;


/**
 * Abstract class Transaction - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Transaction extends Recognizable
{
    public String time = "Time";
    public int buyerId;
    public int storeId;
    public Rating rating = Rating.NONE;
    
    enum Rating{
        NONE, BAD, NEUTRAL, GOOD
    }
    
    protected Transaction(int id, int buyerid, int storeid){
        super(id);
        this.buyerId=buyerid;
        this.storeId=storeid;
    }
    
    protected Transaction(int id, Account buyer, Store store){
        super(id);
        this.buyerId = buyer.id;
        this.storeId = store.id;
    }
    
    public boolean validate(){
        return false;
    }
    public Transaction perform(){
        return null;
    }
}
