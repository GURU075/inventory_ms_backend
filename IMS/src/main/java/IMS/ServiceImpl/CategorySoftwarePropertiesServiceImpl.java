package IMS.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IMS.DAO.CategoryDAO;
import IMS.DAO.CategorySoftwarePropertieshDAO;
import IMS.DAO.CategorySoftwarePropertiesHistoryDAO;
import IMS.Master.CategoryMaster;
import IMS.Master.CategorySoftwarePropertiesHistoryMaster;
import IMS.Master.CategorySoftwarePropertiesMaster;
import IMS.Service.CategorySoftwarePropertiesService;

@Service
public class CategorySoftwarePropertiesServiceImpl implements CategorySoftwarePropertiesService {

    private static final Logger logger = LogManager.getLogger(CategorySoftwarePropertiesServiceImpl.class);

    @Autowired
    private CategorySoftwarePropertieshDAO categorySoftwarePropertiesDAO;

    @Autowired
    private CategorySoftwarePropertiesHistoryDAO categorySoftwarePropertiesHistoryDAO;
    
    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public Boolean addCategorySoftwareProperties(CategorySoftwarePropertiesMaster categorySoftwareProperties) {
        try {
            logger.info("In addCategorySoftwareProperties");
            CategoryMaster category = categoryDAO.findById(categorySoftwareProperties.getCategory().getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found"));
            categorySoftwareProperties.setCategory(category);
            categorySoftwarePropertiesDAO.save(categorySoftwareProperties);

            CategorySoftwarePropertiesHistoryMaster oldCategorySoftwareProperties = new CategorySoftwarePropertiesHistoryMaster();
            oldCategorySoftwareProperties.setCategorySoftwarePropertiesId(categorySoftwareProperties.getCategorySoftwarePropertiesId());
            oldCategorySoftwareProperties.setCategorySoftwarePropertiesName(categorySoftwareProperties.getCategorySoftwarePropertiesName());
            oldCategorySoftwareProperties.setCategorySoftwarePropertyMandatory(categorySoftwareProperties.getCategorySoftwarePropertyMandatory());
            oldCategorySoftwareProperties.setSrNo(categorySoftwareProperties.getSrNo());
            oldCategorySoftwareProperties.setAssetSoftwarePropertyValue(categorySoftwareProperties.getAssetSoftwarePropertyValue());
            oldCategorySoftwareProperties.setCategoryId(category.getCategoryId());
            oldCategorySoftwareProperties.setAction("Create");
            oldCategorySoftwareProperties.setTimestamp(LocalDateTime.now());

            categorySoftwarePropertiesHistoryDAO.save(oldCategorySoftwareProperties);
            logger.info("Out of addCategorySoftwareProperties");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean updateCategorySoftwareProperties(CategorySoftwarePropertiesMaster categorySoftwareProperties) {
        try {
            logger.info("In updateCategorySoftwareProperties");
            CategorySoftwarePropertiesMaster categoryProperties = categorySoftwarePropertiesDAO.findById(categorySoftwareProperties.getCategorySoftwarePropertiesId()).orElseThrow(() -> new RuntimeException("Category Software Property not found"));

            CategorySoftwarePropertiesHistoryMaster oldCategorySoftwareProperties = new CategorySoftwarePropertiesHistoryMaster();
            oldCategorySoftwareProperties.setCategorySoftwarePropertiesId(categoryProperties.getCategorySoftwarePropertiesId());
            oldCategorySoftwareProperties.setCategorySoftwarePropertiesName(categoryProperties.getCategorySoftwarePropertiesName());
            oldCategorySoftwareProperties.setCategorySoftwarePropertyMandatory(categoryProperties.getCategorySoftwarePropertyMandatory());
            oldCategorySoftwareProperties.setSrNo(categoryProperties.getSrNo());
            oldCategorySoftwareProperties.setAssetSoftwarePropertyValue(categoryProperties.getAssetSoftwarePropertyValue());
            oldCategorySoftwareProperties.setCategoryId(categoryProperties.getCategory().getCategoryId());
            oldCategorySoftwareProperties.setAction("Update");
            oldCategorySoftwareProperties.setTimestamp(LocalDateTime.now());

            CategoryMaster category = categoryDAO.findById(categorySoftwareProperties.getCategory().getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found"));
            categorySoftwareProperties.setCategory(category);
            categoryProperties.setCategorySoftwarePropertiesName(categorySoftwareProperties.getCategorySoftwarePropertiesName());
            categoryProperties.setCategorySoftwarePropertyMandatory(categorySoftwareProperties.getCategorySoftwarePropertyMandatory());
            categoryProperties.setSrNo(categorySoftwareProperties.getSrNo());
            categoryProperties.setAssetSoftwarePropertyValue(categorySoftwareProperties.getAssetSoftwarePropertyValue());
            categoryProperties = categorySoftwarePropertiesDAO.save(categoryProperties);

            categorySoftwarePropertiesHistoryDAO.save(oldCategorySoftwareProperties);
            logger.info("Out of updateCategorySoftwareProperties");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean deleteCategorySoftwareProperties(CategorySoftwarePropertiesMaster categorySoftwareProperties) {
        try {
            logger.info("In deleteCategorySoftwareProperties");
            CategorySoftwarePropertiesMaster categoryProperties = categorySoftwarePropertiesDAO.findById(categorySoftwareProperties.getCategorySoftwarePropertiesId()).orElseThrow(() -> new RuntimeException("Category Software Property not found"));

            CategorySoftwarePropertiesHistoryMaster oldCategorySoftwareProperties = new CategorySoftwarePropertiesHistoryMaster();
            oldCategorySoftwareProperties.setCategorySoftwarePropertiesId(categoryProperties.getCategorySoftwarePropertiesId());
            oldCategorySoftwareProperties.setCategorySoftwarePropertiesName(categoryProperties.getCategorySoftwarePropertiesName());
            oldCategorySoftwareProperties.setCategorySoftwarePropertyMandatory(categoryProperties.getCategorySoftwarePropertyMandatory());
            oldCategorySoftwareProperties.setSrNo(categoryProperties.getSrNo());
            oldCategorySoftwareProperties.setAssetSoftwarePropertyValue(categoryProperties.getAssetSoftwarePropertyValue());
            oldCategorySoftwareProperties.setCategoryId(categoryProperties.getCategory().getCategoryId());
            oldCategorySoftwareProperties.setAction("Delete");
            oldCategorySoftwareProperties.setTimestamp(LocalDateTime.now());

            categorySoftwarePropertiesDAO.delete(categoryProperties);

            categorySoftwarePropertiesHistoryDAO.save(oldCategorySoftwareProperties);
            logger.info("Out of deleteCategorySoftwareProperties");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public CategorySoftwarePropertiesMaster getCategorySoftwareProperties(Integer categorySoftwarePropertiesId) {
        try {
            logger.info("In getCategorySoftwareProperties");
            CategorySoftwarePropertiesMaster categorySoftwareProperties = categorySoftwarePropertiesDAO.findById(categorySoftwarePropertiesId).orElse(null);
            logger.info("Out of getCategorySoftwareProperties");
            return categorySoftwareProperties;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<CategorySoftwarePropertiesMaster> getAllCategorySoftwareProperties() {
        List<CategorySoftwarePropertiesMaster> allCategorySoftwareProperties = new ArrayList<>();
        try {
            logger.info("In getAllCategorySoftwareProperties");
            allCategorySoftwareProperties = (List<CategorySoftwarePropertiesMaster>) categorySoftwarePropertiesDAO.findAll();
            logger.info("Out of getAllCategorySoftwareProperties");
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
        }
        return allCategorySoftwareProperties;
    }
}
