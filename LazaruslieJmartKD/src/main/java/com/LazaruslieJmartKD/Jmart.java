package com.LazaruslieJmartKD;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;

import com.LazaruslieJmartKD.dbjson.JsonDBEngine;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.util.stream.Collectors;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Jmart
 *
 * @author (Lazaruslie Karsono)
 */

@SpringBootApplication
class Jmart {
    /*
    public static long DELIVERED_LIMIT_MS;
    public static long ON_DELIVERY_LIMIT_MS;
    public static long ON_PROGRESS_LIMIT_MS;
    public static long WAITING_CONF_LIMIT_MS;


    public static List<Product> filterByAccountId(List<Product> list, int accountId, int page, int pageSize) {
        Predicate<Product> predicate = predi -> (predi.accountId == accountId);
        return paginate(list, page, pageSize, predicate);
    }

    public static List<Product> filterByCategory(List<Product> list, ProductCategory category) {
        List<Product> prod = new ArrayList<>();
        for(Product product : list){
            if(product.category.equals(category)) {
                prod.add(product);
            }
        }
        return prod;
    }

    public static List<Product> filterByName(List<Product> list, String search, int page, int pageSize) {
        Predicate<Product> predicate = predi -> (predi.name.toLowerCase().contains(search.toLowerCase()));
        return paginate(list, page, pageSize, predicate);
    }

    public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice) {
        List<Product> prod = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            if(minPrice <= 0.0) {
                if(list.get(i).price <= maxPrice) {
                    prod.add(list.get(i));
                }
            } else if(maxPrice <= 0.0) {
                if(list.get(i).price >= minPrice) {
                    prod.add(list.get(i));
                }
            } else {
                if(list.get(i).price >= minPrice && list.get(i).price <= maxPrice){
                    prod.add(list.get(i));
                }
            }
        }
        return prod;
    }

    private static List<Product> paginate(List<Product> list, int page, int pageSize, Predicate<Product> pred) {
        return list.stream().filter(predi -> pred.predicate(predi)).skip(page * pageSize).limit(pageSize).collect(Collectors.toList());
    }

    public static List<Product> read(String filepath) throws FileNotFoundException {
        List<Product> prod = new ArrayList<>();
        try {
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(filepath));
            reader.beginArray();
            while(reader.hasNext()) {
                prod.add(gson.fromJson(reader, Product.class));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return prod;
    }

     */


    public static void main(String[] args) {

        try {
            JsonDBEngine.Run(Jmart.class);
            SpringApplication.run(Jmart.class, args);
            Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
            /*
            JsonTable<Payment> table = new JsonTable<>(Payment.class, "randomPaymentList.json");
            ObjectPoolThread<Payment> paymentPool = new ObjectPoolThread<Payment>("Thread-PP", Jmart::paymentTimekeeper);
            paymentPool.start();
            table.forEach(payment -> paymentPool.add(payment));
            while (paymentPool.size() != 0);
            paymentPool.exit();
            while (paymentPool.isAlive());
            System.out.println("Thread exited successfully");
            Gson gson = new Gson();
            table.forEach(payment -> {
                String history = gson.toJson(payment.history);
                System.out.println(history);

        } );

             */
        }

        catch (Exception e){
            System.out.println(e);
        }

        catch (Throwable t){
            t.printStackTrace();
        }

    }

    /*
    public static boolean paymentTimekeeper(Payment payment) {
        Payment.Record record = payment.history.get(payment.history.size() - 1);
        long elaps = System.currentTimeMillis() - record.date.getTime();
        if (record.status.equals(Invoice.Status.WAITING_CONFIRMATION) && (elaps > WAITING_CONF_LIMIT_MS)){
            record.status = Invoice.Status.FAILED;
            return true;
        }

        else if (record.status.equals(Invoice.Status.ON_PROGRESS) && (elaps > ON_PROGRESS_LIMIT_MS)){
            record.status = Invoice.Status.FAILED;
            return true;
        }

        else if (record.status.equals(Invoice.Status.ON_DELIVERY) && (elaps > ON_PROGRESS_LIMIT_MS)){
            record.status = Invoice.Status.DELIVERED;
            return true;
        }

        else if (record.status.equals(Invoice.Status.DELIVERED) && (elaps > DELIVERED_LIMIT_MS)){
            record.status = Invoice.Status.FINISHED;
            return true;
        }

        else{
            return false;
        }
    }

     */

}



