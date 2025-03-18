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

import IMS.Master.AssetDetailsMaster;
import IMS.Service.AssetDetailsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/AssetDetails")
public class AssetDetailsController {

    @Autowired
    private AssetDetailsService assetDetailsService;

    @PostMapping("/addAssetDetails")
    public ResponseEntity<String> addAssetDetails(@RequestBody @Valid AssetDetailsMaster assetDetailsMaster) {
        Boolean isAdded = assetDetailsService.addAssetDetailsService(assetDetailsMaster);
        if (isAdded) {
            return new ResponseEntity<>("Asset Details added successfully!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add Asset Details.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateAssetDetails/{assetDetailsId}")
    public ResponseEntity<String> updateAssetDetails(
            @PathVariable("assetDetailsId") @Positive(message = "Asset Details ID must be positive") Integer assetDetailsId,
            @RequestBody @Valid AssetDetailsMaster assetDetailsMaster) {
        assetDetailsMaster.setAssetDetailsId(assetDetailsId);
        Boolean isUpdated = assetDetailsService.updateAssetDetailsService(assetDetailsMaster);
        if (isUpdated) {
            return new ResponseEntity<>("Asset Details updated successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update Asset Details.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteAssetDetails/{assetDetailsId}")
    public ResponseEntity<String> deleteAssetDetails(@PathVariable("assetDetailsId") @Positive(message = "Asset Details ID must be positive") Integer assetDetailsId) {
        AssetDetailsMaster assetDetailsMaster = assetDetailsService.getAssetDetailsService(assetDetailsId);
        if (assetDetailsMaster != null) {
            Boolean isDeleted = assetDetailsService.deleteAssetDetailsService(assetDetailsMaster);
            if (isDeleted) {
                return new ResponseEntity<>("Asset Details deleted successfully!", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Failed to delete Asset Details.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getAssetDetails/{assetDetailsId}")
    public ResponseEntity<AssetDetailsMaster> getAssetDetails(@PathVariable("assetDetailsId") @Positive(message = "Asset Details ID must be positive") Integer assetDetailsId) {
        AssetDetailsMaster assetDetailsMaster = assetDetailsService.getAssetDetailsService(assetDetailsId);
        if (assetDetailsMaster != null) {
            return new ResponseEntity<>(assetDetailsMaster, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllAssetDetails")
    public ResponseEntity<List<AssetDetailsMaster>> getAllAssetDetails() {
        List<AssetDetailsMaster> allAssetDetails = assetDetailsService.getAllAssetDetailsService();
        return new ResponseEntity<>(allAssetDetails, HttpStatus.OK);
    }
}
