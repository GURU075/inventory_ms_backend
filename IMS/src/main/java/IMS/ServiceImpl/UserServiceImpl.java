package IMS.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IMS.DAO.DepartmentDAO;
import IMS.DAO.RoleDAO;
import IMS.DAO.UserDAO;
import IMS.DAO.UserHistoryDAO;
import IMS.Master.DepartmentMaster;
import IMS.Master.RoleMaster;
import IMS.Master.UserHistoryMaster;
import IMS.Master.UserMaster;
import IMS.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserHistoryDAO userHistoryDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private DepartmentDAO departmentDAO;

    @Override
    public Boolean addUserService(UserMaster userMaster) {
        try {
            logger.info("In addUserService");
            RoleMaster role = roleDAO.findByRoleName(userMaster.getRole().getRoleName());
            DepartmentMaster department = departmentDAO.findById(userMaster.getDepartment().getDeptId()).orElseThrow(() -> new RuntimeException("Department not found"));
            userMaster.setRole(role);
            userMaster.setDepartment(department);
            userDAO.save(userMaster);

            UserHistoryMaster oldUser = new UserHistoryMaster();
            oldUser.setUserId(userMaster.getUserId());
            oldUser.setUserFirstName(userMaster.getUserFirstName());
            oldUser.setUserMiddleName(userMaster.getUserMiddleName());
            oldUser.setUserLastName(userMaster.getUserLastName());
            oldUser.setUserLoginName(userMaster.getUserLoginName());
            oldUser.setUserEmail(userMaster.getUserEmail());
            oldUser.setUserAddress(userMaster.getUserAddress());
            oldUser.setUserMobile(userMaster.getUserMobile());
            oldUser.setUserGender(userMaster.getUserGender());
            oldUser.setUserStatus(userMaster.getUserStatus());
            oldUser.setUserDateOfBirth(userMaster.getUserDateOfBirth());
            oldUser.setUserCity(userMaster.getUserCity());
            oldUser.setUserState(userMaster.getUserState());
            oldUser.setUserCountry(userMaster.getUserCountry());
            oldUser.setRoleId(userMaster.getRole().getRoleId());
            oldUser.setDepartmentId(userMaster.getDepartment().getDeptId());
            oldUser.setAction("Create");
            oldUser.setTimestamp(LocalDateTime.now());

            userHistoryDAO.save(oldUser);
            logger.info("Out of addUserService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean updateUserService(UserMaster userMaster) {
        try {
            logger.info("In updateUserService");
            UserMaster user = userDAO.findById(userMaster.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));

            UserHistoryMaster oldUser = new UserHistoryMaster();
            oldUser.setUserId(user.getUserId());
            oldUser.setUserFirstName(user.getUserFirstName());
            oldUser.setUserMiddleName(user.getUserMiddleName());
            oldUser.setUserLastName(user.getUserLastName());
            oldUser.setUserLoginName(user.getUserLoginName());
            oldUser.setUserEmail(user.getUserEmail());
            oldUser.setUserAddress(user.getUserAddress());
            oldUser.setUserMobile(user.getUserMobile());
            oldUser.setUserGender(user.getUserGender());
            oldUser.setUserStatus(user.getUserStatus());
            oldUser.setUserDateOfBirth(userMaster.getUserDateOfBirth());
            oldUser.setUserCity(userMaster.getUserCity());
            oldUser.setUserState(userMaster.getUserState());
            oldUser.setUserCountry(userMaster.getUserCountry());
            oldUser.setRoleId(user.getRole().getRoleId());
            oldUser.setDepartmentId(user.getDepartment().getDeptId());
            oldUser.setAction("Update");
            oldUser.setTimestamp(LocalDateTime.now());

            RoleMaster role = roleDAO.findByRoleName(userMaster.getRole().getRoleName());
            DepartmentMaster department = departmentDAO.findById(userMaster.getDepartment().getDeptId()).orElseThrow(() -> new RuntimeException("Department not found"));
            user.setRole(role);
            user.setDepartment(department);
            user.setUserFirstName(userMaster.getUserFirstName());
            user.setUserMiddleName(userMaster.getUserMiddleName());
            user.setUserLastName(userMaster.getUserLastName());
            user.setUserLoginName(userMaster.getUserLoginName());
            user.setUserEmail(userMaster.getUserEmail());
            user.setUserAddress(userMaster.getUserAddress());
            user.setUserMobile(userMaster.getUserMobile());
            user.setUserGender(userMaster.getUserGender());
            user.setUserStatus(userMaster.getUserStatus());
            oldUser.setUserDateOfBirth(userMaster.getUserDateOfBirth());
            oldUser.setUserCity(userMaster.getUserCity());
            oldUser.setUserState(userMaster.getUserState());
            oldUser.setUserCountry(userMaster.getUserCountry());
            userDAO.save(user);

            userHistoryDAO.save(oldUser);
            logger.info("Out of updateUserService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean deleteUserService(UserMaster userMaster) {
        try {
            logger.info("In deleteUserService");
            UserMaster user = userDAO.findById(userMaster.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));

            UserHistoryMaster oldUser = new UserHistoryMaster();
            oldUser.setUserId(user.getUserId());
            oldUser.setUserFirstName(user.getUserFirstName());
            oldUser.setUserMiddleName(user.getUserMiddleName());
            oldUser.setUserLastName(user.getUserLastName());
            oldUser.setUserLoginName(user.getUserLoginName());
            oldUser.setUserEmail(user.getUserEmail());
            oldUser.setUserAddress(user.getUserAddress());
            oldUser.setUserMobile(user.getUserMobile());
            oldUser.setUserGender(user.getUserGender());
            oldUser.setUserStatus(user.getUserStatus());
            oldUser.setUserDateOfBirth(userMaster.getUserDateOfBirth());
            oldUser.setUserCity(userMaster.getUserCity());
            oldUser.setUserState(userMaster.getUserState());
            oldUser.setUserCountry(userMaster.getUserCountry());
            oldUser.setRoleId(user.getRole().getRoleId());
            oldUser.setDepartmentId(user.getDepartment().getDeptId());
            oldUser.setAction("Delete");
            oldUser.setTimestamp(LocalDateTime.now());

            userDAO.delete(user);

            userHistoryDAO.save(oldUser);
            logger.info("Out of deleteUserService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public UserMaster getUserService(Integer userId) {
        try {
            logger.info("In getUserService");
            UserMaster userMaster = userDAO.findById(userId).orElse(null);
            logger.info("Out of getUserService");
            return userMaster;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<UserMaster> getAllUserService() {
        List<UserMaster> allUsers = new ArrayList<>();
        try {
            logger.info("In getAllUserService");
            allUsers = (List<UserMaster>) userDAO.findAll();
            logger.info("Out of getAllUserService");
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
        }
        return allUsers;
    }
    
//    @Override 
//    public List<UserMaster> getUserByDepartmentId(Integer departmentId) { 
//    	return userDAO.findByUserUsingDepartmentId(departmentId); 
//    	}
}
