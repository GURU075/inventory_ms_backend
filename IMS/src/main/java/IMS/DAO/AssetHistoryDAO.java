package IMS.DAO;

import org.springframework.data.repository.CrudRepository;

import IMS.Master.AssetHistoryMaster;

public interface AssetHistoryDAO extends CrudRepository<AssetHistoryMaster, Integer> {

}
