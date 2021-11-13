package LazaruslieJmartKD;


/**
 * class Payment.
 *
 * @author (Lazaruslie Karsono)
 * 
 */
public class Payment extends Invoice
{
    public int productCount;
    public Shipment shipment;

    public Payment(int id, int buyerId, int productId, int productCount, Shipment shipment)
    {
        super(buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;
    }
    
    @Override
    public boolean read(String content){
        return false;
    }
    
    @Override
    public String toString(){
        return null;
    }
    
    @Override
    public double getTotalPay(){
        return 0.0;
    }
}
