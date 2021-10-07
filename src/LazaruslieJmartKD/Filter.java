package LazaruslieJmartKD;
import java.util.ArrayList;

/**
 * class Filter
 *
 * @author (Lazaruslie Karsono)
 * 
 */
public class Filter
{
    private Filter()
    {
        
    }

    
    public static ArrayList<PriceTag> filterPriceTag(PriceTag[] list, int value, boolean less)
    {
        ArrayList<PriceTag> priceTag = new ArrayList<>();
        for (PriceTag f : list){
            if (!less && f.getAdjustedPrice() >= value || less && f.getAdjustedPrice() < value)
            priceTag.add(f);
        }
        return priceTag;
    }
    
    public static void filterProductRating(ArrayList<ProductRating> list, double value, boolean less){
        for(int i = 0; i < list.size(); ++i){
            final ProductRating f = list.get(i);
            if(!less && f.getAverage() >= value || less && f.getAverage() < value)
            list.remove(i);
        }
    }
}
