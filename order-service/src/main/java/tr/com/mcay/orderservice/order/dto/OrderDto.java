package tr.com.mcay.orderservice.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
@Getter
@Setter
public class OrderDto implements Serializable {
    @Serial
    private static final long serialVersionUID= -8881993008078004478L;

    private Long id;
    private String productId;
    private int quantity;
    private String status; // CREATED, COMPLETED, CANCELED
}
