package com.LazaruslieJmartKD;


/**
 * Treasury
 *
 * @author (Lazaruslie Karsono)
 * 
 */
public class Treasury
{
    public static double COMMISSION_MULTIPLIER = 0.05;
    public static double BOTTOM_PRICE = 20000.0;
    public static double BOTTOM_FEE = 1000.0;
    public double price;
    public double discount;
    
    public Treasury(double price){
        this.price = price;
        this.discount = 0.0;
    }
    
    public Treasury(double price, double discount){
        this.price = price;
        this.discount = discount;
    }
    
    public double getAdjustedPrice(){
        return getDiscountedPrice() + getAdminFee();
    }
    
    public double getAdminFee(){
        if (getDiscountedPrice() < BOTTOM_PRICE){
            return BOTTOM_FEE;
        }
        else{
            return getDiscountedPrice() * COMMISSION_MULTIPLIER;
        }
    }
    
    public double getDiscountedPrice(){
        if (discount > 100.0) {
            return 100.0;
        }
        if (discount == 100.0) {
            return 0.0;
        }
        else{
            return ((100.0 - discount)/100.0) * price;
        }
    }
}
