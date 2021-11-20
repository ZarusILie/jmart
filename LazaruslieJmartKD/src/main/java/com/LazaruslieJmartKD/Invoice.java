package com.LazaruslieJmartKD;
import com.LazaruslieJmartKD.dbjson.Serializable;

import java.util.Date;
import java.util.Calendar;
/**
 * class Invoice
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
    public Status status;
    
    enum Rating{
        NONE, BAD, NEUTRAL, GOOD
    }
    
    enum Status{
        WAITING_CONFIRMATION, CANCELLED, ON_PROGRESS, ON_DELIVERY, COMPLAINT,
        FINISHED, FAILED, DELIVERED
    }
    
    class Record{
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
        this.status = Status.WAITING_CONFIRMATION;
        this.complaintId = -1;
    }


    public boolean read(String content){
        return false;
    }
    
    public double getTotalPay(){
        return 0.0;
    }
}
