package com.LazaruslieJmartKD.controller;
import com.LazaruslieJmartKD.Account;
import com.LazaruslieJmartKD.Algorithm;
import com.LazaruslieJmartKD.Store;
import com.LazaruslieJmartKD.dbjson.JsonAutowired;
import com.LazaruslieJmartKD.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.regex.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/account")

public class AccountController implements BasicGetController<Account> {

    public static final String REGEX_EMAIL = "^\\w+([\\.&_*~]?\\w+)*@\\w+([\\.\\-]?\\w+)*(\\.\\w{2,3})+$";
    public static final String REGEX_PASSWORD = "^(?=.[a-z])(?=.[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    public static @JsonAutowired(value = Account.class, filepath = "src/main") JsonTable<Account> accountTable;

    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }

    @GetMapping
    String index() {
        return "account page";
    }


    @PostMapping("/login")
    Account login
            (
                    @RequestParam String email,
                    @RequestParam String password
            ) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] digest = md.digest(password.getBytes());
        BigInteger num = new BigInteger(1, digest);
        String hashing = num.toString(16);
        while(hashing.length()<32) hashing = "0" + hashing;
        String resultHashing = hashing;

        return Algorithm.<Account> find(accountTable, object -> object.email.equals(email) &&
                object.password.equals(resultHashing));
    }

    @PostMapping("/register")
    Account register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            ) {
        if(name.isBlank())
            return null;
        Matcher emailMatch = REGEX_PATTERN_EMAIL.matcher(email);
        if(!emailMatch.find())
            return null;
        Matcher passwordMatch = REGEX_PATTERN_PASSWORD.matcher(password);
        if(!passwordMatch.find())
            return null;
        if(Algorithm.<Account> find(accountTable, object -> object.email.equals(email)) != null)
            return null;

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] digest = md.digest(password.getBytes());
        BigInteger num = new BigInteger(1, digest);
        String hashing = num.toString(16);
        while(hashing.length()<32) hashing = "0" + hashing;

        Account acc = new Account(name, email, hashing, 0);
        accountTable.add(acc);
        return acc;
    }


    @PostMapping("/{id}/registerStore")
    Store registerStore
        (
            @PathVariable int id,
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam String phoneNumber
        )
        {
            if(accountTable.contains(accountTable.get(id)) && accountTable.get(id).store == null) {
                Store st = new Store(name, address, phoneNumber, 0);
                accountTable.get(id).store = st;
                return st;
            }else{
                return null;
            }
    }
    
    @PostMapping("/{id}/topUp")
    boolean topUp(int id, double balance){
        if(accountTable.contains(accountTable.get(id))) {
            accountTable.get(id).balance += balance;
            return true;
        }
        else {
            return false;
        }

    }

    /*
    @GetMapping("/{id}")
    String getById(@PathVariable int id) {
        return "account id " + id + " not found!";
    }
     */
}
