package IMS.DAO;

import org.springframework.data.repository.CrudRepository;

import IMS.Master.LocationHistoryMaster;

public interface LocationHistoryDAO extends CrudRepository<LocationHistoryMaster, Integer>{

}
