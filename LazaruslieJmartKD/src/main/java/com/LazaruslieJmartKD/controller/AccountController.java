package com.LazaruslieJmartKD.controller;
import com.LazaruslieJmartKD.Account;
import com.LazaruslieJmartKD.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

@RestController
@RequestMapping("/account")

public class AccountController {

    /*
    public static final String REGEX_EMAIL = "^\\w+([\\.&_*~]?\\w+)*@\\w+([\\.\\-]?\\w+)*(\\.\\w{2,3})+$";
    public static final String REGEX_PASSWORD = "";
    public static final Pattern REGEX_PATTERN_EMAIL = ;
    public static final Pattern REGEX_PATTERN_PASSWORD = ;
    public static JsonTable<Account> accountTable;

    public JsonTable<Account> getJsonTable() {

    }

     */

    @GetMapping
    String index() { return "account page"; }

    /*
    @PostMapping("/login")
    Account login
            (
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        return new Account(email, password);
    }

     */

    @PostMapping("/register")
    Account register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        return new Account(name, email, password, 0);
    }

    @GetMapping("/{id}")
    String getById(@PathVariable int id) {
        return "account id " + id + " not found!";
    }
}
