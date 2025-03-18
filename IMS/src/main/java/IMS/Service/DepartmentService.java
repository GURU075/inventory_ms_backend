package IMS.Service;

import java.util.List;

import IMS.Master.DepartmentMaster;

public interface DepartmentService {

    public Boolean addDepartmentService(DepartmentMaster departmentMaster);
    public Boolean updateDepartmentService(DepartmentMaster departmentMaster);
    public Boolean deleteDepartmentService(DepartmentMaster departmentMaster);
    public DepartmentMaster getDepartmentService(Integer deptId);
    public List<DepartmentMaster> getAllDepartmentService();
    
}