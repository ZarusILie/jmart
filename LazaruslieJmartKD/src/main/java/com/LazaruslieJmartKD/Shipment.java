package com.LazaruslieJmartKD;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * class Shipment
 *
 * @author (Lazaruslie Karsono)
 * 
 */
public class Shipment
{
    public String address;
    public int cost;
    public byte plan;
    public String receipt;
    public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("EEE MMMM dd yyyy");
    public static final Plan INSTANT = new Plan((byte)(1<<0));
    public static final Plan SAME_DAY = new Plan((byte)(1<<1));
    public static final Plan NEXT_DAY = new Plan((byte)(1<<2));
    public static final Plan REGULER = new Plan((byte)(1<<3));
    public static final Plan KARGO = new Plan((byte)(1<<4));

    static class Plan {
        public final byte bit;

        private Plan(byte bit) {
            this.bit = bit;
        }
    }

        
        public String getEstimatedArrival(Date reference){
            if((INSTANT.bit & plan) != 0 || (SAME_DAY.bit & plan) != 0){
                return ESTIMATION_FORMAT.format(reference);
            }
            else if((SAME_DAY.bit & plan) != 0){
                return ESTIMATION_FORMAT.format(reference);
            }
            else if((NEXT_DAY.bit & plan) != 0){
                return ESTIMATION_FORMAT.format(reference.getDay()+1);
            }
            else if((REGULER.bit & plan) !=0){
                return ESTIMATION_FORMAT.format(reference.getDay()+2);
            }
            else{
                return ESTIMATION_FORMAT.format(reference.getDay()+5);
            }
        }
    public boolean isDuration(Plan reference)
    {
        if((plan & reference.bit) != 0){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isDuration(byte object, Plan reference)
    {
        if((object & reference.bit) != 0){
            return true;
        }else{
            return false;
        }
    }

    
    public Shipment(String address, int cost, byte plan, String receipt) {
        this.address = address;
        this.cost = cost;
        this.plan = plan;
        this.receipt = receipt;
    }

}
