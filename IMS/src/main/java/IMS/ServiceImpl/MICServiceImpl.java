package IMS.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IMS.DAO.MICDAO;
import IMS.DAO.MICHistoryDAO;
import IMS.Master.MICHistoryMaster;
import IMS.Master.MICMaster;
import IMS.Service.MICService;

@Service
public class MICServiceImpl implements MICService {

    private static final Logger logger = LogManager.getLogger(MICServiceImpl.class);

    @Autowired
    private MICDAO micDAO;

    @Autowired
    private MICHistoryDAO micHistoryDAO;

    @Override
    public Boolean addMICService(MICMaster micMaster) {
        try {
            logger.info("In addMICService");
            micDAO.save(micMaster);

            MICHistoryMaster oldMIC = new MICHistoryMaster();
            oldMIC.setMicId(micMaster.getMicId());
            oldMIC.setMicName(micMaster.getMicName());
            oldMIC.setMicDesc(micMaster.getMicDesc());
            oldMIC.setAction("Create");
            oldMIC.setTimestamp(LocalDateTime.now());

            micHistoryDAO.save(oldMIC);
            logger.info("Out of addMICService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean updateMICService(MICMaster micMaster) {
        try {
            logger.info("In updateMICService");
            MICMaster mic = micDAO.findById(micMaster.getMicId()).orElseThrow(() -> new RuntimeException("MIC not found"));

            MICHistoryMaster oldMIC = new MICHistoryMaster();
            oldMIC.setMicId(mic.getMicId());
            oldMIC.setMicName(mic.getMicName());
            oldMIC.setMicDesc(mic.getMicDesc());
            oldMIC.setAction("Update");
            oldMIC.setTimestamp(LocalDateTime.now());

            mic.setMicName(micMaster.getMicName());
            mic.setMicDesc(micMaster.getMicDesc());
            mic = micDAO.save(mic);

            micHistoryDAO.save(oldMIC);
            logger.info("Out of updateMICService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean deleteMICService(MICMaster micMaster) {
        try {
            logger.info("In deleteMICService");
            MICMaster mic = micDAO.findById(micMaster.getMicId()).orElseThrow(() -> new RuntimeException("MIC not found"));

            MICHistoryMaster oldMIC = new MICHistoryMaster();
            oldMIC.setMicId(mic.getMicId());
            oldMIC.setMicName(mic.getMicName());
            oldMIC.setMicDesc(mic.getMicDesc());
            oldMIC.setAction("Delete");
            oldMIC.setTimestamp(LocalDateTime.now());

            micDAO.delete(mic);

            micHistoryDAO.save(oldMIC);
            logger.info("Out of deleteMICService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public MICMaster getMICService(Integer micId) {
        try {
            logger.info("In getMICService");
            MICMaster micMaster = micDAO.findById(micId).orElse(null);
            logger.info("Out of getMICService");
            return micMaster;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<MICMaster> getAllMICService() {
        List<MICMaster> allMICs = new ArrayList<>();
        try {
            logger.info("In getAllMICService");
            allMICs = (List<MICMaster>) micDAO.findAll();
            logger.info("Out of getAllMICService");
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
        }
        return allMICs;
    }
}
