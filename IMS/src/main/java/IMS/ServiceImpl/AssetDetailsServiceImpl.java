package IMS.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IMS.DAO.AssetDAO;
import IMS.DAO.AssetDetailsDAO;
import IMS.DAO.AssetDetailsHistoryDAO;
import IMS.Master.AssetDetailsHistoryMaster;
import IMS.Master.AssetDetailsMaster;
import IMS.Master.AssetMaster;
import IMS.Service.AssetDetailsService;

@Service
public class AssetDetailsServiceImpl implements AssetDetailsService {

    private static final Logger logger = LogManager.getLogger(AssetDetailsServiceImpl.class);

    @Autowired
    private AssetDetailsDAO assetDetailsDAO;

    @Autowired
    private AssetDetailsHistoryDAO assetDetailsHistoryDAO;
    
    @Autowired
    private AssetDAO assetDAO;

    @Override
    public Boolean addAssetDetailsService(AssetDetailsMaster assetDetailsMaster) {
        try {
            logger.info("In addAssetDetailsService");
            AssetMaster asset = assetDAO.findById(assetDetailsMaster.getAsset().getAssetId()).orElseThrow(() -> new RuntimeException("MIC not found")); 
            assetDetailsMaster.setAsset(asset);
            assetDetailsDAO.save(assetDetailsMaster);

            AssetDetailsHistoryMaster oldAssetDetails = new AssetDetailsHistoryMaster();
            oldAssetDetails.setAssetDetailsId(assetDetailsMaster.getAssetDetailsId());
            oldAssetDetails.setAssetPropertyName(assetDetailsMaster.getAssetPropertyName());
            oldAssetDetails.setAssetPropertyValue(assetDetailsMaster.getAssetPropertyValue());
            oldAssetDetails.setAssetId(assetDetailsMaster.getAsset().getAssetId());
            oldAssetDetails.setAction("Create");
            oldAssetDetails.setTimestamp(LocalDateTime.now());

            assetDetailsHistoryDAO.save(oldAssetDetails);
            logger.info("Out of addAssetDetailsService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean updateAssetDetailsService(AssetDetailsMaster assetDetailsMaster) {
        try {
            logger.info("In updateAssetDetailsService");
            AssetDetailsMaster assetDetails = assetDetailsDAO.findById(assetDetailsMaster.getAssetDetailsId()).orElseThrow(() -> new RuntimeException("Asset Details not found"));

            AssetDetailsHistoryMaster oldAssetDetails = new AssetDetailsHistoryMaster();
            oldAssetDetails.setAssetDetailsId(assetDetails.getAssetDetailsId());
            oldAssetDetails.setAssetPropertyName(assetDetails.getAssetPropertyName());
            oldAssetDetails.setAssetPropertyValue(assetDetails.getAssetPropertyValue());
            oldAssetDetails.setAssetId(assetDetailsMaster.getAsset().getAssetId());
            oldAssetDetails.setAction("Update");
            oldAssetDetails.setTimestamp(LocalDateTime.now());

            assetDetails.setAssetPropertyName(assetDetailsMaster.getAssetPropertyName());
            assetDetails.setAssetPropertyValue(assetDetailsMaster.getAssetPropertyValue());
            oldAssetDetails.setAssetId(assetDetailsMaster.getAsset().getAssetId());
            assetDetails = assetDetailsDAO.save(assetDetails);

            assetDetailsHistoryDAO.save(oldAssetDetails);
            logger.info("Out of updateAssetDetailsService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean deleteAssetDetailsService(AssetDetailsMaster assetDetailsMaster) {
        try {
            logger.info("In deleteAssetDetailsService");
            AssetDetailsMaster assetDetails = assetDetailsDAO.findById(assetDetailsMaster.getAssetDetailsId()).orElseThrow(() -> new RuntimeException("Asset Details not found"));

            AssetDetailsHistoryMaster oldAssetDetails = new AssetDetailsHistoryMaster();
            oldAssetDetails.setAssetDetailsId(assetDetails.getAssetDetailsId());
            oldAssetDetails.setAssetPropertyName(assetDetails.getAssetPropertyName());
            oldAssetDetails.setAssetPropertyValue(assetDetails.getAssetPropertyValue());
            oldAssetDetails.setAssetId(assetDetailsMaster.getAsset().getAssetId());
            oldAssetDetails.setAction("Delete");
            oldAssetDetails.setTimestamp(LocalDateTime.now());

            assetDetailsDAO.delete(assetDetails);

            assetDetailsHistoryDAO.save(oldAssetDetails);
            logger.info("Out of deleteAssetDetailsService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public AssetDetailsMaster getAssetDetailsService(Integer assetDetailsId) {
        try {
            logger.info("In getAssetDetailsService");
            AssetDetailsMaster assetDetailsMaster = assetDetailsDAO.findById(assetDetailsId).orElse(null);
            logger.info("Out of getAssetDetailsService");
            return assetDetailsMaster;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<AssetDetailsMaster> getAllAssetDetailsService() {
        List<AssetDetailsMaster> allAssetDetails = new ArrayList<>();
        try {
            logger.info("In getAllAssetDetailsService");
            allAssetDetails = (List<AssetDetailsMaster>) assetDetailsDAO.findAll();
            logger.info("Out of getAllAssetDetailsService");
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
        }
        return allAssetDetails;
    }
}
