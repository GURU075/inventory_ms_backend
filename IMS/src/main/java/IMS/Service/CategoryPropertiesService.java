package IMS.Service;

import java.util.List;

import IMS.Master.CategoryPropertiesMaster;


public interface CategoryPropertiesService {

    public Boolean addCategoryPropertiesService(CategoryPropertiesMaster categoryPropertiesMaster);
    public Boolean updateCategoryPropertiesService(CategoryPropertiesMaster categoryPropertiesMaster);
    public Boolean deleteCategoryPropertiesService(CategoryPropertiesMaster categoryPropertiesMaster);
    public CategoryPropertiesMaster getCategoryPropertiesService(Integer categoryPropertyId);
    public List<CategoryPropertiesMaster> getAllCategoryPropertiesService();

    List<CategoryPropertiesMaster> getCategoryPropertiesByCategoryId(Integer categoryId);
}
