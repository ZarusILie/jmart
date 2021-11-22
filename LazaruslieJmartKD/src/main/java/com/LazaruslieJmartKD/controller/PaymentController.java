package com.LazaruslieJmartKD.controller;
import com.LazaruslieJmartKD.ObjectPoolThread;
import com.LazaruslieJmartKD.Payment;
import com.LazaruslieJmartKD.dbjson.JsonAutowired;
import com.LazaruslieJmartKD.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {

    public static final long DELIVERED_LIMIT_MS = 5;
    public static final long ON_DELIVERY_LIMIT_MS = 5;
    public static final long ON_PROGRESS_LIMIT_MS = 5;
    public static final long WAITING_CONF_LIMIT_MS = 5;
    public static ObjectPoolThread<Payment> poolThread;
    public static @JsonAutowired(value= Payment.class, filepath="src/main") JsonTable<Payment> paymentTable;

    static
    {
        poolThread = new ObjectPoolThread<Payment>("Thread", PaymentController::timeKeeper);
        poolThread.start();
    }

    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    private static Boolean timeKeeper(Payment payment) {
        return false;
    }

    @PostMapping("/{id}/accept")
    boolean accept (@PathVariable int id) {
        return true;
    }

    @PostMapping("/{id}/cancel")
    public boolean cancel (@PathVariable int id) {
        return true;
    }

    @PostMapping("/create")
    public Payment create
            (
                    @RequestParam int buyerId,
                    @RequestParam int productId,
                    @RequestParam int productCount,
                    @RequestParam String shipmentAddress,
                    @RequestParam byte shipmentPlan
            )
    {
        return null;
    }

    @PostMapping("/{id}/submit")
    public boolean submit
            (
                    @PathVariable int id,
                    @RequestParam String receipt
            )
    {
        return true;
    }
}
