package IMS.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import IMS.Master.UserMaster;

@Repository

public interface UserDAO extends CrudRepository<UserMaster, Integer> {

	//List<UserMaster> findByUserUsingDepartmentId(Integer department);
}