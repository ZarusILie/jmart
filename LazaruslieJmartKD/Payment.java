package LazaruslieJmartKD;


/**
 * class Payment.
 *
 * @author (Lazaruslie Karsono)
 * 
 */
public class Payment extends Transaction implements FileParser
{
    public int productId;
    public ShipmentDuration shipmentDuration;

    public Payment(int id,int buyerId, Product product, ShipmentDuration shipmentDuration)
    {
        super(id, buyerId, product.storeId);
        this.productId = product.id;
        this.shipmentDuration = shipmentDuration;
    }
    
    public Payment(int id, int buyerId, int storeId, int productId, ShipmentDuration shipmentDutration){
        super(id, buyerId, storeId);
        this.productId = productId;
        this.shipmentDuration = shipmentDuration;
    }
    
    @Override
    public boolean validate(){
        return false;
    }
    
    public Transaction perform(){
        return null;
    }
    
    public boolean read(String content){
        return false;
    }
}
