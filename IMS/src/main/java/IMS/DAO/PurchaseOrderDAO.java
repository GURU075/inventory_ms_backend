package IMS.DAO;

import org.springframework.data.repository.CrudRepository;

import IMS.Master.PurchaseOrderMaster;

public interface PurchaseOrderDAO extends CrudRepository<PurchaseOrderMaster, Integer> {

}
