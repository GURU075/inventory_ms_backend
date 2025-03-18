package IMS.DAO;

import org.springframework.data.repository.CrudRepository;

import IMS.Master.CategoryMaster;

public interface CategoryDAO extends CrudRepository<CategoryMaster, Integer>{

	CategoryMaster findByCategoryName(String categoryName);
}
