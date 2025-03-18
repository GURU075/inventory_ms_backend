package IMS.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IMS.DAO.PurchaseOrderDAO;
import IMS.DAO.PurchaseOrderHistoryDAO;
import IMS.DAO.VendorDAO;
import IMS.Master.PurchaseOrderHistoryMaster;
import IMS.Master.PurchaseOrderMaster;
import IMS.Master.VendorMaster;
import IMS.Service.PurchaseOrderService;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private static final Logger logger = LogManager.getLogger(PurchaseOrderServiceImpl.class);

    @Autowired
    private PurchaseOrderDAO purchaseOrderDAO;

    @Autowired
    private PurchaseOrderHistoryDAO purchaseOrderHistoryDAO;
    
    @Autowired
    private VendorDAO vendorDAO;

    @Override
    public Boolean addPurchaseOrder(PurchaseOrderMaster purchaseOrder) {
        try {
            logger.info("In addPurchaseOrder");
            VendorMaster vendor = vendorDAO.findById(purchaseOrder.getVendor().getVendorId()).orElseThrow(() -> new RuntimeException("Vendor not found"));
            purchaseOrder.setVendor(vendor);
            purchaseOrderDAO.save(purchaseOrder);

            PurchaseOrderHistoryMaster oldPurchaseOrder = new PurchaseOrderHistoryMaster();
            oldPurchaseOrder.setPoId(purchaseOrder.getPoId());
            oldPurchaseOrder.setPoDate(purchaseOrder.getPoDate());
            oldPurchaseOrder.setPoAmount(purchaseOrder.getPoAmount());
            oldPurchaseOrder.setPoTermsAndConditions(purchaseOrder.getPoTermsAndConditions());
            oldPurchaseOrder.setVendorId(vendor.getVendorId());
            oldPurchaseOrder.setAction("Create");
            oldPurchaseOrder.setTimestamp(LocalDateTime.now());

            purchaseOrderHistoryDAO.save(oldPurchaseOrder);
            logger.info("Out of addPurchaseOrder");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean updatePurchaseOrder(PurchaseOrderMaster purchaseOrder) {
        try {
            logger.info("In updatePurchaseOrder");
            PurchaseOrderMaster existingOrder = purchaseOrderDAO.findById(purchaseOrder.getPoId()).orElseThrow(() -> new RuntimeException("Purchase Order not found"));

            PurchaseOrderHistoryMaster oldPurchaseOrder = new PurchaseOrderHistoryMaster();
            oldPurchaseOrder.setPoId(existingOrder.getPoId());
            oldPurchaseOrder.setPoDate(existingOrder.getPoDate());
            oldPurchaseOrder.setPoAmount(existingOrder.getPoAmount());
            oldPurchaseOrder.setPoTermsAndConditions(existingOrder.getPoTermsAndConditions());
            oldPurchaseOrder.setVendorId(existingOrder.getVendor().getVendorId());
            oldPurchaseOrder.setAction("Update");
            oldPurchaseOrder.setTimestamp(LocalDateTime.now());

            VendorMaster vendor = vendorDAO.findById(purchaseOrder.getVendor().getVendorId()).orElseThrow(() -> new RuntimeException("Vendor not found"));
            purchaseOrder.setVendor(vendor);
            existingOrder.setPoDate(purchaseOrder.getPoDate());
            existingOrder.setPoAmount(purchaseOrder.getPoAmount());
            existingOrder.setPoTermsAndConditions(purchaseOrder.getPoTermsAndConditions());
            existingOrder.setVendor(vendor);
            purchaseOrderDAO.save(existingOrder);

            purchaseOrderHistoryDAO.save(oldPurchaseOrder);
            logger.info("Out of updatePurchaseOrder");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean deletePurchaseOrder(PurchaseOrderMaster purchaseOrder) {
        try {
            logger.info("In deletePurchaseOrder");
            PurchaseOrderMaster existingOrder = purchaseOrderDAO.findById(purchaseOrder.getPoId()).orElseThrow(() -> new RuntimeException("Purchase Order not found"));

            PurchaseOrderHistoryMaster oldPurchaseOrder = new PurchaseOrderHistoryMaster();
            oldPurchaseOrder.setPoId(existingOrder.getPoId());
            oldPurchaseOrder.setPoDate(existingOrder.getPoDate());
            oldPurchaseOrder.setPoAmount(existingOrder.getPoAmount());
            oldPurchaseOrder.setPoTermsAndConditions(existingOrder.getPoTermsAndConditions());
            oldPurchaseOrder.setVendorId(existingOrder.getVendor().getVendorId());
            oldPurchaseOrder.setAction("Delete");
            oldPurchaseOrder.setTimestamp(LocalDateTime.now());

            purchaseOrderDAO.delete(existingOrder);

            purchaseOrderHistoryDAO.save(oldPurchaseOrder);
            logger.info("Out of deletePurchaseOrder");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public PurchaseOrderMaster getPurchaseOrder(Integer poId) {
        try {
            logger.info("In getPurchaseOrder");
            PurchaseOrderMaster purchaseOrder = purchaseOrderDAO.findById(poId).orElse(null);
            logger.info("Out of getPurchaseOrder");
            return purchaseOrder;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<PurchaseOrderMaster> getAllPurchaseOrders() {
        List<PurchaseOrderMaster> allPurchaseOrders = new ArrayList<>();
        try {
            logger.info("In getAllPurchaseOrders");
            allPurchaseOrders = (List<PurchaseOrderMaster>) purchaseOrderDAO.findAll();
            logger.info("Out of getAllPurchaseOrders");
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
        }
        return allPurchaseOrders;
    }
}
