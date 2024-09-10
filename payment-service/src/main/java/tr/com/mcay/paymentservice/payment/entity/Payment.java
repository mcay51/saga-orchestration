package tr.com.mcay.paymentservice.payment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderId;
    private double amount;
    private String status; // PENDING, SUCCESS, FAILED
}
