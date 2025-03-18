package IMS.DAO;

import org.springframework.data.repository.CrudRepository;

import IMS.Master.AssetStatusHistoryMaster;

public interface AssetStatusHistoryDAO extends CrudRepository<AssetStatusHistoryMaster, Integer> {

}
