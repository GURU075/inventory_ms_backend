package IMS.Service;

import java.util.List;

import IMS.Master.SubCategoryMaster;

public interface SubCategoryService {

    public Boolean addSubCategoryService(SubCategoryMaster subCategoryMaster);
    public Boolean updateSubCategoryService(SubCategoryMaster subCategoryMaster);
    public Boolean deleteSubCategoryService(SubCategoryMaster subCategoryMaster);
    public SubCategoryMaster getSubCategoryService(Integer subCategoryId);
    public List<SubCategoryMaster> getAllSubCategoryService();
}
