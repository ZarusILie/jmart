package LazaruslieJmartKD;


/**
 * Jmart
 *
 * @author (Lazaruslie Karsono)
 */
public class Jmart 
{
    public static int getPromo(){
        return 0;
    }
    
    public static String getCustomer(){
        return "oop";
    }
    
    public static float getDiscountPercentage(int before, int after){
        if (before < after) {
            return 0.0f;
        }
        float potongan = before-after;
        return (float) potongan/before*100;
    }
    
    public static int getDiscountedPrice(int price, float discountPercentage){
        float diskon;
        if(discountPercentage >= 100.0f){
            diskon = 100.0f;
        }
        else{
            diskon = discountPercentage;
        }
        float discountPrice;
        discountPrice = price-(price*diskon/100);
        return (int) discountPrice;
    }
    
    public static int getOriginalPrice(int discountedPrice, float discountPercentage){
        float originalPrice = (100-discountPercentage)*discountedPrice/100;
        return (int) originalPrice;
    }
    
    public static float getCommissionMultiplier(){
        return 0.05f;
    }
    
    public static int getAdjustedPrice(int price){
        float commission = getCommissionMultiplier();
        float adjustPrice = price + (price*commission);
        return (int) adjustPrice;
    }
    
    public static int getAdminFee(int price){
        float commission = getCommissionMultiplier();
        float adminFee = price*commission;
        return (int) adminFee;
    }
    
    public static void Jmart(String[] args) 
    {
       
    }

}
