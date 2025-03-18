package IMS.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IMS.DAO.RoleDAO;
import IMS.DAO.RoleHistoryDAO;
import IMS.Master.RoleHistoryMaster;
import IMS.Master.RoleMaster;
import IMS.Service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    private static final Logger logger = LogManager.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleDAO roleDAO;
    
    @Autowired
    private RoleHistoryDAO rolehistoryDAO;

    @Override
    public Boolean addRoleService(RoleMaster roleMaster) {
        try {
            logger.info("In addRoleService");
            roleDAO.save(roleMaster);
            
            RoleHistoryMaster oldRole = new RoleHistoryMaster();
            oldRole.setRoleId(roleMaster.getRoleId());
            oldRole.setRoleName(roleMaster.getRoleName());
            oldRole.setRoleDesc(roleMaster.getRoleDesc());
            oldRole.setCanAdd(roleMaster.getCanAdd());
            oldRole.setCanEdit(roleMaster.getCanEdit());
            oldRole.setCanDelete(roleMaster.getCanDelete());
            oldRole.setCanView(roleMaster.getCanView());
            oldRole.setAction("Create");
            oldRole.setTimestamp(LocalDateTime.now());
            
            rolehistoryDAO.save(oldRole);
            logger.info("Out of addRoleService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean updateRoleService(RoleMaster roleMaster) {
        try {
            logger.info("In updateRoleService");
            RoleMaster role = roleDAO.findById(roleMaster.getRoleId()).orElseThrow(() -> new RuntimeException("Role not found")); 
            
            RoleHistoryMaster oldRole = new RoleHistoryMaster();
            oldRole.setRoleId(role.getRoleId());
            oldRole.setRoleName(role.getRoleName());
            oldRole.setRoleDesc(role.getRoleDesc());
            oldRole.setCanAdd(role.getCanAdd());
            oldRole.setCanEdit(role.getCanEdit());
            oldRole.setCanDelete(role.getCanDelete());
            oldRole.setCanView(role.getCanView());
            oldRole.setAction("Update");
            oldRole.setTimestamp(LocalDateTime.now());
            //
            role.setRoleName(roleMaster.getRoleName()); 
            role.setRoleDesc(roleMaster.getRoleDesc()); 
            role.setCanAdd(roleMaster.getCanAdd());
            role.setCanEdit(roleMaster.getCanEdit());
            role.setCanDelete(roleMaster.getCanDelete());
            role.setCanView(roleMaster.getCanView());
            role = roleDAO.save(role);
            
            rolehistoryDAO.save(oldRole); 
            logger.info("Out of updateRoleService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean deleteRoleService(RoleMaster roleMaster) {
        try {
            logger.info("In deleteRoleService");
            RoleMaster role = roleDAO.findById(roleMaster.getRoleId()).orElseThrow(() -> new RuntimeException("Role not found")); 
            
            RoleHistoryMaster oldRole = new RoleHistoryMaster();
            oldRole.setRoleId(role.getRoleId());
            oldRole.setRoleName(role.getRoleName());
            oldRole.setRoleDesc(role.getRoleDesc());
            oldRole.setCanAdd(roleMaster.getCanAdd());
            oldRole.setCanEdit(roleMaster.getCanEdit());
            oldRole.setCanDelete(roleMaster.getCanDelete());
            oldRole.setCanView(roleMaster.getCanView());
            oldRole.setAction("Delete");
            oldRole.setTimestamp(LocalDateTime.now());
            
            roleDAO.delete(role); 
            
            rolehistoryDAO.save(oldRole);
            logger.info("Out of deleteRoleService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public RoleMaster getRoleService(Integer roleId) {
        try {
            logger.info("In getRoleService");
            RoleMaster roleMaster = roleDAO.findById(roleId).orElse(null);
            logger.info("Out of getRoleService");
            return roleMaster;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<RoleMaster> getAllRoleService() {
        List<RoleMaster> allRoles = new ArrayList<>();
        try {
            logger.info("In getAllRoleService");
            allRoles = (List<RoleMaster>) roleDAO.findAll();
            logger.info("Out of getAllRoleService");
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
        }
        return allRoles;
    }
    
    @Override 
    public RoleMaster getRoleByName(String roleName) { 
    	return roleDAO.findByRoleName(roleName); 
    	}
}
