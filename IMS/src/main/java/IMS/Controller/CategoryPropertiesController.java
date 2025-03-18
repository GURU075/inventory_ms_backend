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
import IMS.Master.CategoryPropertiesMaster;
import IMS.Service.CategoryPropertiesService;
import IMS.Service.CategoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/CategoryProperties")
public class CategoryPropertiesController {

    @Autowired
    private CategoryPropertiesService categoryPropertiesService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/addCategoryProperties")
    public ResponseEntity<String> addCategoryProperties(@RequestBody @Valid CategoryPropertiesMaster categoryProperties) {
        CategoryMaster category = categoryService.getCategoryByName(categoryProperties.getCategory().getCategoryName());
        if (category != null) {
            categoryProperties.setCategory(category);
            Boolean isAdded = categoryPropertiesService.addCategoryPropertiesService(categoryProperties);
            if (isAdded) {
                return new ResponseEntity<>("Category Properties added successfully!", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Failed to add Category Properties.", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Invalid category ID.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateCategoryProperties/{categoryPropertyId}")
    public ResponseEntity<String> updateCategoryProperties(
            @PathVariable("categoryPropertyId") @Positive(message = "Category Property ID must be positive") Integer categoryPropertyId,
            @RequestBody @Valid CategoryPropertiesMaster categoryProperties) {
        CategoryMaster category = categoryService.getCategoryByName(categoryProperties.getCategory().getCategoryName());
        if (category != null) {
            categoryProperties.setCategory(category);
            categoryProperties.setCategoryPropertyId(categoryPropertyId);
            Boolean isUpdated = categoryPropertiesService.updateCategoryPropertiesService(categoryProperties);
            if (isUpdated) {
                return new ResponseEntity<>("Category Properties updated successfully!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Failed to update Category Properties.", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Invalid category ID.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteCategoryProperties/{categoryPropertyId}")
    public ResponseEntity<String> deleteCategoryProperties(@PathVariable("categoryPropertyId") @Positive(message = "Category Property ID must be positive") Integer categoryPropertyId) {
        CategoryPropertiesMaster categoryProperties = categoryPropertiesService.getCategoryPropertiesService(categoryPropertyId);
        if (categoryProperties != null) {
            Boolean isDeleted = categoryPropertiesService.deleteCategoryPropertiesService(categoryProperties);
            if (isDeleted) {
                return new ResponseEntity<>("Category Properties deleted successfully!", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Failed to delete Category Properties.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getCategoryProperties/{categoryPropertyId}")
    public ResponseEntity<CategoryPropertiesMaster> getCategoryProperties(@PathVariable("categoryPropertyId") @Positive(message = "Category Property ID must be positive") Integer categoryPropertyId) {
        CategoryPropertiesMaster categoryProperties = categoryPropertiesService.getCategoryPropertiesService(categoryPropertyId);
        if (categoryProperties != null) {
            return new ResponseEntity<>(categoryProperties, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
   

    @GetMapping("/getAllCategoryProperties")
    public ResponseEntity<List<CategoryPropertiesMaster>> getAllCategoryProperties() {
        List<CategoryPropertiesMaster> allCategoryProperties = categoryPropertiesService.getAllCategoryPropertiesService();
        return new ResponseEntity<>(allCategoryProperties, HttpStatus.OK);
    }

    @GetMapping("/getCategoryPropertiesByCategoryId/{categoryId}") 
    public List<CategoryPropertiesMaster> getCategoryPropertiesByCategoryId(@PathVariable("categoryId") Integer categoryId) { 
    	return categoryPropertiesService.getCategoryPropertiesByCategoryId(categoryId); 
    	}

}



