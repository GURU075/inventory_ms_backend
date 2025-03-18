package IMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import IMS.Master.AssetPropertyDetailMaster;
import IMS.Service.AssetPropertyDetailService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/AssetPropertyDetail")
public class AssetPropertyDetailController {

    @Autowired
    private AssetPropertyDetailService assetPropertyDetailService;

    @PostMapping("/addAssetPropertyDetail")
    public ResponseEntity<String> addAssetPropertyDetail(@RequestBody @Valid AssetPropertyDetailMaster assetPropertyDetailMaster) {
        Boolean isAdded = assetPropertyDetailService.addAssetPropertyDetailService(assetPropertyDetailMaster);
        if (isAdded) {
            return new ResponseEntity<>("Asset Property Detail added successfully!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add Asset Property Detail.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateAssetPropertyDetail/{assetPropertyDetailId}")
    public ResponseEntity<String> updateAssetPropertyDetail(
            @PathVariable("assetPropertyDetailId") @Positive(message = "Asset Property Detail ID must be positive") Integer assetPropertyDetailId,
            @RequestBody @Valid AssetPropertyDetailMaster assetPropertyDetailMaster) {
        assetPropertyDetailMaster.setAssetPropertyDetailId(assetPropertyDetailId);
        Boolean isUpdated = assetPropertyDetailService.updateAssetPropertyDetailService(assetPropertyDetailMaster);
        if (isUpdated) {
            return new ResponseEntity<>("Asset Property Detail updated successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update Asset Property Detail.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteAssetPropertyDetail/{assetPropertyDetailId}")
    public ResponseEntity<String> deleteAssetPropertyDetail(@PathVariable("assetPropertyDetailId") @Positive(message = "Asset Property Detail ID must be positive") Integer assetPropertyDetailId) {
        AssetPropertyDetailMaster assetPropertyDetailMaster = assetPropertyDetailService.getAssetPropertyDetailService(assetPropertyDetailId);
        if (assetPropertyDetailMaster != null) {
            Boolean isDeleted = assetPropertyDetailService.deleteAssetPropertyDetailService(assetPropertyDetailMaster);
            if (isDeleted) {
                return new ResponseEntity<>("Asset Property Detail deleted successfully!", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Failed to delete Asset Property Detail.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getAssetPropertyDetail/{assetPropertyDetailId}")
    public ResponseEntity<AssetPropertyDetailMaster> getAssetPropertyDetail(@PathVariable("assetPropertyDetailId") @Positive(message = "Asset Property Detail ID must be positive") Integer assetPropertyDetailId) {
        AssetPropertyDetailMaster assetPropertyDetailMaster = assetPropertyDetailService.getAssetPropertyDetailService(assetPropertyDetailId);
        if (assetPropertyDetailMaster != null) {
            return new ResponseEntity<>(assetPropertyDetailMaster, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllAssetPropertyDetails")
    public ResponseEntity<List<AssetPropertyDetailMaster>> getAllAssetPropertyDetails() {
        List<AssetPropertyDetailMaster> allAssetPropertyDetails = assetPropertyDetailService.getAllAssetPropertyDetailsService();
        return new ResponseEntity<>(allAssetPropertyDetails, HttpStatus.OK);
    }
}
