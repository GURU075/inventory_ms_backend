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

import IMS.Master.AssetFilterRequest;
import IMS.Master.AssetMaster;
import IMS.Master.CategoryMaster;
import IMS.Master.LocationMaster;
import IMS.Master.SubCategoryMaster;
import IMS.Service.AssetService;
import IMS.Service.CategoryService;
import IMS.Service.LocationService;
import IMS.Service.SubCategoryService;
import IMS.ServiceImpl.AssetFilterServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/Asset")
public class AssetController {

    @Autowired
    private AssetService assetService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SubCategoryService subCategoryService;
    
    @Autowired
    private AssetFilterServiceImpl assetFilterServiceImpl;
    
    @PostMapping("/filter")
    public List<AssetMaster> filterAssets(@RequestBody AssetFilterRequest filterRequest) {
        return assetFilterServiceImpl.getFilteredAssets(filterRequest);
    }

    @PostMapping("/addAsset")
    public ResponseEntity<?> addAsset(@RequestBody @Valid AssetMaster assetMaster) {
        // Fetch related entities
        LocationMaster location = locationService.getLocationService(assetMaster.getLocation().getLocationId());
        CategoryMaster category = categoryService.getCategoryService(assetMaster.getCategory().getCategoryId());
        SubCategoryMaster subCategory = subCategoryService.getSubCategoryService(assetMaster.getSubCategory().getSubCategoryId());

        // Validate related entities
        if (location == null) {
            return new ResponseEntity<>("Invalid Location", HttpStatus.BAD_REQUEST);
        }
        if (category == null) {
            return new ResponseEntity<>("Invalid Category", HttpStatus.BAD_REQUEST);
        }
        if (subCategory == null) {
            return new ResponseEntity<>("Invalid SubCategory", HttpStatus.BAD_REQUEST);
        }

        // Set associations
        assetMaster.setLocation(location);
        assetMaster.setCategory(category);
        assetMaster.setSubCategory(subCategory);

        // Save asset and return the saved entity
        AssetMaster savedAsset = assetService.addAssetService(assetMaster);
        if (savedAsset != null) {
            return new ResponseEntity<>(savedAsset, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add Asset.", HttpStatus.BAD_REQUEST);
        }
    }



    @PutMapping("/updateAsset/{assetId}")
    public ResponseEntity<String> updateAsset(
            @PathVariable("assetId") @Positive(message = "Asset ID must be positive") Integer assetId,
            @RequestBody @Valid AssetMaster assetMaster) {
        
    	LocationMaster location = locationService.getLocationService(assetMaster.getLocation().getLocationId());
    	CategoryMaster category = categoryService.getCategoryService(assetMaster.getCategory().getCategoryId());
        SubCategoryMaster subCategory = subCategoryService.getSubCategoryService(assetMaster.getSubCategory().getSubCategoryId());

        if (location != null && category != null && subCategory != null) {
            assetMaster.setLocation(location);
            assetMaster.setCategory(category);
            assetMaster.setSubCategory(subCategory);
            assetMaster.setAssetId(assetId);

            Boolean isUpdated = assetService.updateAssetService(assetMaster);
            if (isUpdated) {
                return new ResponseEntity<>("Asset updated successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Failed to update Asset.", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Invalid relationships.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteAsset/{assetId}")
    public ResponseEntity<String> deleteAsset(@PathVariable("assetId") @Positive(message = "Asset ID must be positive") Integer assetId) {
        AssetMaster assetMaster = assetService.getAssetService(assetId);
        if (assetMaster != null) {
            Boolean isDeleted = assetService.deleteAssetService(assetMaster);
            if (isDeleted) {
                return new ResponseEntity<>("Asset deleted successfully!", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Failed to delete Asset.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getAsset/{assetId}")
    public ResponseEntity<AssetMaster> getAsset(@PathVariable("assetId") @Positive(message = "Asset ID must be positive") Integer assetId) {
        AssetMaster assetMaster = assetService.getAssetService(assetId);
        if (assetMaster != null) {
            return new ResponseEntity<>(assetMaster, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllAssets")
    public ResponseEntity<List<AssetMaster>> getAllAssets() {
        List<AssetMaster> allAssets = assetService.getAllAssetService();
        return new ResponseEntity<>(allAssets, HttpStatus.OK);
    }
}
