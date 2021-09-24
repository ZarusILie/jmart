package LazaruslieJmartKD;


/**
 * Product
 *
 * @author (Lazaruslie Karsono)
 * 
 */
public class Product
{
    private int idCounter = 0;
    public int id;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    
    public Product(String name,int weight, boolean conditionUsed, PriceTag pricetag,ProductCategory category)
    {
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = pricetag;
        this.category = category;
        this.rating = new ProductRating();
        this.id = idCounter;
        idCounter++;
    }
}
