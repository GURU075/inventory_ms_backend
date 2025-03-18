package IMS.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IMS.DAO.FloorDAO;
import IMS.DAO.FloorHistoryDAO;
import IMS.Master.FloorHistoryMaster;
import IMS.Master.FloorMaster;
import IMS.Service.FloorService;

@Service
public class FloorServiceImpl implements FloorService {

    private static final Logger logger = LogManager.getLogger(FloorServiceImpl.class);

    @Autowired
    private FloorDAO floorDAO;

    @Autowired
    private FloorHistoryDAO floorHistoryDAO;

    @Override
    public Boolean addFloorService(FloorMaster floorMaster) {
        try {
            logger.info("In addFloorService");
            floorDAO.save(floorMaster);

            FloorHistoryMaster oldFloor = new FloorHistoryMaster();
            oldFloor.setFloorId(floorMaster.getFloorId());
            oldFloor.setFloorName(floorMaster.getFloorName());
            oldFloor.setFloorDesc(floorMaster.getFloorDesc());
            oldFloor.setAction("Create");
            oldFloor.setTimestamp(LocalDateTime.now());

            floorHistoryDAO.save(oldFloor);
            logger.info("Out of addFloorService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean updateFloorService(FloorMaster floorMaster) {
        try {
            logger.info("In updateFloorService");
            FloorMaster floor = floorDAO.findById(floorMaster.getFloorId()).orElseThrow(() -> new RuntimeException("Floor not found"));

            FloorHistoryMaster oldFloor = new FloorHistoryMaster();
            oldFloor.setFloorId(floor.getFloorId());
            oldFloor.setFloorName(floor.getFloorName());
            oldFloor.setFloorDesc(floor.getFloorDesc());
            oldFloor.setAction("Update");
            oldFloor.setTimestamp(LocalDateTime.now());

            floor.setFloorName(floorMaster.getFloorName());
            floor.setFloorDesc(floorMaster.getFloorDesc());
            floor = floorDAO.save(floor);

            floorHistoryDAO.save(oldFloor);
            logger.info("Out of updateFloorService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean deleteFloorService(FloorMaster floorMaster) {
        try {
            logger.info("In deleteFloorService");
            FloorMaster floor = floorDAO.findById(floorMaster.getFloorId()).orElseThrow(() -> new RuntimeException("Floor not found"));

            FloorHistoryMaster oldFloor = new FloorHistoryMaster();
            oldFloor.setFloorId(floor.getFloorId());
            oldFloor.setFloorName(floor.getFloorName());
            oldFloor.setFloorDesc(floor.getFloorDesc());
            oldFloor.setAction("Delete");
            oldFloor.setTimestamp(LocalDateTime.now());

            floorDAO.delete(floor);

            floorHistoryDAO.save(oldFloor);
            logger.info("Out of deleteFloorService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public FloorMaster getFloorService(Integer floorId) {
        try {
            logger.info("In getFloorService");
            FloorMaster floorMaster = floorDAO.findById(floorId).orElse(null);
            logger.info("Out of getFloorService");
            return floorMaster;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<FloorMaster> getAllFloorService() {
        List<FloorMaster> allFloors = new ArrayList<>();
        try {
            logger.info("In getAllFloorService");
            allFloors = (List<FloorMaster>) floorDAO.findAll();
            logger.info("Out of getAllFloorService");
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
        }
        return allFloors;
    }
}
