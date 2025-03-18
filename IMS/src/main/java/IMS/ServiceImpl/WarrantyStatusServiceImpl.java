package IMS.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IMS.DAO.WarrantyStatusDAO;
import IMS.DAO.WarrantyStatusHistoryDAO;
import IMS.Master.WarrantyStatusHistoryMaster;
import IMS.Master.WarrantyStatusMaster;
import IMS.Service.WarrantyStatusService;

@Service
public class WarrantyStatusServiceImpl implements WarrantyStatusService {

    private static final Logger logger = LogManager.getLogger(WarrantyStatusServiceImpl.class);

    @Autowired
    private WarrantyStatusDAO warrantyStatusDAO;

    @Autowired
    private WarrantyStatusHistoryDAO warrantyStatusHistoryDAO;

    @Override
    public Boolean addWarrantyStatusService(WarrantyStatusMaster warrantyStatusMaster) {
        try {
            logger.info("In addWarrantyStatusService");
            warrantyStatusDAO.save(warrantyStatusMaster);

            WarrantyStatusHistoryMaster oldWarrantyStatus = new WarrantyStatusHistoryMaster();
            oldWarrantyStatus.setWarrantyStatusId(warrantyStatusMaster.getWarrantyStatusId());
            oldWarrantyStatus.setWarrantyStatusName(warrantyStatusMaster.getWarrantyStatusName());
            oldWarrantyStatus.setWarrantyStatusDesc(warrantyStatusMaster.getWarrantyStatusDesc());
            oldWarrantyStatus.setAction("Create");
            oldWarrantyStatus.setTimestamp(LocalDateTime.now());

            warrantyStatusHistoryDAO.save(oldWarrantyStatus);
            logger.info("Out of addWarrantyStatusService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean updateWarrantyStatusService(WarrantyStatusMaster warrantyStatusMaster) {
        try {
            logger.info("In updateWarrantyStatusService");
            WarrantyStatusMaster warrantyStatus = warrantyStatusDAO.findById(warrantyStatusMaster.getWarrantyStatusId()).orElseThrow(() -> new RuntimeException("Warranty Status not found"));

            WarrantyStatusHistoryMaster oldWarrantyStatus = new WarrantyStatusHistoryMaster();
            oldWarrantyStatus.setWarrantyStatusId(warrantyStatus.getWarrantyStatusId());
            oldWarrantyStatus.setWarrantyStatusName(warrantyStatus.getWarrantyStatusName());
            oldWarrantyStatus.setWarrantyStatusDesc(warrantyStatusMaster.getWarrantyStatusDesc());
            oldWarrantyStatus.setAction("Update");
            oldWarrantyStatus.setTimestamp(LocalDateTime.now());

            warrantyStatus.setWarrantyStatusName(warrantyStatusMaster.getWarrantyStatusName());
            warrantyStatus.setWarrantyStatusDesc(warrantyStatusMaster.getWarrantyStatusDesc());
            warrantyStatus = warrantyStatusDAO.save(warrantyStatus);

            warrantyStatusHistoryDAO.save(oldWarrantyStatus);
            logger.info("Out of updateWarrantyStatusService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean deleteWarrantyStatusService(WarrantyStatusMaster warrantyStatusMaster) {
        try {
            logger.info("In deleteWarrantyStatusService");
            WarrantyStatusMaster warrantyStatus = warrantyStatusDAO.findById(warrantyStatusMaster.getWarrantyStatusId()).orElseThrow(() -> new RuntimeException("Warranty Status not found"));

            WarrantyStatusHistoryMaster oldWarrantyStatus = new WarrantyStatusHistoryMaster();
            oldWarrantyStatus.setWarrantyStatusId(warrantyStatus.getWarrantyStatusId());
            oldWarrantyStatus.setWarrantyStatusName(warrantyStatus.getWarrantyStatusName());
            oldWarrantyStatus.setWarrantyStatusDesc(warrantyStatusMaster.getWarrantyStatusDesc());
            oldWarrantyStatus.setAction("Delete");
            oldWarrantyStatus.setTimestamp(LocalDateTime.now());

            warrantyStatusDAO.delete(warrantyStatus);

            warrantyStatusHistoryDAO.save(oldWarrantyStatus);
            logger.info("Out of deleteWarrantyStatusService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public WarrantyStatusMaster getWarrantyStatusService(Integer warrantyStatusId) {
        try {
            logger.info("In getWarrantyStatusService");
            WarrantyStatusMaster warrantyStatusMaster = warrantyStatusDAO.findById(warrantyStatusId).orElse(null);
            logger.info("Out of getWarrantyStatusService");
            return warrantyStatusMaster;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<WarrantyStatusMaster> getAllWarrantyStatusService() {
        List<WarrantyStatusMaster> allWarrantyStatuses = new ArrayList<>();
        try {
            logger.info("In getAllWarrantyStatusService");
            allWarrantyStatuses = (List<WarrantyStatusMaster>) warrantyStatusDAO.findAll();
            logger.info("Out of getAllWarrantyStatusService");
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
        }
        return allWarrantyStatuses;
    }
}
