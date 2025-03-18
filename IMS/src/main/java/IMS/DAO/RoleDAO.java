package IMS.DAO;

import org.springframework.data.repository.CrudRepository;

import IMS.Master.RoleMaster;

public interface RoleDAO extends CrudRepository<RoleMaster, Integer> {

	RoleMaster findByRoleName(String roleName);
}
