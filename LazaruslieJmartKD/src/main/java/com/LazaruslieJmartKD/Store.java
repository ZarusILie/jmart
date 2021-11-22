package com.LazaruslieJmartKD;
import com.LazaruslieJmartKD.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * class Store
 *
 * @author (Lazaruslie Karsono)
 * 
 */
public class Store
{
    public String name;
    public double balance;
    public String address;
    public String phoneNumber;
    public static final String REGEX_PHONE = "^\\d{9,12}$";
    public static final String REGEX_NAME = "^[A-Z](?!.*(\\s)\1).{4,20}$";
    
    public Store(String name, String address, String phoneNumber, double balance) {
        this.name = name;
        this.balance = balance;
        this.address = address;
        this.phoneNumber = phoneNumber;
     }
     
     public boolean validate() {
         Pattern pattern_name = Pattern.compile(REGEX_NAME);
         Matcher matcher_name = pattern_name.matcher(name);
         Pattern pattern_phone = Pattern.compile(REGEX_PHONE);
         Matcher matcher_phone = pattern_phone.matcher(phoneNumber);
         if(matcher_phone.find() && matcher_name.find()) {
             return true;
         }
         else {
             return false;
         }
     }

    @Override
    public String toString() {
        return ("name:" + name + "\naddress:" + address + "\nphoneNumber:" + phoneNumber);
    }
    
}
