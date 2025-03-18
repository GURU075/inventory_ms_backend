package IMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import IMS.Master.CategorySoftwarePropertiesMaster;
import IMS.Service.CategorySoftwarePropertiesService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/CategorySoftwareProperties")
public class CategorySoftwarePropertiesController {

    @Autowired
    private CategorySoftwarePropertiesService categorySoftwarePropertiesService;

    @PostMapping("/addCategorySoftwareProperties")
    public ResponseEntity<String> addCategorySoftwareProperties(@RequestBody @Valid CategorySoftwarePropertiesMaster categorySoftwareProperties) {
        Boolean isAdded = categorySoftwarePropertiesService.addCategorySoftwareProperties(categorySoftwareProperties);
        if (isAdded) {
            return new ResponseEntity<>("Category Software Property added successfully!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add Category Software Property.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateCategorySoftwareProperties/{categorySoftwarePropertiesId}")
    public ResponseEntity<String> updateCategorySoftwareProperties(
            @PathVariable("categorySoftwarePropertiesId") @Positive(message = "Category Software Property ID must be positive") Integer categorySoftwarePropertiesId,
            @RequestBody @Valid CategorySoftwarePropertiesMaster categorySoftwareProperties) {
        categorySoftwareProperties.setCategorySoftwarePropertiesId(categorySoftwarePropertiesId);
        Boolean isUpdated = categorySoftwarePropertiesService.updateCategorySoftwareProperties(categorySoftwareProperties);
        if (isUpdated) {
            return new ResponseEntity<>("Category Software Property updated successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update Category Software Property.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteCategorySoftwareProperties/{categorySoftwarePropertiesId}")
    public ResponseEntity<String> deleteCategorySoftwareProperties(@PathVariable("categorySoftwarePropertiesId") @Positive(message = "Category Software Property ID must be positive") Integer categorySoftwarePropertiesId) {
        CategorySoftwarePropertiesMaster categorySoftwareProperties = categorySoftwarePropertiesService.getCategorySoftwareProperties(categorySoftwarePropertiesId);
        if (categorySoftwareProperties != null) {
            Boolean isDeleted = categorySoftwarePropertiesService.deleteCategorySoftwareProperties(categorySoftwareProperties);
            if (isDeleted) {
                return new ResponseEntity<>("Category Software Property deleted successfully!", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Failed to delete Category Software Property.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getCategorySoftwareProperties/{categorySoftwarePropertiesId}")
    public ResponseEntity<CategorySoftwarePropertiesMaster> getCategorySoftwareProperties(@PathVariable("categorySoftwarePropertiesId") @Positive(message = "Category Software Property ID must be positive") Integer categorySoftwarePropertiesId) {
        CategorySoftwarePropertiesMaster categorySoftwareProperties = categorySoftwarePropertiesService.getCategorySoftwareProperties(categorySoftwarePropertiesId);
        if (categorySoftwareProperties != null) {
            return new ResponseEntity<>(categorySoftwareProperties, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllCategorySoftwareProperties")
    public ResponseEntity<List<CategorySoftwarePropertiesMaster>> getAllCategorySoftwareProperties() {
        List<CategorySoftwarePropertiesMaster> allCategorySoftwareProperties = categorySoftwarePropertiesService.getAllCategorySoftwareProperties();
        return new ResponseEntity<>(allCategorySoftwareProperties, HttpStatus.OK);
    }
}
