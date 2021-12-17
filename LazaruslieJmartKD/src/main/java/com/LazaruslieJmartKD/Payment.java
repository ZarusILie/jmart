package com.LazaruslieJmartKD;
import java.util.Date;
import java.util.ArrayList;

/**
 * class Payment.
 *
 * @author (Lazaruslie Karsono)
 * 
 */

public class Payment extends Invoice {
    public ArrayList<Record> history = new ArrayList<>();
    public int productCount;
    public Shipment shipment;

    public static class Record {
        public final Date date;
        public String message;
        public Status status;

        public Record(Status status, String message) {
            date = new Date();
            this.status = status;
            this.message = message;
        }
    }

    public Payment(int buyerId, int productId, int productCount, Shipment shipment) {
        super(buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;
    }

    @Override
    public double getTotalPay(Product product){
        return (productCount * Treasury.getAdjustedPrice(product.price, product.discount));
    }


}
