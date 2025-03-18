package IMS.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IMS.DAO.AssetDAO;
import IMS.DAO.AssetHistoryDAO;
import IMS.DAO.CategoryDAO;
import IMS.DAO.LocationDAO;
import IMS.DAO.SubCategoryDAO;
import IMS.Master.AssetHistoryMaster;
import IMS.Master.AssetMaster;
import IMS.Master.CategoryMaster;
import IMS.Master.LocationMaster;
import IMS.Master.SubCategoryMaster;
import IMS.Service.AssetService;

@Service
public class AssetServiceImpl implements AssetService {

    private static final Logger logger = LogManager.getLogger(AssetServiceImpl.class);

    @Autowired
    private AssetDAO assetDAO;

    @Autowired
    private AssetHistoryDAO assetHistoryDAO;

    @Autowired
    private LocationDAO locationDAO;
    
    @Autowired
    private CategoryDAO categoryDAO;
    
    @Autowired
    private SubCategoryDAO subCategoryDAO;
    

    @Override
    public AssetMaster addAssetService(AssetMaster assetMaster) {
        try {
            logger.info("In addAssetService");

            LocationMaster location = locationDAO.findById(assetMaster.getLocation().getLocationId())
                    .orElseThrow(() -> new RuntimeException("Location not found"));
            assetMaster.setLocation(location);

            CategoryMaster category = categoryDAO.findById(assetMaster.getCategory().getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            assetMaster.setCategory(category);

            SubCategoryMaster subCategory = subCategoryDAO.findById(assetMaster.getSubCategory().getSubCategoryId())
                    .orElseThrow(() -> new RuntimeException("SubCategory not found"));
            assetMaster.setSubCategory(subCategory);

            AssetMaster savedAsset = assetDAO.save(assetMaster);

            AssetHistoryMaster oldAsset = new AssetHistoryMaster();
            oldAsset.setAssetId(savedAsset.getAssetId());
           
            oldAsset.setAssetDesc(savedAsset.getAssetDesc());
            oldAsset.setAssetBarCode(savedAsset.getAssetBarCode());
            oldAsset.setAmcStartDate(savedAsset.getAmcStartDate());
            oldAsset.setAmcEndDate(savedAsset.getAmcEndDate());
            oldAsset.setAssetAllocationTo(savedAsset.getAssetAllocationTo());
            oldAsset.setAssetAllocationDate(savedAsset.getAssetAllocationDate());
            oldAsset.setWarrantyStatus(savedAsset.getWarrentyStatus());
            oldAsset.setAllocationType(savedAsset.getAllocationType());
            oldAsset.setLocationId(savedAsset.getLocation().getLocationId());
            oldAsset.setCategoryId(savedAsset.getCategory().getCategoryId());
            oldAsset.setSubCategoryId(savedAsset.getSubCategory().getSubCategoryId());
            oldAsset.setAction("Create");
            oldAsset.setTimestamp(LocalDateTime.now());
            assetHistoryDAO.save(oldAsset);

            logger.info("Out of addAssetService");
            return savedAsset;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            
            return null;
        }
    }

    @Override
    public Boolean updateAssetService(AssetMaster assetMaster) {
        try {
            logger.info("In updateAssetService");
            AssetMaster asset = assetDAO.findById(assetMaster.getAssetId()).orElseThrow(() -> new RuntimeException("Asset not found"));

            AssetHistoryMaster oldAsset = new AssetHistoryMaster();
            oldAsset.setAssetId(asset.getAssetId());
            oldAsset.setAssetDesc(asset.getAssetDesc());
            oldAsset.setAssetBarCode(asset.getAssetBarCode());
            oldAsset.setAmcStartDate(asset.getAmcStartDate());
            oldAsset.setAmcEndDate(asset.getAmcEndDate());
            oldAsset.setAssetAllocationTo(assetMaster.getAssetAllocationTo());
            oldAsset.setAssetAllocationDate(assetMaster.getAssetAllocationDate());
            oldAsset.setWarrantyStatus(assetMaster.getWarrentyStatus());
            oldAsset.setAllocationType(assetMaster.getAllocationType());
            
            oldAsset.setLocationId(assetMaster.getLocation().getLocationId());
            oldAsset.setCategoryId(assetMaster.getCategory().getCategoryId());
            oldAsset.setSubCategoryId(assetMaster.getSubCategory().getSubCategoryId());
            
            oldAsset.setAction("Update");
            oldAsset.setTimestamp(LocalDateTime.now());
            
            
            LocationMaster location = locationDAO.findById(assetMaster.getLocation().getLocationId()).orElseThrow(() -> new RuntimeException("Location not found"));
            CategoryMaster category = categoryDAO.findById(assetMaster.getCategory().getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found")); 
            SubCategoryMaster subCategory = subCategoryDAO.findById(assetMaster.getSubCategory().getSubCategoryId()).orElseThrow(() -> new RuntimeException("SubCategory not found")); 
            assetMaster.setLocation(location); 
            assetMaster.setCategory(category); 
            assetMaster.setSubCategory(subCategory); 
            
            asset.setAssetDesc(assetMaster.getAssetDesc());
            asset.setAssetBarCode(assetMaster.getAssetBarCode());
            asset.setAmcStartDate(assetMaster.getAmcStartDate());
            asset.setAmcEndDate(assetMaster.getAmcEndDate());
            asset.setAssetAllocationTo(assetMaster.getAssetAllocationTo());
            asset.setAssetAllocationDate(assetMaster.getAssetAllocationDate());
            asset.setWarrentyStatus(assetMaster.getWarrentyStatus());
            asset.setAllocationType(assetMaster.getAllocationType());
            asset = assetDAO.save(asset);

            assetHistoryDAO.save(oldAsset);
            logger.info("Out of updateAssetService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean deleteAssetService(AssetMaster assetMaster) {
        try {
            logger.info("In deleteAssetService");
            AssetMaster asset = assetDAO.findById(assetMaster.getAssetId()).orElseThrow(() -> new RuntimeException("Asset not found"));

            AssetHistoryMaster oldAsset = new AssetHistoryMaster();
            oldAsset.setAssetId(asset.getAssetId());
            oldAsset.setAssetDesc(asset.getAssetDesc());
            oldAsset.setAssetBarCode(asset.getAssetBarCode());
            oldAsset.setAmcStartDate(asset.getAmcStartDate());
            oldAsset.setAmcEndDate(asset.getAmcEndDate());
            oldAsset.setAssetAllocationTo(assetMaster.getAssetAllocationTo());
            oldAsset.setAssetAllocationDate(assetMaster.getAssetAllocationDate());
            oldAsset.setWarrantyStatus(assetMaster.getWarrentyStatus());
            oldAsset.setAllocationType(assetMaster.getAllocationType());
            
            oldAsset.setLocationId(assetMaster.getLocation().getLocationId());
            oldAsset.setCategoryId(assetMaster.getCategory().getCategoryId());
            oldAsset.setSubCategoryId(assetMaster.getSubCategory().getSubCategoryId());
            
            oldAsset.setAction("Delete");
            oldAsset.setTimestamp(LocalDateTime.now());

            assetDAO.delete(asset);

            assetHistoryDAO.save(oldAsset);
            logger.info("Out of deleteAssetService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public AssetMaster getAssetService(Integer assetId) {
        try {
            logger.info("In getAssetService");
            AssetMaster assetMaster = assetDAO.findById(assetId).orElse(null);
            logger.info("Out of getAssetService");
            return assetMaster;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<AssetMaster> getAllAssetService() {
        List<AssetMaster> allAssets = new ArrayList<>();
        try {
            logger.info("In getAllAssetService");
            allAssets = (List<AssetMaster>) assetDAO.findAll();
            logger.info("Out of getAllAssetService");
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
        }
        return allAssets;
    }
    
    
    
    
//    @Override
//    public List<AssetMaster> getAssetsByLocation(String locationName) {
//        try {
//            logger.info("Fetching assets for location: {}", locationName);
//            return assetDAO.findByLocationLocationName(locationName);
//        } catch (Exception e) {
//            logger.error("Error fetching assets for location {}: {}", locationName, e.getMessage(), e);
//            return new ArrayList<>();
//        }
//    }
//    
//
//    @Override
//    public List<AssetMaster> getAssetsByFilters(String locationName, String categoryName, String subCategoryName, 
//                                                 String allocationType, String assetStatus) {
//        try {
//            logger.info("Fetching assets by filters");
//
//            Specification<AssetMaster> spec = Specification.where(AssetSpecifications.hasLocation(locationName))
//                .and(AssetSpecifications.hasCategory(categoryName))
//                .and(AssetSpecifications.hasSubCategory(subCategoryName))
//                .and(AssetSpecifications.hasAllocationType(allocationType))
//                .and(AssetSpecifications.hasAssetStatus(assetStatus));
//
//            List<AssetMaster> assets = assetDAO.findAll(spec);
//            logger.info("Out of getAssetsByFilters");
//            return assets;
//        } catch (Exception e) {
//            logger.error("Error fetching assets by filters: {}", e.getMessage(), e);
//            return new ArrayList<>();
//        }
//    }
}
