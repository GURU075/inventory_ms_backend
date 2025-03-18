package IMS.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IMS.DAO.RAMDAO;
import IMS.DAO.RAMHistoryDAO;
import IMS.Master.RAMHistoryMaster;
import IMS.Master.RAMMaster;
import IMS.Service.RAMService;

@Service
public class RAMServiceImpl implements RAMService {

    private static final Logger logger = LogManager.getLogger(RAMServiceImpl.class);

    @Autowired
    private RAMDAO ramDAO;

    @Autowired
    private RAMHistoryDAO ramHistoryDAO;

    @Override
    public Boolean addRAMService(RAMMaster ramMaster) {
        try {
            logger.info("In addRAMService");
            ramDAO.save(ramMaster);

            RAMHistoryMaster oldRAM = new RAMHistoryMaster();
            oldRAM.setRamId(ramMaster.getRamId());
            oldRAM.setRamName(ramMaster.getRamName());
            oldRAM.setRamDesc(ramMaster.getRamDesc());
            oldRAM.setAction("Create");
            oldRAM.setTimestamp(LocalDateTime.now());

            ramHistoryDAO.save(oldRAM);
            logger.info("Out of addRAMService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean updateRAMService(RAMMaster ramMaster) {
        try {
            logger.info("In updateRAMService");
            RAMMaster ram = ramDAO.findById(ramMaster.getRamId()).orElseThrow(() -> new RuntimeException("RAM not found"));

            RAMHistoryMaster oldRAM = new RAMHistoryMaster();
            oldRAM.setRamId(ram.getRamId());
            oldRAM.setRamName(ram.getRamName());
            oldRAM.setRamDesc(ram.getRamDesc());
            oldRAM.setAction("Update");
            oldRAM.setTimestamp(LocalDateTime.now());

            ram.setRamName(ramMaster.getRamName());
            ram.setRamDesc(ramMaster.getRamDesc());
            ram = ramDAO.save(ram);

            ramHistoryDAO.save(oldRAM);
            logger.info("Out of updateRAMService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean deleteRAMService(RAMMaster ramMaster) {
        try {
            logger.info("In deleteRAMService");
            RAMMaster ram = ramDAO.findById(ramMaster.getRamId()).orElseThrow(() -> new RuntimeException("RAM not found"));

            RAMHistoryMaster oldRAM = new RAMHistoryMaster();
            oldRAM.setRamId(ram.getRamId());
            oldRAM.setRamName(ram.getRamName());
            oldRAM.setRamDesc(ram.getRamDesc());
            oldRAM.setAction("Delete");
            oldRAM.setTimestamp(LocalDateTime.now());

            ramDAO.delete(ram);

            ramHistoryDAO.save(oldRAM);
            logger.info("Out of deleteRAMService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public RAMMaster getRAMService(Integer ramId) {
        try {
            logger.info("In getRAMService");
            RAMMaster ramMaster = ramDAO.findById(ramId).orElse(null);
            logger.info("Out of getRAMService");
            return ramMaster;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<RAMMaster> getAllRAMService() {
        List<RAMMaster> allRAMs = new ArrayList<>();
        try {
            logger.info("In getAllRAMService");
            allRAMs = (List<RAMMaster>) ramDAO.findAll();
            logger.info("Out of getAllRAMService");
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
        }
        return allRAMs;
    }
}
