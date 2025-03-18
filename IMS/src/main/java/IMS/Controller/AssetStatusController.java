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

import IMS.Master.AssetStatusMaster;
import IMS.Service.AssetStatusService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/AssetStatus")
public class AssetStatusController {

    @Autowired
    private AssetStatusService assetStatusService;

    @PostMapping("/addAssetStatus")
    public ResponseEntity<String> addAssetStatus(@RequestBody @Valid AssetStatusMaster assetStatusMaster) {
        Boolean isAdded = assetStatusService.addAssetStatusService(assetStatusMaster);
        if (isAdded) {
            return new ResponseEntity<>("Asset Status added successfully!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add Asset Status.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateAssetStatus/{assetStatusId}")
    public ResponseEntity<String> updateAssetStatus(
            @PathVariable("assetStatusId") @Positive(message = "Asset Status ID must be positive") Integer assetStatusId,
            @RequestBody @Valid AssetStatusMaster assetStatusMaster) {
        assetStatusMaster.setAssetStatusId(assetStatusId);
        Boolean isUpdated = assetStatusService.updateAssetStatusService(assetStatusMaster);
        if (isUpdated) {
            return new ResponseEntity<>("Asset Status updated successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update Asset Status.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteAssetStatus/{assetStatusId}")
    public ResponseEntity<String> deleteAssetStatus(@PathVariable("assetStatusId") @Positive(message = "Asset Status ID must be positive") Integer assetStatusId) {
        AssetStatusMaster assetStatusMaster = assetStatusService.getAssetStatusService(assetStatusId);
        if (assetStatusMaster != null) {
            Boolean isDeleted = assetStatusService.deleteAssetStatusService(assetStatusMaster);
            if (isDeleted) {
                return new ResponseEntity<>("Asset Status deleted successfully!", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Failed to delete Asset Status.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getAssetStatus/{assetStatusId}")
    public ResponseEntity<AssetStatusMaster> getAssetStatus(@PathVariable("assetStatusId") @Positive(message = "Asset Status ID must be positive") Integer assetStatusId) {
        AssetStatusMaster assetStatusMaster = assetStatusService.getAssetStatusService(assetStatusId);
        if (assetStatusMaster != null) {
            return new ResponseEntity<>(assetStatusMaster, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllAssetStatuses")
    public ResponseEntity<List<AssetStatusMaster>> getAllAssetStatuses() {
        List<AssetStatusMaster> allAssetStatuses = assetStatusService.getAllAssetStatusService();
        return new ResponseEntity<>(allAssetStatuses, HttpStatus.OK);
    }
}
