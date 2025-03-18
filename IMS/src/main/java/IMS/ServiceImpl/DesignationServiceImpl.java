package IMS.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IMS.DAO.DesignationDAO;
import IMS.DAO.DesignationHistoryDAO;
import IMS.Master.DesignationHistoryMaster;
import IMS.Master.DesignationMaster;
import IMS.Service.DesignationService;

@Service
public class DesignationServiceImpl implements DesignationService {

	 private static final Logger logger = LogManager.getLogger(RoleServiceImpl.class);
	
	@Autowired
	private DesignationDAO designationDAO;
	
	@Autowired
	private DesignationHistoryDAO designationHistoryDAO;
	
	@Override
	public Boolean addDesignationService(DesignationMaster designationMaster) {
		try {
            logger.info("In addRoleService");
            designationDAO.save(designationMaster);
            
            DesignationHistoryMaster oldDesignation = new DesignationHistoryMaster();
            oldDesignation.setDesignationId(designationMaster.getDesignationId());
            oldDesignation.setDesignationName(designationMaster.getDesignationName());
            oldDesignation.setDesignationDesc(designationMaster.getDesignationDesc());
            oldDesignation.setAction("Create");
            oldDesignation.setTimestamp(LocalDateTime.now());
            
            designationHistoryDAO.save(oldDesignation);
            logger.info("Out of addDesignationService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
	}

	@Override
	public Boolean updateDesignationService(DesignationMaster designationMaster) {
		try {
            logger.info("In updateRoleService");
            DesignationMaster designation = designationDAO.findById(designationMaster.getDesignationId()).orElseThrow(() -> new RuntimeException("Designation not found")); 
            
            DesignationHistoryMaster oldDesignation = new DesignationHistoryMaster();
            oldDesignation.setDesignationId(designation.getDesignationId());
            oldDesignation.setDesignationName(designation.getDesignationName());
            oldDesignation.setDesignationDesc(designation.getDesignationDesc());
            oldDesignation.setAction("Update");
            oldDesignation.setTimestamp(LocalDateTime.now());
            
            designation.setDesignationName(designationMaster.getDesignationName()); 
            designation.setDesignationDesc(designationMaster.getDesignationDesc()); 
            designation = designationDAO.save(designation);
            
            designationHistoryDAO.save(oldDesignation); 
            logger.info("Out of updateDesignationService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
	}

	@Override
	public Boolean deleteDesignationService(DesignationMaster designationMaster) {
		try {
            logger.info("In updateRoleService");
            DesignationMaster designation = designationDAO.findById(designationMaster.getDesignationId()).orElseThrow(() -> new RuntimeException("Designation not found")); 
            
            DesignationHistoryMaster oldDesignation = new DesignationHistoryMaster();
            oldDesignation.setDesignationId(designation.getDesignationId());
            oldDesignation.setDesignationName(designation.getDesignationName());
            oldDesignation.setDesignationDesc(designation.getDesignationDesc());
            oldDesignation.setAction("Delete");
            oldDesignation.setTimestamp(LocalDateTime.now());
            
            designation.setDesignationName(designationMaster.getDesignationName()); 
            designation.setDesignationDesc(designationMaster.getDesignationDesc()); 
            
            designationDAO.delete(designation);
            
            designationHistoryDAO.save(oldDesignation); 
            logger.info("Out of deleteDesignationService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
	}

	@Override
	public DesignationMaster getDesignationService(Integer designationId) {
		try {
            logger.info("In getDesignationService");
            DesignationMaster designationMaster = designationDAO.findById(designationId).orElse(null);
            logger.info("Out of getDesignationService");
            return designationMaster;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return null;
        }
	}

	@Override
	public List<DesignationMaster> getAllDesignationService() {
		 List<DesignationMaster> allDesignations = new ArrayList<>();
	        try {
	            logger.info("In getAllDesignationService");
	            allDesignations = (List<DesignationMaster>) designationDAO.findAll();
	            logger.info("Out of getAllDesignationService");
	        } catch (Exception e) {
	            logger.error("IMS: " + e.getMessage(), e);
	        }
	        return allDesignations;
	    }
}
