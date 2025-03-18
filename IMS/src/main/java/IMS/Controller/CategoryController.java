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
import IMS.Service.CategoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/Category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/addCategory")
    public ResponseEntity<String> addCategory(@RequestBody @Valid CategoryMaster categoryMaster) {
        Boolean isAdded = categoryService.addCategoryService(categoryMaster);
        if (isAdded) {
            return new ResponseEntity<>("Category added successfully!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add Category.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateCategory/{categoryId}")
    public ResponseEntity<String> updateCategory(
            @PathVariable("categoryId") @Positive(message = "Category ID must be positive") Integer categoryId,
            @RequestBody @Valid CategoryMaster categoryMaster) {
        categoryMaster.setCategoryId(categoryId);
        Boolean isUpdated = categoryService.updateCategoryService(categoryMaster);
        if (isUpdated) {
            return new ResponseEntity<>("Category updated successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update Category.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteCategory/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable("categoryId") @Positive(message = "Category ID must be positive") Integer categoryId) {
        CategoryMaster categoryMaster = categoryService.getCategoryService(categoryId);
        if (categoryMaster != null) {
            Boolean isDeleted = categoryService.deleteCategoryService(categoryMaster);
            if (isDeleted) {
                return new ResponseEntity<>("Category deleted successfully!", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Failed to delete Category.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getCategory/{categoryId}")
    public ResponseEntity<CategoryMaster> getCategory(@PathVariable("categoryId") @Positive(message = "Category ID must be positive") Integer categoryId) {
        CategoryMaster categoryMaster = categoryService.getCategoryService(categoryId);
        if (categoryMaster != null) {
            return new ResponseEntity<>(categoryMaster, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllCategories")
    public ResponseEntity<List<CategoryMaster>> getAllCategories() {
        List<CategoryMaster> allCategories = categoryService.getAllCategoryService();
        return new ResponseEntity<>(allCategories, HttpStatus.OK);
    }
}
