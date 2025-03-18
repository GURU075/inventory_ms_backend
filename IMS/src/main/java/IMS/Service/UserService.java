package IMS.Service;

import java.util.List;

import IMS.Master.UserMaster;

public interface UserService {

    public Boolean addUserService(UserMaster userMaster);
    public Boolean updateUserService(UserMaster userMaster);
    public Boolean deleteUserService(UserMaster userMaster);
    public UserMaster getUserService(Integer userId);
    public List<UserMaster> getAllUserService();
    
   // List<UserMaster> getUserByDepartmentId(Integer departmentId);
}
