package tr.com.mcay.orderservice.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.com.mcay.orderservice.order.config.OrderSagaOrchestrator;
import tr.com.mcay.orderservice.order.entity.Order;

@RestController
@RequestMapping("/orders")
public class OrderController {


    private OrderSagaOrchestrator orchestrator;

    @Autowired
    public OrderController(OrderSagaOrchestrator orchestrator){
        this.orchestrator=orchestrator;
    }

    @PostMapping
    public void createOrder(@RequestBody Order order) {
        orchestrator.startOrderSaga(order);
    }
}
