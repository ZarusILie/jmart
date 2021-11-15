package LazaruslieJmartKD;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.util.stream.Collectors;

/**
 * Jmart
 *
 * @author (Lazaruslie Karsono)
 */
class Jmart {

    public static List<Product> filterByAccountId(List<Product> list, int accountId, int page, int pageSize) {
        Predicate<Product> predicate = predi -> (predi.accountId == accountId);
        return paginate(list, page, pageSize, predicate);
    }

    public static List<Product> filterByCategory(List<Product> list, ProductCategory category) {
        List<Product> prod = new ArrayList<>();
        for(Product product : list){
            if(product.category.equals(category)) {
                prod.add(product);
            }
        }
        return prod;
    }

    public static List<Product> filterByName(List<Product> list, String search, int page, int pageSize) {
        Predicate<Product> predicate = predi -> (predi.name.toLowerCase().contains(search.toLowerCase()));
        return paginate(list, page, pageSize, predicate);
    }

    public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice) {
        List<Product> prod = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            if(minPrice <= 0.0) {
                if(list.get(i).price <= maxPrice) {
                    prod.add(list.get(i));
                }
            } else if(maxPrice <= 0.0) {
                if(list.get(i).price >= minPrice) {
                    prod.add(list.get(i));
                }
            } else {
                if(list.get(i).price >= minPrice && list.get(i).price <= maxPrice){
                    prod.add(list.get(i));
                }
            }
        }
        return prod;
    }

    public static void main(String[] args) {

        try {
            List<Product> list = read("D:/OOP/jmart/lib/randomProductList.json");
            List<Product> filtered = filterByPrice(list, 0.0, 20000.0);
            filtered.forEach(product -> System.out.println(product.price));
        }
        catch (Throwable t) {
            t.printStackTrace();
            }
        }

    private static List<Product> paginate(List<Product> list, int page, int pageSize, Predicate<Product> pred) {
        return list.stream().filter(predi -> pred.predicate(predi)).skip(page * pageSize).limit(pageSize).collect(Collectors.toList());
    }

    public static List<Product> read(String filepath) throws FileNotFoundException {
        List<Product> prod = new ArrayList<>();
        try {
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(filepath));
            reader.beginArray();
            while(reader.hasNext()) {
                prod.add(gson.fromJson(reader, Product.class));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return prod;
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


