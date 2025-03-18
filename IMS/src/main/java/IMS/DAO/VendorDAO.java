package IMS.DAO;

import org.springframework.data.repository.CrudRepository;

import IMS.Master.VendorMaster;

public interface VendorDAO extends CrudRepository<VendorMaster, Integer> {

}
