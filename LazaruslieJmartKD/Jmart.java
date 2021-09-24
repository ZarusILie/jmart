package LazaruslieJmartKD;


/**
 * Jmart
 *
 * @author (Lazaruslie Karsono)
 */
public class Jmart 
{    
    public static void main(String[] args) 
    {
        Product productSnack = createProduct();
        Coupon couponDiskon = createCoupon();
        ShipmentDuration shipment = createShipmentDuration();
        System.out.println(productSnack.id);
        System.out.println(productSnack.name);
        System.out.println(productSnack.weight);
        System.out.println(productSnack.conditionUsed);
        System.out.println(productSnack.priceTag.price);
        System.out.println(productSnack.category);
        System.out.println(productSnack.rating.getCount());
        System.out.println(productSnack.rating.getTotal());
        System.out.println(couponDiskon.name);
        System.out.println(couponDiskon.code);
        System.out.println(couponDiskon.type);
        System.out.println(couponDiskon.cut);
        System.out.println(couponDiskon.minimum);
        System.out.println(couponDiskon.isUsed());
     
    }
    
    public Jmart(){
        
    }
    
    public static Product createProduct(){
        Product productSnack = new Product("Chiki", 500, false, new PriceTag(30000), ProductCategory.FNB);
        return productSnack;
    }
    
    public static Coupon createCoupon(){
        return new Coupon("Discount 10%", 1, Coupon.Type.DISCOUNT, 15, 3000);
    }
    
    public static ShipmentDuration createShipmentDuration(){
        return new ShipmentDuration(ShipmentDuration.INSTANT, ShipmentDuration.SAME_DAY);
    }

}
