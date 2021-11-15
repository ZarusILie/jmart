package LazaruslieJmartKD;
import java.util.Date;
import java.util.ArrayList;

/**
 * class Payment.
 *
 * @author (Lazaruslie Karsono)
 * 
 */
public class Payment extends Invoice {
    public ArrayList<Record> history;
    public int productCount;
    public Shipment shipment;

    public Payment(int id, int buyerId, int productId, int productCount, Shipment shipment) {
        super(buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;
    }

    public boolean read(String content){
        return false;
    }
    
    @Override
    public String toString(){
        return null;
    }
    

    public double getTotalPay(){
        return 0.0;
    }

    public class Record {
        public final Date date;
        public String message;
        public Status status;

        public Record(Status status, String message) {
            this.date = java.util.Calendar.getInstance().getTime();
            this.status = status;
            this.message = message;
        }
    }

}
