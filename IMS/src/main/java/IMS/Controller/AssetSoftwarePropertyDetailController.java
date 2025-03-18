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

import IMS.Master.AssetSoftwarePropertyDetailMaster;
import IMS.Service.AssetSoftwarePropertyDetailService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/AssetSoftwarePropertyDetail")
public class AssetSoftwarePropertyDetailController {

    @Autowired
    private AssetSoftwarePropertyDetailService assetSoftwarePropertyDetailService;

    @PostMapping("/addAssetSoftwarePropertyDetail")
    public ResponseEntity<String> addAssetSoftwarePropertyDetail(@RequestBody @Valid AssetSoftwarePropertyDetailMaster assetSoftwarePropertyDetail) {
        Boolean isAdded = assetSoftwarePropertyDetailService.addAssetSoftwarePropertyDetail(assetSoftwarePropertyDetail);
        if (isAdded) {
            return new ResponseEntity<>("Asset Software Property Detail added successfully!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add Asset Software Property Detail.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateAssetSoftwarePropertyDetail/{assetSoftwareDetailId}")
    public ResponseEntity<String> updateAssetSoftwarePropertyDetail(
            @PathVariable("assetSoftwareDetailId") @Positive(message = "Asset Software Property Detail ID must be positive") Integer assetSoftwareDetailId,
            @RequestBody @Valid AssetSoftwarePropertyDetailMaster assetSoftwarePropertyDetail) {
        assetSoftwarePropertyDetail.setAssetSoftwareDetailId(assetSoftwareDetailId);
        Boolean isUpdated = assetSoftwarePropertyDetailService.updateAssetSoftwarePropertyDetail(assetSoftwarePropertyDetail);
        if (isUpdated) {
            return new ResponseEntity<>("Asset Software Property Detail updated successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update Asset Software Property Detail.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteAssetSoftwarePropertyDetail/{assetSoftwareDetailId}")
    public ResponseEntity<String> deleteAssetSoftwarePropertyDetail(@PathVariable("assetSoftwareDetailId") @Positive(message = "Asset Software Property Detail ID must be positive") Integer assetSoftwareDetailId) {
        AssetSoftwarePropertyDetailMaster assetSoftwarePropertyDetail = assetSoftwarePropertyDetailService.getAssetSoftwarePropertyDetail(assetSoftwareDetailId);
        if (assetSoftwarePropertyDetail != null) {
            Boolean isDeleted = assetSoftwarePropertyDetailService.deleteAssetSoftwarePropertyDetail(assetSoftwarePropertyDetail);
            if (isDeleted) {
                return new ResponseEntity<>("Asset Software Property Detail deleted successfully!", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Failed to delete Asset Software Property Detail.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getAssetSoftwarePropertyDetail/{assetSoftwareDetailId}")
    public ResponseEntity<AssetSoftwarePropertyDetailMaster> getAssetSoftwarePropertyDetail(@PathVariable("assetSoftwareDetailId") @Positive(message = "Asset Software Property Detail ID must be positive") Integer assetSoftwareDetailId) {
        AssetSoftwarePropertyDetailMaster assetSoftwarePropertyDetail = assetSoftwarePropertyDetailService.getAssetSoftwarePropertyDetail(assetSoftwareDetailId);
        if (assetSoftwarePropertyDetail != null) {
            return new ResponseEntity<>(assetSoftwarePropertyDetail, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllAssetSoftwarePropertyDetails")
    public ResponseEntity<List<AssetSoftwarePropertyDetailMaster>> getAllAssetSoftwarePropertyDetails() {
        List<AssetSoftwarePropertyDetailMaster> allAssetSoftwarePropertyDetails = assetSoftwarePropertyDetailService.getAllAssetSoftwarePropertyDetails();
        return new ResponseEntity<>(allAssetSoftwarePropertyDetails, HttpStatus.OK);
    }
}
