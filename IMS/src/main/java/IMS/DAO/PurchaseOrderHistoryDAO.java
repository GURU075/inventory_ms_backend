package IMS.DAO;

import org.springframework.data.repository.CrudRepository;

import IMS.Master.PurchaseOrderHistoryMaster;

public interface PurchaseOrderHistoryDAO extends CrudRepository<PurchaseOrderHistoryMaster, Integer> {

}
