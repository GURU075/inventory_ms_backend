package IMS.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IMS.DAO.VendorDAO;
import IMS.DAO.VendorHistoryDAO;
import IMS.Master.VendorHistoryMaster;
import IMS.Master.VendorMaster;
import IMS.Service.VendorService;

@Service
public class VendorServiceImpl implements VendorService {

    private static final Logger logger = LogManager.getLogger(VendorServiceImpl.class);

    @Autowired
    private VendorDAO vendorDAO;

    @Autowired
    private VendorHistoryDAO vendorHistoryDAO;

    @Override
    public Boolean addVendor(VendorMaster vendor) {
        try {
            logger.info("In addVendor");
            vendorDAO.save(vendor);

            VendorHistoryMaster oldVendor = new VendorHistoryMaster();
            oldVendor.setVendorId(vendor.getVendorId());
            oldVendor.setVendorName(vendor.getVendorName());
            oldVendor.setVendorContactPersonName(vendor.getVendorContactPersonName());
            oldVendor.setVendorContactPersonNumber(vendor.getVendorContactPersonNumber());
            oldVendor.setVendorContactPersonEmail(vendor.getVendorContactPersonEmail());
            oldVendor.setVendorAddress(vendor.getVendorAddress());
            oldVendor.setAction("Create");
            oldVendor.setTimestamp(LocalDateTime.now());

            vendorHistoryDAO.save(oldVendor);
            logger.info("Out of addVendor");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean updateVendor(VendorMaster vendor) {
        try {
            logger.info("In updateVendor");
            VendorMaster existingVendor = vendorDAO.findById(vendor.getVendorId()).orElseThrow(() -> new RuntimeException("Vendor not found"));

            VendorHistoryMaster oldVendor = new VendorHistoryMaster();
            oldVendor.setVendorId(existingVendor.getVendorId());
            oldVendor.setVendorName(existingVendor.getVendorName());
            oldVendor.setVendorContactPersonName(existingVendor.getVendorContactPersonName());
            oldVendor.setVendorContactPersonNumber(existingVendor.getVendorContactPersonNumber());
            oldVendor.setVendorContactPersonEmail(existingVendor.getVendorContactPersonEmail());
            oldVendor.setVendorAddress(existingVendor.getVendorAddress());
            oldVendor.setAction("Update");
            oldVendor.setTimestamp(LocalDateTime.now());

            existingVendor.setVendorName(vendor.getVendorName());
            existingVendor.setVendorContactPersonName(vendor.getVendorContactPersonName());
            existingVendor.setVendorContactPersonNumber(vendor.getVendorContactPersonNumber());
            existingVendor.setVendorContactPersonEmail(vendor.getVendorContactPersonEmail());
            existingVendor.setVendorAddress(vendor.getVendorAddress());
            vendorDAO.save(existingVendor);

            vendorHistoryDAO.save(oldVendor);
            logger.info("Out of updateVendor");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean deleteVendor(VendorMaster vendor) {
        try {
            logger.info("In deleteVendor");
            VendorMaster existingVendor = vendorDAO.findById(vendor.getVendorId()).orElseThrow(() -> new RuntimeException("Vendor not found"));

            VendorHistoryMaster oldVendor = new VendorHistoryMaster();
            oldVendor.setVendorId(existingVendor.getVendorId());
            oldVendor.setVendorName(existingVendor.getVendorName());
            oldVendor.setVendorContactPersonName(existingVendor.getVendorContactPersonName());
            oldVendor.setVendorContactPersonNumber(existingVendor.getVendorContactPersonNumber());
            oldVendor.setVendorContactPersonEmail(existingVendor.getVendorContactPersonEmail());
            oldVendor.setVendorAddress(existingVendor.getVendorAddress());
            oldVendor.setAction("Delete");
            oldVendor.setTimestamp(LocalDateTime.now());

            vendorDAO.delete(existingVendor);

            vendorHistoryDAO.save(oldVendor);
            logger.info("Out of deleteVendor");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public VendorMaster getVendor(Integer vendorId) {
        try {
            logger.info("In getVendor");
            VendorMaster vendor = vendorDAO.findById(vendorId).orElse(null);
            logger.info("Out of getVendor");
            return vendor;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<VendorMaster> getAllVendors() {
        List<VendorMaster> allVendors = new ArrayList<>();
        try {
            logger.info("In getAllVendors");
            allVendors = (List<VendorMaster>) vendorDAO.findAll();
            logger.info("Out of getAllVendors");
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
        }
        return allVendors;
    }
}
