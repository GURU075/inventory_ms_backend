package IMS.DAO;

import org.springframework.data.repository.CrudRepository;

import IMS.Master.ModelMaster;

public interface ModelDAO extends CrudRepository<ModelMaster, Integer> {

}
