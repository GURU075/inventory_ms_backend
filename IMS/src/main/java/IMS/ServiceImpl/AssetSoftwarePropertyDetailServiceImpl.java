package IMS.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IMS.DAO.AssetDAO;
import IMS.DAO.AssetSoftwarePropertyDetailDAO;
import IMS.DAO.AssetSoftwarePropertyDetailHistoryDAO;
import IMS.Master.AssetMaster;
import IMS.Master.AssetSoftwarePropertyDetailHistoryMaster;
import IMS.Master.AssetSoftwarePropertyDetailMaster;
import IMS.Service.AssetSoftwarePropertyDetailService;

@Service
public class AssetSoftwarePropertyDetailServiceImpl implements AssetSoftwarePropertyDetailService {

    private static final Logger logger = LogManager.getLogger(AssetSoftwarePropertyDetailServiceImpl.class);

    @Autowired
    private AssetSoftwarePropertyDetailDAO assetSoftwarePropertyDetailDAO;

    @Autowired
    private AssetSoftwarePropertyDetailHistoryDAO assetSoftwarePropertyDetailHistoryDAO;
    
    @Autowired
    private AssetDAO assetDAO;

    @Override
    public Boolean addAssetSoftwarePropertyDetail(AssetSoftwarePropertyDetailMaster assetSoftwarePropertyDetail) {
        try {
            logger.info("In addAssetSoftwarePropertyDetail");
            AssetMaster asset = assetDAO.findById(assetSoftwarePropertyDetail.getAsset().getAssetId()).orElseThrow(() -> new RuntimeException("Asset not found"));
            assetSoftwarePropertyDetail.setAsset(asset);
            assetSoftwarePropertyDetailDAO.save(assetSoftwarePropertyDetail);

            AssetSoftwarePropertyDetailHistoryMaster oldAssetSoftwarePropertyDetail = new AssetSoftwarePropertyDetailHistoryMaster();
            oldAssetSoftwarePropertyDetail.setAssetSoftwareDetailId(assetSoftwarePropertyDetail.getAssetSoftwareDetailId());
            oldAssetSoftwarePropertyDetail.setAssetSoftwarePropertyName(assetSoftwarePropertyDetail.getAssetSoftwarePropertyName());
            oldAssetSoftwarePropertyDetail.setAssetSoftwarePropertyValue(assetSoftwarePropertyDetail.getAssetSoftwarePropertyValue());
            oldAssetSoftwarePropertyDetail.setAssetId(asset.getAssetId());
            oldAssetSoftwarePropertyDetail.setAction("Create");
            oldAssetSoftwarePropertyDetail.setTimestamp(LocalDateTime.now());

            assetSoftwarePropertyDetailHistoryDAO.save(oldAssetSoftwarePropertyDetail);
            logger.info("Out of addAssetSoftwarePropertyDetail");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean updateAssetSoftwarePropertyDetail(AssetSoftwarePropertyDetailMaster assetSoftwarePropertyDetail) {
        try {
            logger.info("In updateAssetSoftwarePropertyDetail");
            AssetSoftwarePropertyDetailMaster assetDetail = assetSoftwarePropertyDetailDAO.findById(assetSoftwarePropertyDetail.getAssetSoftwareDetailId()).orElseThrow(() -> new RuntimeException("Asset Software Property Detail not found"));

            AssetSoftwarePropertyDetailHistoryMaster oldAssetSoftwarePropertyDetail = new AssetSoftwarePropertyDetailHistoryMaster();
            oldAssetSoftwarePropertyDetail.setAssetSoftwareDetailId(assetDetail.getAssetSoftwareDetailId());
            oldAssetSoftwarePropertyDetail.setAssetSoftwarePropertyName(assetDetail.getAssetSoftwarePropertyName());
            oldAssetSoftwarePropertyDetail.setAssetSoftwarePropertyValue(assetDetail.getAssetSoftwarePropertyValue());
            oldAssetSoftwarePropertyDetail.setAssetId(assetDetail.getAsset().getAssetId());
            oldAssetSoftwarePropertyDetail.setAction("Update");
            oldAssetSoftwarePropertyDetail.setTimestamp(LocalDateTime.now());

            AssetMaster asset = assetDAO.findById(assetSoftwarePropertyDetail.getAsset().getAssetId()).orElseThrow(() -> new RuntimeException("Asset not found"));
            assetSoftwarePropertyDetail.setAsset(asset);
            assetDetail.setAssetSoftwarePropertyName(assetSoftwarePropertyDetail.getAssetSoftwarePropertyName());
            assetDetail.setAssetSoftwarePropertyValue(assetSoftwarePropertyDetail.getAssetSoftwarePropertyValue());
            assetDetail = assetSoftwarePropertyDetailDAO.save(assetDetail);

            assetSoftwarePropertyDetailHistoryDAO.save(oldAssetSoftwarePropertyDetail);
            logger.info("Out of updateAssetSoftwarePropertyDetail");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean deleteAssetSoftwarePropertyDetail(AssetSoftwarePropertyDetailMaster assetSoftwarePropertyDetail) {
        try {
            logger.info("In deleteAssetSoftwarePropertyDetail");
            AssetSoftwarePropertyDetailMaster assetDetail = assetSoftwarePropertyDetailDAO.findById(assetSoftwarePropertyDetail.getAssetSoftwareDetailId()).orElseThrow(() -> new RuntimeException("Asset Software Property Detail not found"));

            AssetSoftwarePropertyDetailHistoryMaster oldAssetSoftwarePropertyDetail = new AssetSoftwarePropertyDetailHistoryMaster();
            oldAssetSoftwarePropertyDetail.setAssetSoftwareDetailId(assetDetail.getAssetSoftwareDetailId());
            oldAssetSoftwarePropertyDetail.setAssetSoftwarePropertyName(assetDetail.getAssetSoftwarePropertyName());
            oldAssetSoftwarePropertyDetail.setAssetSoftwarePropertyValue(assetDetail.getAssetSoftwarePropertyValue());
            oldAssetSoftwarePropertyDetail.setAssetId(assetDetail.getAsset().getAssetId());
            oldAssetSoftwarePropertyDetail.setAction("Delete");
            oldAssetSoftwarePropertyDetail.setTimestamp(LocalDateTime.now());

            assetSoftwarePropertyDetailDAO.delete(assetDetail);

            assetSoftwarePropertyDetailHistoryDAO.save(oldAssetSoftwarePropertyDetail);
            logger.info("Out of deleteAssetSoftwarePropertyDetail");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public AssetSoftwarePropertyDetailMaster getAssetSoftwarePropertyDetail(Integer assetSoftwareDetailId) {
        try {
            logger.info("In getAssetSoftwarePropertyDetail");
            AssetSoftwarePropertyDetailMaster assetSoftwarePropertyDetail = assetSoftwarePropertyDetailDAO.findById(assetSoftwareDetailId).orElse(null);
            logger.info("Out of getAssetSoftwarePropertyDetail");
            return assetSoftwarePropertyDetail;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<AssetSoftwarePropertyDetailMaster> getAllAssetSoftwarePropertyDetails() {
        List<AssetSoftwarePropertyDetailMaster> allAssetSoftwarePropertyDetails = new ArrayList<>();
        try {
            logger.info("In getAllAssetSoftwarePropertyDetails");
            allAssetSoftwarePropertyDetails = (List<AssetSoftwarePropertyDetailMaster>) assetSoftwarePropertyDetailDAO.findAll();
            logger.info("Out of getAllAssetSoftwarePropertyDetails");
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
        }
        return allAssetSoftwarePropertyDetails;
    }
}
