package IMS.DAO;

import org.springframework.data.repository.CrudRepository;

import IMS.Master.HardDiskHistoryMaster;

public interface HardDiskHistoryDAO extends CrudRepository<HardDiskHistoryMaster, Integer> {

}
