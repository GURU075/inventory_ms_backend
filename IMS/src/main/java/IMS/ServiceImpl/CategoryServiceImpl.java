package IMS.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IMS.DAO.CategoryDAO;
import IMS.DAO.CategoryHistoryDAO;
import IMS.Master.CategoryHistoryMaster;
import IMS.Master.CategoryMaster;
import IMS.Service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final Logger logger = LogManager.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private CategoryHistoryDAO categoryHistoryDAO;
    

    @Override
    public Boolean addCategoryService(CategoryMaster categoryMaster) {
        try {
            logger.info("In addCategoryService");
            categoryDAO.save(categoryMaster);

            CategoryHistoryMaster oldCategory = new CategoryHistoryMaster();
            oldCategory.setCategoryId(categoryMaster.getCategoryId());
            oldCategory.setCategoryName(categoryMaster.getCategoryName());
            oldCategory.setCategoryDesc(categoryMaster.getCategoryDesc());
            oldCategory.setAction("Create");
            oldCategory.setTimestamp(LocalDateTime.now());

            categoryHistoryDAO.save(oldCategory);
            logger.info("Out of addCategoryService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean updateCategoryService(CategoryMaster categoryMaster) {
        try {
            logger.info("In updateCategoryService");
            CategoryMaster category = categoryDAO.findById(categoryMaster.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found"));

            CategoryHistoryMaster oldCategory = new CategoryHistoryMaster();
            oldCategory.setCategoryId(category.getCategoryId());
            oldCategory.setCategoryName(category.getCategoryName());
            oldCategory.setCategoryDesc(category.getCategoryDesc());
            oldCategory.setAction("Update");
            oldCategory.setTimestamp(LocalDateTime.now());

            category.setCategoryName(categoryMaster.getCategoryName());
            category.setCategoryDesc(categoryMaster.getCategoryDesc());
            category = categoryDAO.save(category);

            categoryHistoryDAO.save(oldCategory);
            logger.info("Out of updateCategoryService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean deleteCategoryService(CategoryMaster categoryMaster) {
        try {
            logger.info("In deleteCategoryService");
            CategoryMaster category = categoryDAO.findById(categoryMaster.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found"));

            CategoryHistoryMaster oldCategory = new CategoryHistoryMaster();
            oldCategory.setCategoryId(category.getCategoryId());
            oldCategory.setCategoryName(category.getCategoryName());
            oldCategory.setCategoryDesc(category.getCategoryDesc());
            oldCategory.setAction("Delete");
            oldCategory.setTimestamp(LocalDateTime.now());

            categoryDAO.delete(category);

            categoryHistoryDAO.save(oldCategory);
            logger.info("Out of deleteCategoryService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public CategoryMaster getCategoryService(Integer categoryId) {
        try {
            logger.info("In getCategoryService");
            CategoryMaster categoryMaster = categoryDAO.findById(categoryId).orElse(null);
            logger.info("Out of getCategoryService");
            return categoryMaster;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<CategoryMaster> getAllCategoryService() {
        List<CategoryMaster> allCategories = new ArrayList<>();
        try {
            logger.info("In getAllCategoryService");
            allCategories = (List<CategoryMaster>) categoryDAO.findAll();
            logger.info("Out of getAllCategoryService");
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
        }
        return allCategories;
    }
    
    @Override 
    public CategoryMaster getCategoryByName(String categoryName) { 
    	return categoryDAO.findByCategoryName(categoryName); 
    	}
   }
