package IMS.DAO;

import org.springframework.data.repository.CrudRepository;

import IMS.Master.VendorHistoryMaster;

public interface VendorHistoryDAO extends CrudRepository<VendorHistoryMaster, Integer> {

}
