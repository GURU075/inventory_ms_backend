package IMS.DAO;

import org.springframework.data.repository.CrudRepository;

import IMS.Master.RoleHistoryMaster;

public interface RoleHistoryDAO extends CrudRepository<RoleHistoryMaster, Integer> {

}
