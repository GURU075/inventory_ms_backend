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

import IMS.Master.AllocationTypeMaster;
import IMS.Service.AllocationTypeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/AllocationType")
public class AllocationTypeController {
//
    @Autowired
    private AllocationTypeService allocationTypeService;

    @PostMapping("/addAllocationType")
    public ResponseEntity<String> addAllocationType(@RequestBody @Valid AllocationTypeMaster allocationTypeMaster) {
        Boolean isAdded = allocationTypeService.addAllocationTypeService(allocationTypeMaster);
        if (isAdded) {
            return new ResponseEntity<>("Allocation Type added successfully!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add Allocation Type.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateAllocationType/{allocationTypeId}")
    public ResponseEntity<String> updateAllocationType(
            @PathVariable("allocationTypeId") @Positive(message = "Allocation Type ID must be positive") Integer allocationTypeId,
            @RequestBody @Valid AllocationTypeMaster allocationTypeMaster) {
        allocationTypeMaster.setAllocationTypeId(allocationTypeId);
        Boolean isUpdated = allocationTypeService.updateAllocationTypeService(allocationTypeMaster);
        if (isUpdated) {
            return new ResponseEntity<>("Allocation Type updated successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update Allocation Type.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteAllocationType/{allocationTypeId}")
    public ResponseEntity<String> deleteAllocationType(@PathVariable("allocationTypeId") @Positive(message = "Allocation Type ID must be positive") Integer allocationTypeId) {
        AllocationTypeMaster allocationTypeMaster = allocationTypeService.getAllocationTypeService(allocationTypeId);
        if (allocationTypeMaster != null) {
            Boolean isDeleted = allocationTypeService.deleteAllocationTypeService(allocationTypeMaster);
            if (isDeleted) {
                return new ResponseEntity<>("Allocation Type deleted successfully!", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Failed to delete Allocation Type.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getAllocationType/{allocationTypeId}")
    public ResponseEntity<AllocationTypeMaster> getAllocationType(@PathVariable("allocationTypeId") @Positive(message = "Allocation Type ID must be positive") Integer allocationTypeId) {
        AllocationTypeMaster allocationTypeMaster = allocationTypeService.getAllocationTypeService(allocationTypeId);
        if (allocationTypeMaster != null) {
            return new ResponseEntity<>(allocationTypeMaster, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
//
    @GetMapping("/getAllAllocationTypes")
    public ResponseEntity<List<AllocationTypeMaster>> getAllAllocationTypes() {
        List<AllocationTypeMaster> allAllocationTypes = allocationTypeService.getAllAllocationTypeService();
        return new ResponseEntity<>(allAllocationTypes, HttpStatus.OK);
    }
    //
}
