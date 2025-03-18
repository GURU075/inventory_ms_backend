package IMS.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IMS.DAO.MakeDAO;
import IMS.DAO.MakeHistoryDAO;
import IMS.Master.MakeHistoryMaster;
import IMS.Master.MakeMaster;
import IMS.Service.MakeService;

@Service
public class MakeServiceImpl implements MakeService {

    private static final Logger logger = LogManager.getLogger(MakeServiceImpl.class);

    @Autowired
    private MakeDAO makeDAO;

    @Autowired
    private MakeHistoryDAO makeHistoryDAO;

    @Override
    public Boolean addMakeService(MakeMaster makeMaster) {
        try {
            logger.info("In addMakeService");
            makeDAO.save(makeMaster);

            MakeHistoryMaster oldMake = new MakeHistoryMaster();
            oldMake.setMakeId(makeMaster.getMakeId());
            oldMake.setMakeName(makeMaster.getMakeName());
            oldMake.setMakeDesc(makeMaster.getMakeDesc());
            oldMake.setAction("Create");
            oldMake.setTimestamp(LocalDateTime.now());

            makeHistoryDAO.save(oldMake);
            logger.info("Out of addMakeService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean updateMakeService(MakeMaster makeMaster) {
        try {
            logger.info("In updateMakeService");
            MakeMaster make = makeDAO.findById(makeMaster.getMakeId()).orElseThrow(() -> new RuntimeException("Make not found"));

            MakeHistoryMaster oldMake = new MakeHistoryMaster();
            oldMake.setMakeId(make.getMakeId());
            oldMake.setMakeName(make.getMakeName());
            oldMake.setMakeDesc(make.getMakeDesc());
            oldMake.setAction("Update");
            oldMake.setTimestamp(LocalDateTime.now());

            make.setMakeName(makeMaster.getMakeName());
            make.setMakeDesc(makeMaster.getMakeDesc());
            make = makeDAO.save(make);

            makeHistoryDAO.save(oldMake);
            logger.info("Out of updateMakeService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean deleteMakeService(MakeMaster makeMaster) {
        try {
            logger.info("In deleteMakeService");
            MakeMaster make = makeDAO.findById(makeMaster.getMakeId()).orElseThrow(() -> new RuntimeException("Make not found"));

            MakeHistoryMaster oldMake = new MakeHistoryMaster();
            oldMake.setMakeId(make.getMakeId());
            oldMake.setMakeName(make.getMakeName());
            oldMake.setMakeDesc(make.getMakeDesc());
            oldMake.setAction("Delete");
            oldMake.setTimestamp(LocalDateTime.now());

            makeDAO.delete(make);

            makeHistoryDAO.save(oldMake);
            logger.info("Out of deleteMakeService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public MakeMaster getMakeService(Integer makeId) {
        try {
            logger.info("In getMakeService");
            MakeMaster makeMaster = makeDAO.findById(makeId).orElse(null);
            logger.info("Out of getMakeService");
            return makeMaster;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<MakeMaster> getAllMakeService() {
        List<MakeMaster> allMakes = new ArrayList<>();
        try {
            logger.info("In getAllMakeService");
            allMakes = (List<MakeMaster>) makeDAO.findAll();
            logger.info("Out of getAllMakeService");
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
        }
        return allMakes;
    }
}
