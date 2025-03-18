package IMS.Master;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tblCategory")
public class CategoryMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    
    @NotNull(message = "Category name cannot be null")
    @Size(min = 1, max = 50, message = "Category name must be between 1 and 50 characters")
    private String categoryName;
    
    @Size(max = 200, message = "Description must be less than 200 characters")
    private String categoryDesc;
        
    public Integer getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public String getCategoryDesc() {
        return categoryDesc;
    }
    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }
    public CategoryMaster() {
        super();
    }
    public CategoryMaster(Integer categoryId, String categoryName, String categoryDesc) {
        super();
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDesc = categoryDesc;
    }
    @Override
    public String toString() {
        return "CategoryMaster [categoryId=" + categoryId + ", categoryName=" + categoryName
                + ", categoryDesc=" + categoryDesc + "]";
    }
}
