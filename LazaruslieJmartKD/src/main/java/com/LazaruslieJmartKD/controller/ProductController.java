package com.LazaruslieJmartKD.controller;
import com.LazaruslieJmartKD.*;
import com.LazaruslieJmartKD.dbjson.JsonAutowired;
import com.LazaruslieJmartKD.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController<Product> {
    public static @JsonAutowired(value = Product.class, filepath = "src/main") JsonTable<Product> productTable;

    public JsonTable<Product> getJsonTable() {
        return productTable;
    }


    @PostMapping("/create")
    Product create
            (
                    @RequestParam int accountId,
                    @RequestParam String name,
                    @RequestParam int weight,
                    @RequestParam boolean conditionUsed,
                    @RequestParam double price,
                    @RequestParam double discount,
                    @RequestParam ProductCategory category,
                    @RequestParam byte shipmentPlans
                    )
    {
        for(Account account : AccountController.accountTable) {
            if(account.id == accountId && account.store != null) {
                Product prod = new Product(accountId, name, weight, conditionUsed, price, discount, category, shipmentPlans);
                productTable.add(prod);
                return prod;
            }
        }
        return null;
    }

    @PostMapping("/{id}/store")
    List<Product> getProductByStore
            (
                    @RequestParam int id,
                    @RequestParam int page,
                    @RequestParam int pageSize
            )
    {
        return Algorithm.<Product> paginate(getJsonTable(), page, pageSize, x -> (x.accountId == id));
    }

    @PostMapping("/{id}/getFiltered")
    List<Product> getProductFiltered
            (
                  @RequestParam(defaultValue = "0") int page,
                  @RequestParam(defaultValue = "10") int pageSize,
                  @RequestParam int minPrice,
                  @RequestParam int maxPrice,
                  @RequestParam ProductCategory category
            )
    {
        return null;
    }
}
