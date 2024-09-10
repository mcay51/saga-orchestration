package tr.com.mcay.inventoryservice.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.com.mcay.inventoryservice.inventory.entity.Inventory;
import tr.com.mcay.inventoryservice.inventory.repository.InventoryRepository;
import tr.com.mcay.orderservice.order.dto.OrderDto;

@RestController
@RequestMapping("/inventory")
public class InventoryController {


    private InventoryRepository inventoryRepository;
    @Autowired
    public InventoryController(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @PostMapping("/check")
    public Boolean checkInventory(@RequestBody OrderDto order) {
        // Stok kontrolü
        return inventoryRepository.existsByProductIdAndQuantityGreaterThanEqual(order.getProductId(), order.getQuantity());
    }

    @PostMapping("/rollback")
    public void rollbackInventory(@RequestBody OrderDto order) {
        // Stok geri alımı
        Inventory inventory = inventoryRepository.findByProductId(order.getProductId());
        if (inventory != null) {
            inventory.setQuantity(inventory.getQuantity() + order.getQuantity());
            inventoryRepository.save(inventory);
        }
    }
}
