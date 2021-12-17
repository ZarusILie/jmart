package com.LazaruslieJmartKD.controller;
import com.LazaruslieJmartKD.Algorithm;
import com.LazaruslieJmartKD.dbjson.JsonTable;
import com.LazaruslieJmartKD.dbjson.Serializable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * interface BasicGetController
 *
 * @author (Lazaruslie Karsono)
 */

public interface BasicGetController<T extends Serializable> {

    @GetMapping("/page")
    default List<T> getPage(@RequestParam(defaultValue="1") int page, @RequestParam(defaultValue="5") int pageSize) {
        return Algorithm.<T> paginate(getJsonTable(), page, pageSize, e -> true);
    }

    @GetMapping("/{id}")
    default T getById(@PathVariable int id) {
        return Algorithm.<T> find(getJsonTable(), (e) -> e.id == id);
    }

    JsonTable<T> getJsonTable();

}

