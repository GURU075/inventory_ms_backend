package IMS.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IMS.DAO.CategoryDAO;
import IMS.DAO.CategoryPropertiesDAO;
import IMS.DAO.CategoryPropertiesHistoryDAO;
import IMS.Master.CategoryMaster;
import IMS.Master.CategoryPropertiesHistoryMaster;
import IMS.Master.CategoryPropertiesMaster;
import IMS.Service.CategoryPropertiesService;

@Service
public class CategoryPropertiesServiceImpl implements CategoryPropertiesService {

    private static final Logger logger = LogManager.getLogger(CategoryPropertiesServiceImpl.class);

    @Autowired
    private CategoryPropertiesDAO categoryPropertiesDAO;

    @Autowired
    private CategoryPropertiesHistoryDAO categoryPropertiesHistoryDAO;
    
    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public Boolean addCategoryPropertiesService(CategoryPropertiesMaster categoryProperties) {
        try {
            logger.info("In addCategoryPropertiesService");
            CategoryMaster category = categoryDAO.findById(categoryProperties.getCategory().getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found")); 
            categoryProperties.setCategory(category);
            categoryPropertiesDAO.save(categoryProperties);

            CategoryPropertiesHistoryMaster oldCategoryProperties = new CategoryPropertiesHistoryMaster();
            oldCategoryProperties.setCategoryPropertyId(categoryProperties.getCategoryPropertyId());
            oldCategoryProperties.setCategoryPropertyName(categoryProperties.getCategoryPropertyName());
            oldCategoryProperties.setCategoryPropertyMandatory(categoryProperties.getCategoryPropertyMandatory());
            oldCategoryProperties.setSrNo(categoryProperties.getSrNo());
            oldCategoryProperties.setAssetPropertyValue(categoryProperties.getAssetPropertyValue());
            oldCategoryProperties.setCategoryId(categoryProperties.getCategory().getCategoryId());
            oldCategoryProperties.setAction("Create");
            oldCategoryProperties.setTimestamp(LocalDateTime.now());

            categoryPropertiesHistoryDAO.save(oldCategoryProperties);
            logger.info("Out of addCategoryPropertiesService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean updateCategoryPropertiesService(CategoryPropertiesMaster categoryProperties) {
        try {
            logger.info("In updateCategoryPropertiesService");
            CategoryPropertiesMaster categoryProp = categoryPropertiesDAO.findById(categoryProperties.getCategoryPropertyId()).orElseThrow(() -> new RuntimeException("Category property not found"));

            CategoryPropertiesHistoryMaster oldCategoryProperties = new CategoryPropertiesHistoryMaster();
            oldCategoryProperties.setCategoryPropertyId(categoryProp.getCategoryPropertyId());
            oldCategoryProperties.setCategoryPropertyName(categoryProp.getCategoryPropertyName());
            oldCategoryProperties.setCategoryPropertyMandatory(categoryProp.getCategoryPropertyMandatory());
            oldCategoryProperties.setSrNo(categoryProp.getSrNo());
            oldCategoryProperties.setAssetPropertyValue(categoryProp.getAssetPropertyValue());
            oldCategoryProperties.setCategoryId(categoryProp.getCategory().getCategoryId());
            oldCategoryProperties.setAction("Update");
            oldCategoryProperties.setTimestamp(LocalDateTime.now());

            CategoryMaster category = categoryDAO.findById(categoryProperties.getCategory().getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found")); 
            categoryProperties.setCategory(category);
            categoryProp.setCategoryPropertyName(categoryProperties.getCategoryPropertyName());
            categoryProp.setCategoryPropertyMandatory(categoryProperties.getCategoryPropertyMandatory());
            categoryProp.setSrNo(categoryProperties.getSrNo());
            categoryProp.setAssetPropertyValue(categoryProperties.getAssetPropertyValue());
            categoryProp = categoryPropertiesDAO.save(categoryProp);

            categoryPropertiesHistoryDAO.save(oldCategoryProperties);
            logger.info("Out of updateCategoryPropertiesService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean deleteCategoryPropertiesService(CategoryPropertiesMaster categoryProperties) {
        try {
            logger.info("In deleteCategoryPropertiesService");
            CategoryPropertiesMaster categoryProp = categoryPropertiesDAO.findById(categoryProperties.getCategoryPropertyId()).orElseThrow(() -> new RuntimeException("Category property not found"));

            CategoryPropertiesHistoryMaster oldCategoryProperties = new CategoryPropertiesHistoryMaster();
            oldCategoryProperties.setCategoryPropertyId(categoryProp.getCategoryPropertyId());
            oldCategoryProperties.setCategoryPropertyName(categoryProp.getCategoryPropertyName());
            oldCategoryProperties.setCategoryPropertyMandatory(categoryProp.getCategoryPropertyMandatory());
            oldCategoryProperties.setSrNo(categoryProp.getSrNo());
            oldCategoryProperties.setAssetPropertyValue(categoryProp.getAssetPropertyValue());
            oldCategoryProperties.setCategoryId(categoryProp.getCategory().getCategoryId());
            oldCategoryProperties.setAction("Delete");
            oldCategoryProperties.setTimestamp(LocalDateTime.now());

            categoryPropertiesDAO.delete(categoryProp);

            categoryPropertiesHistoryDAO.save(oldCategoryProperties);
            logger.info("Out of deleteCategoryPropertiesService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public CategoryPropertiesMaster getCategoryPropertiesService(Integer categoryPropertyId) {
        try {
            logger.info("In getCategoryPropertiesService");
            CategoryPropertiesMaster categoryProperties = categoryPropertiesDAO.findById(categoryPropertyId).orElse(null);
            logger.info("Out of getCategoryPropertiesService");
            return categoryProperties;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<CategoryPropertiesMaster> getAllCategoryPropertiesService() {
        List<CategoryPropertiesMaster> allCategoryProperties = new ArrayList<>();
        try {
            logger.info("In getAllCategoryPropertiesService");
            allCategoryProperties = (List<CategoryPropertiesMaster>) categoryPropertiesDAO.findAll();
            logger.info("Out of getAllCategoryPropertiesService");
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
        }
        return allCategoryProperties;
    }

    
    @Override 
    public List<CategoryPropertiesMaster> getCategoryPropertiesByCategoryId(Integer categoryId) { 
    	return categoryPropertiesDAO.findByCategory_CategoryId(categoryId); 
    	}
    }
