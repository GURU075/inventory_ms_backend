package IMS.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import IMS.Master.CategoryPropertiesMaster;

public interface CategoryPropertiesDAO extends CrudRepository<CategoryPropertiesMaster, Integer> {

	List<CategoryPropertiesMaster> findByCategory_CategoryId(Integer categoryId);

}
