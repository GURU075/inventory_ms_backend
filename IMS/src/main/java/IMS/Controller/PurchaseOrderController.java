package IMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import IMS.Master.PurchaseOrderMaster;
import IMS.Service.PurchaseOrderService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/PurchaseOrder")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @PostMapping("/addPurchaseOrder")
    public ResponseEntity<String> addPurchaseOrder(@RequestBody @Valid PurchaseOrderMaster purchaseOrder) {
        Boolean isAdded = purchaseOrderService.addPurchaseOrder(purchaseOrder);
        if (isAdded) {
            return new ResponseEntity<>("Purchase Order added successfully!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add Purchase Order.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updatePurchaseOrder/{poId}")
    public ResponseEntity<String> updatePurchaseOrder(
            @PathVariable("poId") @Positive(message = "Purchase Order ID must be positive") Integer poId,
            @RequestBody @Valid PurchaseOrderMaster purchaseOrder) {
        purchaseOrder.setPoId(poId);
        Boolean isUpdated = purchaseOrderService.updatePurchaseOrder(purchaseOrder);
        if (isUpdated) {
            return new ResponseEntity<>("Purchase Order updated successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update Purchase Order.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deletePurchaseOrder/{poId}")
    public ResponseEntity<String> deletePurchaseOrder(@PathVariable("poId") @Positive(message = "Purchase Order ID must be positive") Integer poId) {
        PurchaseOrderMaster purchaseOrder = purchaseOrderService.getPurchaseOrder(poId);
        if (purchaseOrder != null) {
            Boolean isDeleted = purchaseOrderService.deletePurchaseOrder(purchaseOrder);
            if (isDeleted) {
                return new ResponseEntity<>("Purchase Order deleted successfully!", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Failed to delete Purchase Order.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getPurchaseOrder/{poId}")
    public ResponseEntity<PurchaseOrderMaster> getPurchaseOrder(@PathVariable("poId") @Positive(message = "Purchase Order ID must be positive") Integer poId) {
        PurchaseOrderMaster purchaseOrder = purchaseOrderService.getPurchaseOrder(poId);
        if (purchaseOrder != null) {
            return new ResponseEntity<>(purchaseOrder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllPurchaseOrders")
    public ResponseEntity<List<PurchaseOrderMaster>> getAllPurchaseOrders() {
        List<PurchaseOrderMaster> allPurchaseOrders = purchaseOrderService.getAllPurchaseOrders();
        return new ResponseEntity<>(allPurchaseOrders, HttpStatus.OK);
    }
}
