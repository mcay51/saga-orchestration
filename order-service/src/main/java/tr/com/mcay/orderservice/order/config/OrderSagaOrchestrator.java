package tr.com.mcay.orderservice.order.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import tr.com.mcay.orderservice.order.entity.Order;

@Component
public class OrderSagaOrchestrator {

    private RestTemplate restTemplate;

    @Autowired
    public OrderSagaOrchestrator(RestTemplate restTemplate){
        this.restTemplate=restTemplate;

    }

    private static final String INVENTORY_SERVICE_URL = "http://inventory-service/check";
    private static final String PAYMENT_SERVICE_URL = "http://payment-service/process";
    private static final String SHIPPING_SERVICE_URL = "http://shipping-service/ship";
    private static final String INVENTORY_ROLLBACK_URL = "http://inventory-service/rollback";
    private static final String PAYMENT_ROLLBACK_URL = "http://payment-service/cancel";

    public void startOrderSaga(Order order) {
        try {
            Boolean inventoryConfirmed = restTemplate.postForObject(INVENTORY_SERVICE_URL, order, Boolean.class);
            if (inventoryConfirmed == null || !inventoryConfirmed) {
                throw new RuntimeException("Stok yetersiz! Saga geri alınacak.");
            }
            System.out.println("Stok kontrolü başarılı.");

            Boolean paymentConfirmed = restTemplate.postForObject(PAYMENT_SERVICE_URL, order, Boolean.class);
            if (paymentConfirmed == null || !paymentConfirmed) {
                throw new RuntimeException("Ödeme başarısız! Saga geri alınacak.");
            }
            System.out.println("Ödeme işlemi başarılı.");

            restTemplate.postForObject(SHIPPING_SERVICE_URL, order, Void.class);
            System.out.println("Sipariş gönderildi.");

            order.setStatus("COMPLETED");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            compensate(order);
        }
    }

    private void compensate(Order order) {
        System.out.println("Saga geri alınıyor...");
        restTemplate.postForObject(INVENTORY_ROLLBACK_URL, order, Void.class);
        restTemplate.postForObject(PAYMENT_ROLLBACK_URL, order, Void.class);
        order.setStatus("CANCELED");
        System.out.println("Saga geri alındı.");
    }
}
