package IMS.Service;

import java.util.List;

import IMS.Master.CategorySoftwarePropertiesMaster;

public interface CategorySoftwarePropertiesService {

    public Boolean addCategorySoftwareProperties(CategorySoftwarePropertiesMaster categorySoftwareProperties);
    public Boolean updateCategorySoftwareProperties(CategorySoftwarePropertiesMaster categorySoftwareProperties);
    public Boolean deleteCategorySoftwareProperties(CategorySoftwarePropertiesMaster categorySoftwareProperties);
    public CategorySoftwarePropertiesMaster getCategorySoftwareProperties(Integer categorySoftwarePropertiesId);
    public List<CategorySoftwarePropertiesMaster> getAllCategorySoftwareProperties();
    
}
