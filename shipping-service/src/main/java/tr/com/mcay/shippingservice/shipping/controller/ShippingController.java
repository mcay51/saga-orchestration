package tr.com.mcay.shippingservice.shipping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.com.mcay.orderservice.order.dto.OrderDto;
import tr.com.mcay.shippingservice.shipping.entity.Shipping;
import tr.com.mcay.shippingservice.shipping.repository.ShippingRepository;

@RestController
@RequestMapping("/shipping")
public class ShippingController {


    private ShippingRepository shippingRepository;
    @Autowired
    public ShippingController(ShippingRepository shippingRepository) {
        this.shippingRepository = shippingRepository;
    }

    @PostMapping("/ship")
    public void shipOrder(@RequestBody OrderDto order) {
        // Teslimat işlemi yapılır
        Shipping shipping = new Shipping();
        shipping.setOrderId(order.getId());
        shipping.setStatus("SHIPPED");
        shippingRepository.save(shipping);
    }
}
