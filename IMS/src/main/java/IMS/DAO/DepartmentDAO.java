package IMS.DAO;

import org.springframework.data.repository.CrudRepository;

import IMS.Master.DepartmentMaster;

public interface DepartmentDAO extends CrudRepository<DepartmentMaster, Integer> {

}
