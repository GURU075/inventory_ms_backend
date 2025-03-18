package IMS.DAO;

import org.springframework.data.repository.CrudRepository;

import IMS.Master.UserHistoryMaster;

public interface UserHistoryDAO extends CrudRepository<UserHistoryMaster, Integer> {

}
