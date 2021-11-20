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
public class Store extends Serializable
{
    public String name;
    public double balance;
    public String address;
    public String phoneNumber;
    public static final String REGEX_PHONE = "^\\d{9,12}$";
    public static final String REGEX_NAME = "^[A-Z](?!.*(\\s)\1).{4,20}$";
    
    public Store(String name, String address, String phoneNumber, double balance){
        this.name = name;
        this.balance = balance;
        this.address = address;
        this.phoneNumber = phoneNumber;
        
     }
     
     public Store(Account account, String name, String address, String phoneNumber){

         this.name = name;
         this.address = address;
         this.phoneNumber = phoneNumber;
     }
     
     public boolean validate(){
         Pattern pattern = Pattern.compile(REGEX_NAME);
         Matcher matcher = pattern.matcher(name);
         Pattern pattern_phone = Pattern.compile(REGEX_PHONE);
         Matcher matcher_phone = pattern_phone.matcher(phoneNumber);
         return matcher.find() && matcher_phone.find();
     }
     

     public boolean read(String content){
         return false;
    }

    public String toString(){
        return ("name:" + name + "\naddress:" + address + "\nphoneNumber:" + phoneNumber);
    }
    
}
