package tr.com.mcay.paymentservice.payment.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.com.mcay.orderservice.entity.order.dto.OrderDto;
import tr.com.mcay.paymentservice.payment.entity.Payment;
import tr.com.mcay.paymentservice.payment.repository.PaymentRepository;

@RestController
@RequestMapping("/payment")
public class PaymentController {


    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @PostMapping("/process")
    public Boolean processPayment(@RequestBody OrderDto order) {
        // Ödeme işlemi yapılır
        Payment payment = new Payment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getQuantity() * 100); // Ödeme miktarı
        payment.setStatus("SUCCESS");
        paymentRepository.save(payment);
        return true;
    }

    @PostMapping("/cancel")
    public void cancelPayment(@RequestBody OrderDto order) {
        // Ödeme iptali yapılır
        Payment payment = paymentRepository.findByOrderId(order.getId());
        if (payment != null) {
            payment.setStatus("CANCELED");
            paymentRepository.save(payment);
        }
    }
}

