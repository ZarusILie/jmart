package LazaruslieJmartKD;


/**
 * Product
 *
 * @author (Lazaruslie Karsono)
 * 
 */
public class Product extends Recognizable
{
    public int storeId;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    public Shipment.MultiDuration multiDuration;
    
    public Product (int id, int storeId, String name,int weight, boolean conditionUsed, PriceTag pricetag,ProductCategory category, Shipment.MultiDuration multiDuration)
    {
        super(id);
        this.storeId = storeId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = pricetag;
        this.category = category;
        this.rating = new ProductRating();
        this.multiDuration = multiDuration;
    }
    
    public boolean read(String content){
        return false;
    }
    
    @Override
    public String toString(){
        return ("Name: " + name + "\nWeight:" + weight + "\nconditionUsed:" + conditionUsed +
        "\npriceTag" + priceTag + "\ncategory" + category + "\nrating:" + rating + "\nstoreId: 1"); 
    }
}
