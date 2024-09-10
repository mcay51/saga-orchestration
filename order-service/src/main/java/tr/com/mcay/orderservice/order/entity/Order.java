package tr.com.mcay.orderservice.order.entity;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "orders")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    private int quantity;
    private String status; // CREATED, COMPLETED, CANCELED
}

