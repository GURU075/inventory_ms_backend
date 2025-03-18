package IMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import IMS.Master.CategoryMaster;
import IMS.Master.SubCategoryMaster;
import IMS.Service.CategoryService;
import IMS.Service.SubCategoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/SubCategory")
public class SubCategoryController {

    @Autowired
    private SubCategoryService subCategoryService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/addSubCategory")
    public ResponseEntity<String> addSubCategory(@RequestBody @Valid SubCategoryMaster subCategoryMaster) {
        CategoryMaster category = categoryService.getCategoryByName(subCategoryMaster.getCategory().getCategoryName());
        if (category != null) {
            subCategoryMaster.setCategory(category);
            Boolean isAdded = subCategoryService.addSubCategoryService(subCategoryMaster);
            if (isAdded) {
                return new ResponseEntity<>("SubCategory added successfully!", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Failed to add SubCategory.", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Invalid category name.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateSubCategory/{subCategoryId}")
    public ResponseEntity<String> updateSubCategory(
            @PathVariable("subCategoryId") @Positive(message = "SubCategory ID must be positive") Integer subCategoryId,
            @RequestBody @Valid SubCategoryMaster subCategoryMaster) {
        CategoryMaster category = categoryService.getCategoryByName(subCategoryMaster.getCategory().getCategoryName());
        if (category != null) {
            subCategoryMaster.setCategory(category);
            subCategoryMaster.setSubCategoryId(subCategoryId);
            Boolean isUpdated = subCategoryService.updateSubCategoryService(subCategoryMaster);
            if (isUpdated) {
                return new ResponseEntity<>("SubCategory updated successfully!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Failed to update SubCategory.", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Invalid category name.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteSubCategory/{subCategoryId}")
    public ResponseEntity<String> deleteSubCategory(@PathVariable("subCategoryId") @Positive(message = "SubCategory ID must be positive") Integer subCategoryId) {
        SubCategoryMaster subCategoryMaster = subCategoryService.getSubCategoryService(subCategoryId);
        if (subCategoryMaster != null) {
            Boolean isDeleted = subCategoryService.deleteSubCategoryService(subCategoryMaster);
            if (isDeleted) {
                return new ResponseEntity<>("SubCategory deleted successfully!", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Failed to delete SubCategory.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getSubCategory/{subCategoryId}")
    public ResponseEntity<SubCategoryMaster> getSubCategory(@PathVariable("subCategoryId") @Positive(message = "SubCategory ID must be positive") Integer subCategoryId) {
        SubCategoryMaster subCategoryMaster = subCategoryService.getSubCategoryService(subCategoryId);
        if (subCategoryMaster != null) {
            return new ResponseEntity<>(subCategoryMaster, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllSubCategories")
    public ResponseEntity<List<SubCategoryMaster>> getAllSubCategories() {
        List<SubCategoryMaster> allSubCategories = subCategoryService.getAllSubCategoryService();
        return new ResponseEntity<>(allSubCategories, HttpStatus.OK);
    }
}
