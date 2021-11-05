package LazaruslieJmartKD;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.*;

/**
 * Jmart
 *
 * @author (Lazaruslie Karsono)
 */
class Jmart
{
    class Country {
        public String name;
        public int population;
        public List<String> listOfStates;
    }

    public static void main(String[] args) {
        String filepath = "D:\\OOP\\jmart\\lib\\city.json";
        Gson gson = new Gson();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            Country input = gson.fromJson(br, Country.class);
            System.out.println("name: " + input.name);
            System.out.println("population: " + input.population);
            System.out.println("states:");
            input.listOfStates.forEach(state -> System.out.println(state));
        }

        catch (IOException e){
            e.printStackTrace();
        }

        //Product productSnack = createProduct();
        //Coupon couponDiskon = createCoupon();
        //Shipment shipment = createShipment();
        //System.out.println(productSnack.id);
        //System.out.println(productSnack.name);
        //System.out.println(productSnack.weight);
        //System.out.println(productSnack.conditionUsed);
        //System.out.println(productSnack.priceTag.price);
        //System.out.println(productSnack.category);
        //System.out.println(productSnack.rating.getCount());
        //System.out.println(productSnack.rating.getTotal());
        //System.out.println(couponDiskon.name);
        //System.out.println(couponDiskon.code);
        //System.out.println(couponDiskon.type);
        //System.out.println(couponDiskon.cut);
        //System.out.println(couponDiskon.minimum);
        //System.out.println(couponDiskon.isUsed());
     
    }
    
    //public Jmart(){
        
    //}
    
    //public static Product createProduct(){
    //    Product productSnack = new Product(1,1,"Chiki", 500, false, new PriceTag(30000), ProductCategory.FNB);
    //  return productSnack;
    //}
    
    //public static Coupon createCoupon(){
    //    return new Coupon(1,"Discount 10%", 1, Coupon.Type.DISCOUNT, 15, 3000);
    //}
    
    //public static Shipment createShipment(){
    //    return new Shipment(Duration.INSTANT, Duration.SAME_DAY);
    //}

}
