package LazaruslieJmartKD;
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
    public int shipmentCost;
    public Duration duration;
    public String receipt;
    public Date date;
    
    static class Duration{
        public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("EEE MMMM dd yyyy");
        public static final Duration INSTANT = new Duration((byte)(1<<0));
        public static final Duration SAME_DAY = new Duration((byte)(1<<1));
        public static final Duration NEXT_DAY = new Duration((byte)(1<<2));
        public static final Duration REGULER = new Duration((byte)(1<<3));
        public static final Duration KARGO = new Duration((byte)(1<<4));
        public final byte bit;
        
        private Duration(byte bit){
            this.bit = bit;
        }
        
        public String getEstimatedArrival(Date reference){
            if((INSTANT.bit & bit) != 0){
                return ESTIMATION_FORMAT.format(reference);
            }
            else if((SAME_DAY.bit & bit) != 0){
                return ESTIMATION_FORMAT.format(reference);
            }
            else if((NEXT_DAY.bit & bit) != 0){
                return ESTIMATION_FORMAT.format(reference.getDay()+1);
            }
            else if((REGULER.bit & bit) !=0){
                return ESTIMATION_FORMAT.format(reference.getDay()+2);
            }
            else{
                return ESTIMATION_FORMAT.format(reference.getDay()+5);
            }
        }
    }
    
    class MultiDuration{
        public byte bit;
        
        public MultiDuration(Duration... args){
            byte bits = 0;
            for (Duration arg : args){
            bits |= arg.bit;
        }
        this.bit = bits;
        }
        
        public boolean isDuration(Duration reference){
        if((bit & reference.bit)!=0){
            return true;
        }
        else{
            return false;
        }
    }
    }
    
    public Shipment(String address, int shipmentCost, Duration duration, String receipt)
    {
        this.address = address;
        this.shipmentCost = shipmentCost;
        this.duration = duration;
        this.receipt = receipt;
    }


    public boolean read(String content){
        return false;
    }
}
