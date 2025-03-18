package IMS.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IMS.DAO.HardDiskDAO;
import IMS.DAO.HardDiskHistoryDAO;
import IMS.Master.HardDiskHistoryMaster;
import IMS.Master.HardDiskMaster;
import IMS.Service.HardDiskService;

@Service
public class HardDiskServiceImpl implements HardDiskService {

    private static final Logger logger = LogManager.getLogger(HardDiskServiceImpl.class);

    @Autowired
    private HardDiskDAO hardDiskDAO;

    @Autowired
    private HardDiskHistoryDAO hardDiskHistoryDAO;

    @Override
    public Boolean addHardDiskService(HardDiskMaster hardDiskMaster) {
        try {
            logger.info("In addHardDiskService");
            hardDiskDAO.save(hardDiskMaster);

            HardDiskHistoryMaster oldHardDisk = new HardDiskHistoryMaster();
            oldHardDisk.setHardDiskId(hardDiskMaster.getHardDiskId());
            oldHardDisk.setHardDiskName(hardDiskMaster.getHardDiskName());
            oldHardDisk.setHardDiskDesc(hardDiskMaster.getHardDiskDesc());
            oldHardDisk.setAction("Create");
            oldHardDisk.setTimestamp(LocalDateTime.now());

            hardDiskHistoryDAO.save(oldHardDisk);
            logger.info("Out of addHardDiskService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean updateHardDiskService(HardDiskMaster hardDiskMaster) {
        try {
            logger.info("In updateHardDiskService");
            HardDiskMaster hardDisk = hardDiskDAO.findById(hardDiskMaster.getHardDiskId()).orElseThrow(() -> new RuntimeException("Hard Disk not found"));

            HardDiskHistoryMaster oldHardDisk = new HardDiskHistoryMaster();
            oldHardDisk.setHardDiskId(hardDisk.getHardDiskId());
            oldHardDisk.setHardDiskName(hardDisk.getHardDiskName());
            oldHardDisk.setHardDiskDesc(hardDisk.getHardDiskDesc());
            oldHardDisk.setAction("Update");
            oldHardDisk.setTimestamp(LocalDateTime.now());

            hardDisk.setHardDiskName(hardDiskMaster.getHardDiskName());
            hardDisk.setHardDiskDesc(hardDiskMaster.getHardDiskDesc());
            hardDisk = hardDiskDAO.save(hardDisk);

            hardDiskHistoryDAO.save(oldHardDisk);
            logger.info("Out of updateHardDiskService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean deleteHardDiskService(HardDiskMaster hardDiskMaster) {
        try {
            logger.info("In deleteHardDiskService");
            HardDiskMaster hardDisk = hardDiskDAO.findById(hardDiskMaster.getHardDiskId()).orElseThrow(() -> new RuntimeException("Hard Disk not found"));

            HardDiskHistoryMaster oldHardDisk = new HardDiskHistoryMaster();
            oldHardDisk.setHardDiskId(hardDisk.getHardDiskId());
            oldHardDisk.setHardDiskName(hardDisk.getHardDiskName());
            oldHardDisk.setHardDiskDesc(hardDisk.getHardDiskDesc());
            oldHardDisk.setAction("Delete");
            oldHardDisk.setTimestamp(LocalDateTime.now());

            hardDiskDAO.delete(hardDisk);

            hardDiskHistoryDAO.save(oldHardDisk);
            logger.info("Out of deleteHardDiskService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public HardDiskMaster getHardDiskService(Integer hardDiskId) {
        try {
            logger.info("In getHardDiskService");
            HardDiskMaster hardDiskMaster = hardDiskDAO.findById(hardDiskId).orElse(null);
            logger.info("Out of getHardDiskService");
            return hardDiskMaster;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<HardDiskMaster> getAllHardDiskService() {
        List<HardDiskMaster> allHardDisks = new ArrayList<>();
        try {
            logger.info("In getAllHardDiskService");
            allHardDisks = (List<HardDiskMaster>) hardDiskDAO.findAll();
            logger.info("Out of getAllHardDiskService");
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
        }
        return allHardDisks;
    }
}
