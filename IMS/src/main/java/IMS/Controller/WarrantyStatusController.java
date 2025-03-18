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

import IMS.Master.WarrantyStatusMaster;
import IMS.Service.WarrantyStatusService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/WarrantyStatus")
public class WarrantyStatusController {

    @Autowired
    private WarrantyStatusService warrantyStatusService;

    @PostMapping("/addWarrantyStatus")
    public ResponseEntity<String> addWarrantyStatus(@RequestBody @Valid WarrantyStatusMaster warrantyStatusMaster) {
        Boolean isAdded = warrantyStatusService.addWarrantyStatusService(warrantyStatusMaster);
        if (isAdded) {
            return new ResponseEntity<>("Warranty Status added successfully!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add Warranty Status.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateWarrantyStatus/{warrantyStatusId}")
    public ResponseEntity<String> updateWarrantyStatus(
            @PathVariable("warrantyStatusId") @Positive(message = "Warranty Status ID must be positive") Integer warrantyStatusId,
            @RequestBody @Valid WarrantyStatusMaster warrantyStatusMaster) {
        warrantyStatusMaster.setWarrantyStatusId(warrantyStatusId);
        Boolean isUpdated = warrantyStatusService.updateWarrantyStatusService(warrantyStatusMaster);
        if (isUpdated) {
            return new ResponseEntity<>("Warranty Status updated successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update Warranty Status.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteWarrantyStatus/{warrantyStatusId}")
    public ResponseEntity<String> deleteWarrantyStatus(@PathVariable("warrantyStatusId") @Positive(message = "Warranty Status ID must be positive") Integer warrantyStatusId) {
        WarrantyStatusMaster warrantyStatusMaster = warrantyStatusService.getWarrantyStatusService(warrantyStatusId);
        if (warrantyStatusMaster != null) {
            Boolean isDeleted = warrantyStatusService.deleteWarrantyStatusService(warrantyStatusMaster);
            if (isDeleted) {
                return new ResponseEntity<>("Warranty Status deleted successfully!", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Failed to delete Warranty Status.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getWarrantyStatus/{warrantyStatusId}")
    public ResponseEntity<WarrantyStatusMaster> getWarrantyStatus(@PathVariable("warrantyStatusId") @Positive(message = "Warranty Status ID must be positive") Integer warrantyStatusId) {
        WarrantyStatusMaster warrantyStatusMaster = warrantyStatusService.getWarrantyStatusService(warrantyStatusId);
        if (warrantyStatusMaster != null) {
            return new ResponseEntity<>(warrantyStatusMaster, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllWarrantyStatuses")
    public ResponseEntity<List<WarrantyStatusMaster>> getAllWarrantyStatuses() {
        List<WarrantyStatusMaster> allWarrantyStatuses = warrantyStatusService.getAllWarrantyStatusService();
        return new ResponseEntity<>(allWarrantyStatuses, HttpStatus.OK);
    }
}
