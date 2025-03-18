package IMS.Service;

import java.util.List;

import IMS.Master.CategoryMaster;

public interface CategoryService {

    public Boolean addCategoryService(CategoryMaster categoryMaster);
    public Boolean updateCategoryService(CategoryMaster categoryMaster);
    public Boolean deleteCategoryService(CategoryMaster categoryMaster);
    public CategoryMaster getCategoryService(Integer categoryId);
    public List<CategoryMaster> getAllCategoryService();
    CategoryMaster getCategoryByName(String categoryName);
}
