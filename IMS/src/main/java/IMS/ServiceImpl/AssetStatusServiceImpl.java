package IMS.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IMS.DAO.AssetStatusDAO;
import IMS.DAO.AssetStatusHistoryDAO;
import IMS.Master.AssetStatusHistoryMaster;
import IMS.Master.AssetStatusMaster;
import IMS.Service.AssetStatusService;

@Service
public class AssetStatusServiceImpl implements AssetStatusService {

    private static final Logger logger = LogManager.getLogger(AssetStatusServiceImpl.class);

    @Autowired
    private AssetStatusDAO assetStatusDAO;

    @Autowired
    private AssetStatusHistoryDAO assetStatusHistoryDAO;

    @Override
    public Boolean addAssetStatusService(AssetStatusMaster assetStatusMaster) {
        try {
            logger.info("In addAssetStatusService");
            assetStatusDAO.save(assetStatusMaster);

            AssetStatusHistoryMaster oldAssetStatus = new AssetStatusHistoryMaster();
            oldAssetStatus.setAssetStatusId(assetStatusMaster.getAssetStatusId());
            oldAssetStatus.setAssetStatusName(assetStatusMaster.getAssetStatusName());
            oldAssetStatus.setAssetStatusDesc(assetStatusMaster.getAssetStatusDesc());
            oldAssetStatus.setAction("Create");
            oldAssetStatus.setTimestamp(LocalDateTime.now());

            assetStatusHistoryDAO.save(oldAssetStatus);
            logger.info("Out of addAssetStatusService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean updateAssetStatusService(AssetStatusMaster assetStatusMaster) {
        try {
            logger.info("In updateAssetStatusService");
            AssetStatusMaster assetStatus = assetStatusDAO.findById(assetStatusMaster.getAssetStatusId()).orElseThrow(() -> new RuntimeException("Asset Status not found"));

            AssetStatusHistoryMaster oldAssetStatus = new AssetStatusHistoryMaster();
            oldAssetStatus.setAssetStatusId(assetStatus.getAssetStatusId());
            oldAssetStatus.setAssetStatusName(assetStatus.getAssetStatusName());
            oldAssetStatus.setAssetStatusDesc(assetStatusMaster.getAssetStatusDesc());
            oldAssetStatus.setAction("Update");
            oldAssetStatus.setTimestamp(LocalDateTime.now());

            assetStatus.setAssetStatusName(assetStatusMaster.getAssetStatusName());
            assetStatus.setAssetStatusDesc(assetStatusMaster.getAssetStatusDesc());
            assetStatus = assetStatusDAO.save(assetStatus);

            assetStatusHistoryDAO.save(oldAssetStatus);
            logger.info("Out of updateAssetStatusService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean deleteAssetStatusService(AssetStatusMaster assetStatusMaster) {
        try {
            logger.info("In deleteAssetStatusService");
            AssetStatusMaster assetStatus = assetStatusDAO.findById(assetStatusMaster.getAssetStatusId()).orElseThrow(() -> new RuntimeException("Asset Status not found"));

            AssetStatusHistoryMaster oldAssetStatus = new AssetStatusHistoryMaster();
            oldAssetStatus.setAssetStatusId(assetStatus.getAssetStatusId());
            oldAssetStatus.setAssetStatusName(assetStatus.getAssetStatusName());
            oldAssetStatus.setAssetStatusDesc(assetStatus.getAssetStatusDesc());
            oldAssetStatus.setAction("Delete");
            oldAssetStatus.setTimestamp(LocalDateTime.now());

            assetStatusDAO.delete(assetStatus);

            assetStatusHistoryDAO.save(oldAssetStatus);
            logger.info("Out of deleteAssetStatusService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public AssetStatusMaster getAssetStatusService(Integer assetStatusId) {
        try {
            logger.info("In getAssetStatusService");
            AssetStatusMaster assetStatusMaster = assetStatusDAO.findById(assetStatusId).orElse(null);
            logger.info("Out of getAssetStatusService");
            return assetStatusMaster;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<AssetStatusMaster> getAllAssetStatusService() {
        List<AssetStatusMaster> allAssetStatuses = new ArrayList<>();
        try {
            logger.info("In getAllAssetStatusService");
            allAssetStatuses = (List<AssetStatusMaster>) assetStatusDAO.findAll();
            logger.info("Out of getAllAssetStatusService");
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
        }
        return allAssetStatuses;
    }
}
