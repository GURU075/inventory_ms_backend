package IMS.DAO;

import org.springframework.data.repository.CrudRepository;

import IMS.Master.LocationMaster;

public interface LocationDAO extends CrudRepository<LocationMaster, Integer> {

	LocationMaster findByLocationName(String locationName);
}
