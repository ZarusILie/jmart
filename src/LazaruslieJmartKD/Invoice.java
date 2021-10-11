package LazaruslieJmartKD;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 * class Invoice
 *
 * @author (Lazaruslie Karsono)
 * 
 */
public abstract class Invoice extends Recognizable implements FileParser
{
    public Date date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    public Status status;
    public ArrayList<Record> history = new ArrayList<>();
    
    enum Rating{
        NONE, BAD, NEUTRAL, GOOD
    }
    
    enum Status{
        WAITING_CONFIRMATION, CANCELLED, ON_PROGRESS, ON_DELIVERY, COMPLAINT,
        FINISHED, FAILED
    }
    
    class Record{
        public Date date;
        public String message;
        public Status status;
    }
    
    protected Invoice(int id, int buyerId, int intproductId)
    {
        super(id);
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = new Date();
        this.rating = Rating.NONE;
        this.status = Status.WAITING_CONFIRMATION;
        this.complaintId = -1;
    }

    @Override
    public boolean read(String content){
        return false;
    }
    
    public abstract double getTotalPay();
}