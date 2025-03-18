package IMS.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IMS.DAO.AssetPropertyDetailDAO;
import IMS.DAO.AssetPropertyDetailHistoryDAO;
import IMS.DAO.AssetDAO;
import IMS.Master.AssetPropertyDetailHistoryMaster;
import IMS.Master.AssetPropertyDetailMaster;
import IMS.Master.AssetMaster;
import IMS.Service.AssetPropertyDetailService;

@Service
public class AssetPropertyDetailServiceImpl implements AssetPropertyDetailService {

    private static final Logger logger = LogManager.getLogger(AssetPropertyDetailServiceImpl.class);

    @Autowired
    private AssetPropertyDetailDAO assetPropertyDetailDAO;

    @Autowired
    private AssetPropertyDetailHistoryDAO assetPropertyDetailHistoryDAO;
    
    @Autowired
    private AssetDAO assetDAO;

    @Override
    public Boolean addAssetPropertyDetailService(AssetPropertyDetailMaster assetPropertyDetail) {
        try {
            logger.info("In addAssetPropertyDetailService");
            AssetMaster asset = assetDAO.findById(assetPropertyDetail.getAsset().getAssetId()).orElseThrow(() -> new RuntimeException("Asset not found"));
            assetPropertyDetail.setAsset(asset);
            assetPropertyDetailDAO.save(assetPropertyDetail);

            AssetPropertyDetailHistoryMaster oldAssetPropertyDetail = new AssetPropertyDetailHistoryMaster();
            oldAssetPropertyDetail.setAssetPropertyDetailId(assetPropertyDetail.getAssetPropertyDetailId());
            oldAssetPropertyDetail.setAssetPropertyDetailName(assetPropertyDetail.getAssetPropertyDetailName());
            oldAssetPropertyDetail.setAssetPropertyDetailValue(assetPropertyDetail.getAssetPropertyDetailValue());
            oldAssetPropertyDetail.setAssetId(assetPropertyDetail.getAsset().getAssetId());
            oldAssetPropertyDetail.setAction("Create");
            oldAssetPropertyDetail.setTimestamp(LocalDateTime.now());

            assetPropertyDetailHistoryDAO.save(oldAssetPropertyDetail);
            logger.info("Out of addAssetPropertyDetailService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean updateAssetPropertyDetailService(AssetPropertyDetailMaster assetPropertyDetail) {
        try {
            logger.info("In updateAssetPropertyDetailService");
            AssetPropertyDetailMaster assetProp = assetPropertyDetailDAO.findById(assetPropertyDetail.getAssetPropertyDetailId()).orElseThrow(() -> new RuntimeException("Asset property detail not found"));

            AssetPropertyDetailHistoryMaster oldAssetPropertyDetail = new AssetPropertyDetailHistoryMaster();
            oldAssetPropertyDetail.setAssetPropertyDetailId(assetProp.getAssetPropertyDetailId());
            oldAssetPropertyDetail.setAssetPropertyDetailName(assetProp.getAssetPropertyDetailName());
            oldAssetPropertyDetail.setAssetPropertyDetailValue(assetProp.getAssetPropertyDetailValue());
            oldAssetPropertyDetail.setAssetId(assetProp.getAsset().getAssetId());
            oldAssetPropertyDetail.setAction("Update");
            oldAssetPropertyDetail.setTimestamp(LocalDateTime.now());

            AssetMaster asset = assetDAO.findById(assetPropertyDetail.getAsset().getAssetId()).orElseThrow(() -> new RuntimeException("Asset not found"));
            assetPropertyDetail.setAsset(asset);
            assetProp.setAssetPropertyDetailName(assetPropertyDetail.getAssetPropertyDetailName());
            assetProp.setAssetPropertyDetailValue(assetPropertyDetail.getAssetPropertyDetailValue());
            assetProp = assetPropertyDetailDAO.save(assetProp);

            assetPropertyDetailHistoryDAO.save(oldAssetPropertyDetail);
            logger.info("Out of updateAssetPropertyDetailService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean deleteAssetPropertyDetailService(AssetPropertyDetailMaster assetPropertyDetail) {
        try {
            logger.info("In deleteAssetPropertyDetailService");
            AssetPropertyDetailMaster assetProp = assetPropertyDetailDAO.findById(assetPropertyDetail.getAssetPropertyDetailId()).orElseThrow(() -> new RuntimeException("Asset property detail not found"));

            AssetPropertyDetailHistoryMaster oldAssetPropertyDetail = new AssetPropertyDetailHistoryMaster();
            oldAssetPropertyDetail.setAssetPropertyDetailId(assetProp.getAssetPropertyDetailId());
            oldAssetPropertyDetail.setAssetPropertyDetailName(assetProp.getAssetPropertyDetailName());
            oldAssetPropertyDetail.setAssetPropertyDetailValue(assetProp.getAssetPropertyDetailValue());
            oldAssetPropertyDetail.setAssetId(assetProp.getAsset().getAssetId());
            oldAssetPropertyDetail.setAction("Delete");
            oldAssetPropertyDetail.setTimestamp(LocalDateTime.now());

            assetPropertyDetailDAO.delete(assetProp);

            assetPropertyDetailHistoryDAO.save(oldAssetPropertyDetail);
            logger.info("Out of deleteAssetPropertyDetailService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public AssetPropertyDetailMaster getAssetPropertyDetailService(Integer assetPropertyDetailId) {
        try {
            logger.info("In getAssetPropertyDetailService");
            AssetPropertyDetailMaster assetPropertyDetail = assetPropertyDetailDAO.findById(assetPropertyDetailId).orElse(null);
            logger.info("Out of getAssetPropertyDetailService");
            return assetPropertyDetail;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<AssetPropertyDetailMaster> getAllAssetPropertyDetailsService() {
        List<AssetPropertyDetailMaster> allAssetPropertyDetails = new ArrayList<>();
        try {
            logger.info("In getAllAssetPropertyDetailsService");
            allAssetPropertyDetails = (List<AssetPropertyDetailMaster>) assetPropertyDetailDAO.findAll();
            logger.info("Out of getAllAssetPropertyDetailsService");
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
        }
        return allAssetPropertyDetails;
    }
}
