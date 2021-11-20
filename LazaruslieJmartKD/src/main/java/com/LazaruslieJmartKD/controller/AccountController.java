package com.LazaruslieJmartKD.controller;
import com.LazaruslieJmartKD.Account;
import com.LazaruslieJmartKD.Store;
import com.LazaruslieJmartKD.dbjson.JsonAutowired;
import com.LazaruslieJmartKD.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

@RestController
@RequestMapping("/account")

public class AccountController implements BasicGetController<Account> {

    public static final String REGEX_EMAIL = "^\\w+([\\.&_*~]?\\w+)*@\\w+([\\.\\-]?\\w+)*(\\.\\w{2,3})+$";
    public static final String REGEX_PASSWORD = "^(?=.[a-z])(?=.[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_EMAIL);
    public static @JsonAutowired(value=Account.class, filepath="src/main") JsonTable<Account> accountTable;

    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }

    @GetMapping
    String index() { return "account page"; }


    @PostMapping("/login")
    Account login
            (
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        for(Account account : accountTable) {
            if(account.email.equals(email) && account.password.equals(password)) {
                return account;
            }
        }
        return null;
    }

    @PostMapping("/register")
    Account register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        if((REGEX_PATTERN_EMAIL.matcher(email).find()) && (REGEX_PATTERN_PASSWORD.matcher(password).find()) && !name.isBlank()) {
            for(Account account : accountTable){
                if(account.email.equals(email)){
                    return null;
                }
            }
            return new Account(name, email, password, 0);
        }
        return null;
    }
    /*
    @PostMapping("/{id}/registerStore")
    Store registerStore(int id, double balance, String name, String address, String phoneNumber) {
        if(accountTable.contains(accountTable.get(id)) && accountTable.get(id).store == null) {
            Store newStore = new Store(name, address, phoneNumber, 0);
            accountTable.get(id).store = newStore;
            return newStore;
        }
        else{
            return null;
        }
    }

     */

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
