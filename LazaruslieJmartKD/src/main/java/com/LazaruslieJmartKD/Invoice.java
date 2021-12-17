package com.LazaruslieJmartKD;
import com.LazaruslieJmartKD.dbjson.Serializable;
import java.util.Date;
import java.util.Calendar;

/**
 * abstract class Invoice
 *
 * @author (Lazaruslie Karsono)
 * 
 */

public abstract class Invoice extends Serializable
{
    public final Date date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    
    public enum Rating{
        NONE, BAD, NEUTRAL, GOOD
    }
    
    public enum Status{
        WAITING_CONFIRMATION, CANCELLED, ON_PROGRESS, ON_DELIVERY, COMPLAINT,
        FINISHED, FAILED, DELIVERED
    }
    
    public class Record{
        public Date date;
        public String message;
        public Status status;
    }
    
    public Invoice(int buyerId, int productId) {
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = java.util.Calendar.getInstance().getTime();
        Calendar date = Calendar.getInstance();
        System.out.println(date.getTime());
        this.rating = Rating.NONE;
        this.complaintId = -1;
    }
    
    public abstract double getTotalPay(Product product);
}
