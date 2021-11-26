package com.LazaruslieJmartKD.controller;
import com.LazaruslieJmartKD.*;
import com.LazaruslieJmartKD.dbjson.JsonAutowired;
import com.LazaruslieJmartKD.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {

    public static final long DELIVERED_LIMIT_MS = 100;
    public static final long ON_DELIVERY_LIMIT_MS = 100;
    public static final long ON_PROGRESS_LIMIT_MS = 100;
    public static final long WAITING_CONF_LIMIT_MS = 100;
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
        if (payment.history.isEmpty()) {
            return false;
        } else {
            Payment.Record record = payment.history.get(payment.history.size() - 1);
            long elapsed = System.currentTimeMillis() - record.date.getTime();
            if (record.status.equals(Invoice.Status.WAITING_CONFIRMATION) && (elapsed > WAITING_CONF_LIMIT_MS)) {
                record.status = Invoice.Status.FAILED;
                return true;
            } else if (record.status.equals(Invoice.Status.ON_PROGRESS) && (elapsed > ON_PROGRESS_LIMIT_MS)) {
                record.status = Invoice.Status.FAILED;
                return true;
            } else if (record.status.equals(Invoice.Status.ON_DELIVERY) && (elapsed > ON_PROGRESS_LIMIT_MS)) {
                record.status = Invoice.Status.DELIVERED;
                return true;
            } else if (record.status.equals(Invoice.Status.DELIVERED) && (elapsed > DELIVERED_LIMIT_MS)) {
                record.status = Invoice.Status.FINISHED;
                return true;
            } else {
                return false;
            }
        }
    }

    @PostMapping("/{id}/accept")
    boolean accept
        (
            @PathVariable int id
        ) {
        for(Payment pay : paymentTable) {
            if(pay.id == id) {
                if(pay.history.get(pay.history.size() -1).status == Invoice.Status.WAITING_CONFIRMATION) {
                    pay.history.add(new Payment.Record(Invoice.Status.ON_PROGRESS, "ON_PROGRESS"));
                    return true;
                }
            }
        }
        return false;
    }

    @PostMapping("/{id}/cancel")
    public boolean cancel (@PathVariable int id) {
        for(Payment pay : paymentTable) {
            if(pay.id == id) {
                if(pay.history.get(pay.history.size() - 1).status == Invoice.Status.WAITING_CONFIRMATION) {
                    pay.history.add(new Payment.Record(Invoice.Status.CANCELLED, "CANCELLED"));
                    return true;
                }
            }
        }
        return false;
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
        for(Account acc : AccountController.accountTable) {
            if(acc.id == buyerId) {
                for(Product prod : ProductController.productTable) {
                    if(prod.accountId == productId) {
                        Payment payment = new Payment(buyerId, productId, productCount, new Shipment(shipmentAddress, 0, shipmentPlan, null));
                        double totalPayment = payment.getTotalPay(prod);
                        if(acc.balance >= totalPayment) {
                            acc.balance -= totalPayment;
                            payment.history.add(new Payment.Record(Invoice.Status.WAITING_CONFIRMATION, "WAITING_CONFIRMATION"));
                            paymentTable.add(payment);
                            poolThread.add(payment);
                            return payment;
                        }
                    }
                }
            }
        }
        return null;
    }

    @PostMapping("/{id}/submit")
    public boolean submit
            (
                    @PathVariable int id,
                    @RequestParam String receipt
            )
    {
        for(Payment pay : paymentTable) {
            if(pay.id == id) {
                if(pay.history.get(pay.history.size() - 1).status == Invoice.Status.ON_PROGRESS) {
                    if(!receipt.isBlank()) {
                        pay.shipment.receipt = receipt;
                        pay.history.add(new Payment.Record(Invoice.Status.ON_DELIVERY, "ON_DELIVERY"));
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
