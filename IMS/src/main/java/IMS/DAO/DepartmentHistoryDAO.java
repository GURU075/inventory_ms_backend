package IMS.DAO;

import org.springframework.data.repository.CrudRepository;

import IMS.Master.DepartmentHistoryMaster;

public interface DepartmentHistoryDAO extends CrudRepository<DepartmentHistoryMaster, Integer> {

}
