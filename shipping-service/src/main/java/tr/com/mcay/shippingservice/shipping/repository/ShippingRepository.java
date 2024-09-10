package tr.com.mcay.shippingservice.shipping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.mcay.shippingservice.shipping.entity.Shipping;

public interface ShippingRepository extends JpaRepository<Shipping, Long> {
}
