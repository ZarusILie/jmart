package LazaruslieJmartKD;


/**
 * Write a description of class ShipmentDuration here.
 *
 * @author (Lazaruslie Karsono)
 * 
 */
public class ShipmentDuration
{
    public static final ShipmentDuration INSTANT = new ShipmentDuration(1<<0);
    public static final ShipmentDuration SAME_DAY = new ShipmentDuration(1<<1);
    public static final ShipmentDuration NEXT_DAY = new ShipmentDuration(1<<2);
    public static final ShipmentDuration REGULER = new ShipmentDuration(1<<3);
    public static final ShipmentDuration KARGO = new ShipmentDuration(1<<4);
    private int bit;
    
   
    public ShipmentDuration(int bit)
    {
        this.bit = bit;
    }
   
}
