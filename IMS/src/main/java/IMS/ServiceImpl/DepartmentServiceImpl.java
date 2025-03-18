package IMS.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IMS.DAO.DepartmentDAO;
import IMS.DAO.DepartmentHistoryDAO;
import IMS.DAO.FloorDAO;
import IMS.DAO.LocationDAO;
import IMS.Master.DepartmentHistoryMaster;
import IMS.Master.DepartmentMaster;
import IMS.Master.FloorMaster;
import IMS.Master.LocationMaster;
import IMS.Service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private static final Logger logger = LogManager.getLogger(DepartmentServiceImpl.class);

    @Autowired
    private DepartmentDAO departmentDAO;

    @Autowired
    private DepartmentHistoryDAO departmentHistoryDAO;
    
    @Autowired
    private LocationDAO locationDAO;
    
    @Autowired
    private FloorDAO floorDAO; 

    @Override
    public Boolean addDepartmentService(DepartmentMaster departmentMaster) {
        try {
            logger.info("In addDepartmentService");
            LocationMaster location = locationDAO.findByLocationName(departmentMaster.getLocation().getLocationName());
            FloorMaster floor = floorDAO.findById(departmentMaster.getFloor().getFloorId()).orElseThrow(() -> new RuntimeException("MIC not found")); 
            departmentMaster.setFloor(floor); 
            departmentMaster.setLocation(location);
            departmentDAO.save(departmentMaster);

            DepartmentHistoryMaster oldDepartment = new DepartmentHistoryMaster();
            oldDepartment.setDeptId(departmentMaster.getDeptId());
            oldDepartment.setDeptName(departmentMaster.getDeptName());
            oldDepartment.setDeptDesc(departmentMaster.getDeptDesc());
            oldDepartment.setDeptContactPersonName(departmentMaster.getDeptContactPersonName());
            oldDepartment.setDeptContactPersonMobile(departmentMaster.getDeptContactPersonMobile());
            oldDepartment.setDeptContactPersonEmail(departmentMaster.getDeptContactPersonEmail());
            oldDepartment.setLocationId(departmentMaster.getLocation().getLocationId());
            oldDepartment.setFloorId(departmentMaster.getFloor().getFloorId());
            oldDepartment.setAction("Create");
            oldDepartment.setTimestamp(LocalDateTime.now());

            departmentHistoryDAO.save(oldDepartment);
            logger.info("Out of addDepartmentService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean updateDepartmentService(DepartmentMaster departmentMaster) {
        try {
            logger.info("In updateDepartmentService");
            DepartmentMaster department = departmentDAO.findById(departmentMaster.getDeptId()).orElseThrow(() -> new RuntimeException("Department not found"));

            DepartmentHistoryMaster oldDepartment = new DepartmentHistoryMaster();
            oldDepartment.setDeptId(department.getDeptId());
            oldDepartment.setDeptName(department.getDeptName());
            oldDepartment.setDeptDesc(department.getDeptDesc());
            oldDepartment.setDeptContactPersonName(departmentMaster.getDeptContactPersonName());
            oldDepartment.setDeptContactPersonMobile(departmentMaster.getDeptContactPersonMobile());
            oldDepartment.setDeptContactPersonEmail(departmentMaster.getDeptContactPersonEmail());
            oldDepartment.setLocationId(department.getLocation().getLocationId());
            oldDepartment.setFloorId(departmentMaster.getFloor().getFloorId());
            oldDepartment.setAction("Update");
            oldDepartment.setTimestamp(LocalDateTime.now());

            LocationMaster location = locationDAO.findByLocationName(departmentMaster.getLocation().getLocationName());
            department.setLocation(location);
            FloorMaster floor = floorDAO.findById(departmentMaster.getFloor().getFloorId()).orElseThrow(() -> new RuntimeException("MIC not found")); 
            departmentMaster.setFloor(floor); 
            department.setDeptName(departmentMaster.getDeptName());
            department.setDeptDesc(departmentMaster.getDeptDesc());
            department.setDeptContactPersonName(departmentMaster.getDeptContactPersonName());
            department.setDeptContactPersonMobile(departmentMaster.getDeptContactPersonMobile());
            department.setDeptContactPersonEmail(departmentMaster.getDeptContactPersonEmail());
            department = departmentDAO.save(department);

            departmentHistoryDAO.save(oldDepartment);
            logger.info("Out of updateDepartmentService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean deleteDepartmentService(DepartmentMaster departmentMaster) {
        try {
            logger.info("In deleteDepartmentService");
            DepartmentMaster department = departmentDAO.findById(departmentMaster.getDeptId()).orElseThrow(() -> new RuntimeException("Department not found"));

            DepartmentHistoryMaster oldDepartment = new DepartmentHistoryMaster();
            oldDepartment.setDeptId(department.getDeptId());
            oldDepartment.setDeptName(department.getDeptName());
            oldDepartment.setDeptDesc(department.getDeptDesc());
            oldDepartment.setDeptContactPersonName(departmentMaster.getDeptContactPersonName());
            oldDepartment.setDeptContactPersonMobile(departmentMaster.getDeptContactPersonMobile());
            oldDepartment.setDeptContactPersonEmail(departmentMaster.getDeptContactPersonEmail());
            oldDepartment.setLocationId(department.getLocation().getLocationId());
            oldDepartment.setFloorId(departmentMaster.getFloor().getFloorId());
            oldDepartment.setAction("Delete");
            oldDepartment.setTimestamp(LocalDateTime.now());

            departmentDAO.delete(department);

            departmentHistoryDAO.save(oldDepartment);
            logger.info("Out of deleteDepartmentService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public DepartmentMaster getDepartmentService(Integer deptId) {
        try {
            logger.info("In getDepartmentService");
            DepartmentMaster departmentMaster = departmentDAO.findById(deptId).orElse(null);
            logger.info("Out of getDepartmentService");
            return departmentMaster;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<DepartmentMaster> getAllDepartmentService() {
        List<DepartmentMaster> allDepartments = new ArrayList<>();
        try {
            logger.info("In getAllDepartmentService");
            allDepartments = (List<DepartmentMaster>) departmentDAO.findAll();
            logger.info("Out of getAllDepartmentService");
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
        }
        return allDepartments;
    }
  
}
