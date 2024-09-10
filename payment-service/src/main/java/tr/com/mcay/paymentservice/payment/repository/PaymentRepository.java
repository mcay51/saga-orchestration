package tr.com.mcay.paymentservice.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.mcay.paymentservice.payment.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment findByOrderId(Long id);
}
