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

import IMS.Master.VendorMaster;
import IMS.Service.VendorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/Vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @PostMapping("/addVendor")
    public ResponseEntity<String> addVendor(@RequestBody @Valid VendorMaster vendor) {
        Boolean isAdded = vendorService.addVendor(vendor);
        if (isAdded) {
            return new ResponseEntity<>("Vendor added successfully!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add Vendor.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateVendor/{vendorId}")
    public ResponseEntity<String> updateVendor(
            @PathVariable("vendorId") @Positive(message = "Vendor ID must be positive") Integer vendorId,
            @RequestBody @Valid VendorMaster vendor) {
        vendor.setVendorId(vendorId);
        Boolean isUpdated = vendorService.updateVendor(vendor);
        if (isUpdated) {
            return new ResponseEntity<>("Vendor updated successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update Vendor.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteVendor/{vendorId}")
    public ResponseEntity<String> deleteVendor(@PathVariable("vendorId") @Positive(message = "Vendor ID must be positive") Integer vendorId) {
        VendorMaster vendor = vendorService.getVendor(vendorId);
        if (vendor != null) {
            Boolean isDeleted = vendorService.deleteVendor(vendor);
            if (isDeleted) {
                return new ResponseEntity<>("Vendor deleted successfully!", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Failed to delete Vendor.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getVendor/{vendorId}")
    public ResponseEntity<VendorMaster> getVendor(@PathVariable("vendorId") @Positive(message = "Vendor ID must be positive") Integer vendorId) {
        VendorMaster vendor = vendorService.getVendor(vendorId);
        if (vendor != null) {
            return new ResponseEntity<>(vendor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllVendors")
    public ResponseEntity<List<VendorMaster>> getAllVendors() {
        List<VendorMaster> allVendors = vendorService.getAllVendors();
        return new ResponseEntity<>(allVendors, HttpStatus.OK);
    }
}
