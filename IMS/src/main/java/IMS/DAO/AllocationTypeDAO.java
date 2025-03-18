package IMS.DAO;

import org.springframework.data.repository.CrudRepository;

import IMS.Master.AllocationTypeMaster;

public interface AllocationTypeDAO extends CrudRepository<AllocationTypeMaster, Integer> {

}
