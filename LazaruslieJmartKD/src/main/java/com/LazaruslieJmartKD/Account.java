package com.LazaruslieJmartKD;
import com.LazaruslieJmartKD.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * class Account
 *
 * @author (Lazaruslie Karsono)
 */
public class Account extends Serializable
{
    public String name;
    public String email;
    public String password;
    public double balance;
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9&~]+(?:\\.[a-zA-Z0-9&_~]+)@[A-Za-z0-9]{1}[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9-]+)$";
    public static final String REGEX_PASSWORD = "^(?=.[a-z])(?=.[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    public Store store;

    public Account(String name, String email, String password, double balance)
    {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }
    
    public boolean validate(){
        Pattern email_Pattern = Pattern.compile(REGEX_EMAIL);
        Matcher email_Matcher = email_Pattern.matcher(this.email);
        Pattern password_Pattern = Pattern.compile(REGEX_PASSWORD);
        Matcher password_Matcher = password_Pattern.matcher(this.password);
        if (email_Matcher.find() && password_Matcher.find()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return
                "name : " + this.name + "\n" + "email: " + this.email + "\n" + "password: " + this.password + "\n" + "balance: " + this.balance;
    }
}
