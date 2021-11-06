package LazaruslieJmartKD;


/**
 *Coupon
 *
 * @author (Lazaruslie Karsono)
 * 
 */
public class Coupon extends Serializable implements FileParser
{
    public enum Type{
        DISCOUNT, REBATE
    }
    public final String name;
    public final int code;
    public final double cut;
    public final Type type;
    public final double minimum;
    private boolean used;
    
    
    
    public Coupon(int id, String name, int code, Type type, double cut, double minimum)
    {

        this.name = name;
        this.code = code;
        this.cut = cut;
        this.type = type;
        this.minimum = minimum;
        this.used = false;
    }
    
    public boolean isUsed(){
        return used;
    }
    
    public boolean canApply(PriceTag pricetag){
        if (pricetag.getAdjustedPrice() >= minimum && used){
            return true;
        }
        else {
            return false;
        }

    }
    
    public double apply(PriceTag pricetag){
        used = true;
        double applyPrice = 0;
        if (this.type == Type.DISCOUNT){
            applyPrice = (pricetag.getAdjustedPrice() * cut)/100;
        }
        else if(this.type == Type.REBATE){
            applyPrice = (pricetag.getAdjustedPrice() - cut)/100;
        }
        return applyPrice;
    }
    
    @Override
    public boolean read(String content){
        return false;
    }
}
