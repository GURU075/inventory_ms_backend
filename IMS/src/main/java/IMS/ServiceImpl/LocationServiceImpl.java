package IMS.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IMS.DAO.LocationDAO;
import IMS.DAO.LocationHistoryDAO;
import IMS.Master.LocationHistoryMaster;
import IMS.Master.LocationMaster;
import IMS.Service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

    private static final Logger logger = LogManager.getLogger(LocationServiceImpl.class);

    @Autowired
    private LocationDAO locationDAO;

    @Autowired
    private LocationHistoryDAO locationHistoryDAO;

    @Override
    public Boolean addLocationService(LocationMaster locationMaster) {
        try {
            logger.info("In addLocationService");
            locationDAO.save(locationMaster);

            LocationHistoryMaster oldLocation = new LocationHistoryMaster();
            oldLocation.setLocationId(locationMaster.getLocationId());
            oldLocation.setLocationName(locationMaster.getLocationName());
            oldLocation.setLocationDesc(locationMaster.getLocationDesc());
            oldLocation.setAction("Create");
            oldLocation.setTimestamp(LocalDateTime.now());

            locationHistoryDAO.save(oldLocation);
            logger.info("Out of addLocationService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean updateLocationService(LocationMaster locationMaster) {
        try {
            logger.info("In updateLocationService");
            LocationMaster location = locationDAO.findById(locationMaster.getLocationId()).orElseThrow(() -> new RuntimeException("Location not found"));

            LocationHistoryMaster oldLocation = new LocationHistoryMaster();
            oldLocation.setLocationId(location.getLocationId());
            oldLocation.setLocationName(location.getLocationName());
            oldLocation.setLocationDesc(location.getLocationDesc());
            oldLocation.setAction("Update");
            oldLocation.setTimestamp(LocalDateTime.now());

            location.setLocationName(locationMaster.getLocationName());
            location.setLocationDesc(locationMaster.getLocationDesc());
            location = locationDAO.save(location);

            locationHistoryDAO.save(oldLocation);
            logger.info("Out of updateLocationService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean deleteLocationService(LocationMaster locationMaster) {
        try {
            logger.info("In deleteLocationService");
            LocationMaster location = locationDAO.findById(locationMaster.getLocationId()).orElseThrow(() -> new RuntimeException("Location not found"));

            LocationHistoryMaster oldLocation = new LocationHistoryMaster();
            oldLocation.setLocationId(location.getLocationId());
            oldLocation.setLocationName(location.getLocationName());
            oldLocation.setLocationDesc(location.getLocationDesc());
            oldLocation.setAction("Delete");
            oldLocation.setTimestamp(LocalDateTime.now());

            locationDAO.delete(location);

            locationHistoryDAO.save(oldLocation);
            logger.info("Out of deleteLocationService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public LocationMaster getLocationService(Integer locationId) {
        try {
            logger.info("In getLocationService");
            LocationMaster locationMaster = locationDAO.findById(locationId).orElse(null);
            logger.info("Out of getLocationService");
            return locationMaster;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<LocationMaster> getAllLocationService() {
        List<LocationMaster> allLocations = new ArrayList<>();
        try {
            logger.info("In getAllLocationService");
            allLocations = (List<LocationMaster>) locationDAO.findAll();
            logger.info("Out of getAllLocationService");
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
        }
        return allLocations;
    }
    
    @Override 
    public LocationMaster getLocationByName(String locationName) { 
    	return locationDAO.findByLocationName(locationName); 
    	}
}
