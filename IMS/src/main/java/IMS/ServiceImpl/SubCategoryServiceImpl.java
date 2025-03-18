package IMS.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IMS.DAO.CategoryDAO;
import IMS.DAO.SubCategoryDAO;
import IMS.DAO.SubCategoryHistoryDAO;
import IMS.Master.CategoryMaster;
import IMS.Master.SubCategoryHistoryMaster;
import IMS.Master.SubCategoryMaster;
import IMS.Service.SubCategoryService;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    private static final Logger logger = LogManager.getLogger(SubCategoryServiceImpl.class);

    @Autowired
    private SubCategoryDAO subCategoryDAO;

    @Autowired
    private SubCategoryHistoryDAO subCategoryHistoryDAO;
    
    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public Boolean addSubCategoryService(SubCategoryMaster subCategoryMaster) {
        try {
            logger.info("In addSubCategoryService");
            CategoryMaster category = categoryDAO.findByCategoryName(subCategoryMaster.getCategory().getCategoryName());
            subCategoryMaster.setCategory(category);
            subCategoryDAO.save(subCategoryMaster);

            SubCategoryHistoryMaster oldSubCategory = new SubCategoryHistoryMaster();
            oldSubCategory.setSubCategoryId(subCategoryMaster.getSubCategoryId());
            oldSubCategory.setSubCategoryName(subCategoryMaster.getSubCategoryName());
            oldSubCategory.setSubCategoryDesc(subCategoryMaster.getSubCategoryDesc());
            oldSubCategory.setCategoryId(subCategoryMaster.getCategory().getCategoryId());
            oldSubCategory.setAction("Create");
            oldSubCategory.setTimestamp(LocalDateTime.now());

            subCategoryHistoryDAO.save(oldSubCategory);
            logger.info("Out of addSubCategoryService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean updateSubCategoryService(SubCategoryMaster subCategoryMaster) {
        try {
            logger.info("In updateSubCategoryService");
            SubCategoryMaster subCategory = subCategoryDAO.findById(subCategoryMaster.getSubCategoryId()).orElseThrow(() -> new RuntimeException("SubCategory not found"));

            SubCategoryHistoryMaster oldSubCategory = new SubCategoryHistoryMaster();
            oldSubCategory.setSubCategoryId(subCategory.getSubCategoryId());
            oldSubCategory.setSubCategoryName(subCategory.getSubCategoryName());
            oldSubCategory.setSubCategoryDesc(subCategory.getSubCategoryDesc());
            oldSubCategory.setCategoryId(subCategory.getCategory().getCategoryId());
            oldSubCategory.setAction("Update");
            oldSubCategory.setTimestamp(LocalDateTime.now());

            CategoryMaster category = categoryDAO.findByCategoryName(subCategoryMaster.getCategory().getCategoryName());
            subCategory.setCategory(category);
            subCategory.setSubCategoryName(subCategoryMaster.getSubCategoryName());
            subCategory.setSubCategoryDesc(subCategoryMaster.getSubCategoryDesc());
            subCategory = subCategoryDAO.save(subCategory);

            subCategoryHistoryDAO.save(oldSubCategory);
            logger.info("Out of updateSubCategoryService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean deleteSubCategoryService(SubCategoryMaster subCategoryMaster) {
        try {
            logger.info("In deleteSubCategoryService");
            SubCategoryMaster subCategory = subCategoryDAO.findById(subCategoryMaster.getSubCategoryId()).orElseThrow(() -> new RuntimeException("SubCategory not found"));

            SubCategoryHistoryMaster oldSubCategory = new SubCategoryHistoryMaster();
            oldSubCategory.setSubCategoryId(subCategory.getSubCategoryId());
            oldSubCategory.setSubCategoryName(subCategory.getSubCategoryName());
            oldSubCategory.setSubCategoryDesc(subCategory.getSubCategoryDesc());
            oldSubCategory.setCategoryId(subCategory.getCategory().getCategoryId());
            oldSubCategory.setAction("Delete");
            oldSubCategory.setTimestamp(LocalDateTime.now());

            subCategoryDAO.delete(subCategory);

            subCategoryHistoryDAO.save(oldSubCategory);
            logger.info("Out of deleteSubCategoryService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public SubCategoryMaster getSubCategoryService(Integer subCategoryId) {
        try {
            logger.info("In getSubCategoryService");
            SubCategoryMaster subCategoryMaster = subCategoryDAO.findById(subCategoryId).orElse(null);
            logger.info("Out of getSubCategoryService");
            return subCategoryMaster;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<SubCategoryMaster> getAllSubCategoryService() {
        List<SubCategoryMaster> allSubCategories = new ArrayList<>();
        try {
            logger.info("In getAllSubCategoryService");
            allSubCategories = (List<SubCategoryMaster>) subCategoryDAO.findAll();
            logger.info("Out of getAllSubCategoryService");
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
        }
        return allSubCategories;
    }
}
