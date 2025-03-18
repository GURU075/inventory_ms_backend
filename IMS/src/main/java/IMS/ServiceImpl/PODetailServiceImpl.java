package IMS.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IMS.DAO.AssetDAO;
import IMS.DAO.PODetailDAO;
import IMS.DAO.PODetailHistoryDAO;
import IMS.DAO.PurchaseOrderDAO;
import IMS.Master.AssetMaster;
import IMS.Master.PODetailHistoryMaster;
import IMS.Master.PODetailMaster;
import IMS.Master.PurchaseOrderMaster;
import IMS.Service.PODetailService;

@Service
public class PODetailServiceImpl implements PODetailService {

    private static final Logger logger = LogManager.getLogger(PODetailServiceImpl.class);

    @Autowired
    private PODetailDAO poDetailDAO;

    @Autowired
    private PODetailHistoryDAO poDetailHistoryDAO;
    
    @Autowired
    private AssetDAO assetDAO;

    @Autowired
    private PurchaseOrderDAO purchaseOrderDAO;

    @Override
    public Boolean addPODetail(PODetailMaster poDetail) {
        try {
            logger.info("In addPODetail");
            PurchaseOrderMaster purchaseOrder = purchaseOrderDAO.findById(poDetail.getPurchaseOrder().getPoId()).orElseThrow(() -> new RuntimeException("Purchase Order not found"));
            AssetMaster asset = assetDAO.findById(poDetail.getAsset().getAssetId()).orElseThrow(() -> new RuntimeException("Asset not found"));
            poDetail.setPurchaseOrder(purchaseOrder);
            poDetail.setAsset(asset);
            poDetailDAO.save(poDetail);

            PODetailHistoryMaster oldPODetail = new PODetailHistoryMaster();
            oldPODetail.setPoDetailId(poDetail.getPoDetailId());
            oldPODetail.setAssetQty(poDetail.getAssetQty());
            oldPODetail.setAssetRate(poDetail.getAssetRate());
            oldPODetail.setPoId(purchaseOrder.getPoId());
            oldPODetail.setAssetId(asset.getAssetId());
            oldPODetail.setAction("Create");
            oldPODetail.setTimestamp(LocalDateTime.now());

            poDetailHistoryDAO.save(oldPODetail);
            logger.info("Out of addPODetail");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean updatePODetail(PODetailMaster poDetail) {
        try {
            logger.info("In updatePODetail");
            PODetailMaster existingDetail = poDetailDAO.findById(poDetail.getPoDetailId()).orElseThrow(() -> new RuntimeException("PODetail not found"));

            PODetailHistoryMaster oldPODetail = new PODetailHistoryMaster();
            oldPODetail.setPoDetailId(existingDetail.getPoDetailId());
            oldPODetail.setAssetQty(existingDetail.getAssetQty());
            oldPODetail.setAssetRate(existingDetail.getAssetRate());
            oldPODetail.setPoId(existingDetail.getPurchaseOrder().getPoId());
            oldPODetail.setAssetId(existingDetail.getAsset().getAssetId());
            oldPODetail.setAction("Update");
            oldPODetail.setTimestamp(LocalDateTime.now());

            PurchaseOrderMaster purchaseOrder = purchaseOrderDAO.findById(poDetail.getPurchaseOrder().getPoId()).orElseThrow(() -> new RuntimeException("Purchase Order not found"));
            AssetMaster asset = assetDAO.findById(poDetail.getAsset().getAssetId()).orElseThrow(() -> new RuntimeException("Asset not found"));
            poDetail.setPurchaseOrder(purchaseOrder);
            poDetail.setAsset(asset);
            existingDetail.setAssetQty(poDetail.getAssetQty());
            existingDetail.setAssetRate(poDetail.getAssetRate());
            existingDetail.setPurchaseOrder(purchaseOrder);
            existingDetail.setAsset(asset);
            poDetailDAO.save(existingDetail);

            poDetailHistoryDAO.save(oldPODetail);
            logger.info("Out of updatePODetail");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean deletePODetail(PODetailMaster poDetail) {
        try {
            logger.info("In deletePODetail");
            PODetailMaster existingDetail = poDetailDAO.findById(poDetail.getPoDetailId()).orElseThrow(() -> new RuntimeException("PODetail not found"));

            PODetailHistoryMaster oldPODetail = new PODetailHistoryMaster();
            oldPODetail.setPoDetailId(existingDetail.getPoDetailId());
            oldPODetail.setAssetQty(existingDetail.getAssetQty());
            oldPODetail.setAssetRate(existingDetail.getAssetRate());
            oldPODetail.setPoId(existingDetail.getPurchaseOrder().getPoId());
            oldPODetail.setAssetId(existingDetail.getAsset().getAssetId());
            oldPODetail.setAction("Delete");
            oldPODetail.setTimestamp(LocalDateTime.now());

            poDetailDAO.delete(existingDetail);

            poDetailHistoryDAO.save(oldPODetail);
            logger.info("Out of deletePODetail");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public PODetailMaster getPODetail(Integer poDetailId) {
        try {
            logger.info("In getPODetail");
            PODetailMaster poDetail = poDetailDAO.findById(poDetailId).orElse(null);
            logger.info("Out of getPODetail");
            return poDetail;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<PODetailMaster> getAllPODetails() {
        List<PODetailMaster> allPODetails = new ArrayList<>();
        try {
            logger.info("In getAllPODetails");
            allPODetails = (List<PODetailMaster>) poDetailDAO.findAll();
            logger.info("Out of getAllPODetails");
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
        }
        return allPODetails;
    }
}
