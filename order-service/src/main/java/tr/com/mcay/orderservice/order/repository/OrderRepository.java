package tr.com.mcay.orderservice.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.mcay.orderservice.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
