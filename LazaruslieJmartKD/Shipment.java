package LazaruslieJmartKD;


/**
 * class Shipment
 *
 * @author (Lazaruslie Karsono)
 * 
 */
public class Shipment implements FileParser
{
    public String address;
    public int shipmentCost;
    public Duration duration;
    public String receipt;
    
    class Duration{
        public final Duration INSTANT = new Duration((byte)(1<<0));
        public final Duration SAME_DAY = new Duration((byte)(1<<1));
        public final Duration NEXT_DAY = new Duration((byte)(1<<2));
        public final Duration REGULER = new Duration((byte)(1<<3));
        public final Duration KARGO = new Duration((byte)(1<<4));
        private byte bit;
        
        private Duration(byte bit){
            this.bit = bit;
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

    @Override
    public boolean read(String content){
        return false;
    }
}
