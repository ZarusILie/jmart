package LazaruslieJmartKD;


/**
 * Product
 *
 * @author (Lazaruslie Karsono)
 * 
 */
public class Product extends Serializable
{
    public int accountId;
    public ProductCategory category;
    public boolean conditionUsed;
    public double discount;
    public String name;
    public double price;
    public byte shipmentPlans;
    public int weight;
    
    public Product (int id, int storeId, String name,int weight, boolean conditionUsed, PriceTag pricetag,ProductCategory category, Shipment.MultiDuration multiDuration)
    {

        this.accountId = accountId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.price = price;
        this.discount = discount;
        this.category = category;
        this.shipmentPlans = shipmentPlans;
    }
    
    public boolean read(String content){
        return false;
    }
    
    @Override
    public String toString(){
        return ("Name: " + name + "\nWeight:" + weight + "\nconditionUsed:" + conditionUsed +
        "\nprice" + price + "\ncategory" + category + "\ndiscount:" + discount + "\naccountId: " + accountId);
    }
}
