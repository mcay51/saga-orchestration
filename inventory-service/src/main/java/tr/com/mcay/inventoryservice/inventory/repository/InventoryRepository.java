package tr.com.mcay.inventoryservice.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.mcay.inventoryservice.inventory.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Boolean existsByProductIdAndQuantityGreaterThanEqual(String productId, int quantity);

    Inventory findByProductId(String productId);
}
