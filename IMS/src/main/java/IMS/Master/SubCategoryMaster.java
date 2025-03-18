package IMS.Master;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tblSubCategory")
public class SubCategoryMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subCategoryId;

    @NotNull(message = "SubCategory name cannot be null")
    @Size(min = 1, max = 50, message = "SubCategory name must be between 1 and 50 characters")
    private String subCategoryName;

    @Size(max = 200, message = "Description must be less than 200 characters")
    private String subCategoryDesc;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private CategoryMaster category;

    public Integer getSubCategoryId() {
        return subCategoryId;
    }
    public void setSubCategoryId(Integer subCategoryId) {
        this.subCategoryId = subCategoryId;
    }
    public String getSubCategoryName() {
        return subCategoryName;
    }
    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }
    public String getSubCategoryDesc() {
        return subCategoryDesc;
    }
    public void setSubCategoryDesc(String subCategoryDesc) {
        this.subCategoryDesc = subCategoryDesc;
    }
    public CategoryMaster getCategory() {
        return category;
    }
    public void setCategory(CategoryMaster category) {
        this.category = category;
    }
    public SubCategoryMaster() {
        super();
    }
    public SubCategoryMaster(Integer subCategoryId, String subCategoryName, String subCategoryDesc, CategoryMaster category) {
        super();
        this.subCategoryId = subCategoryId;
        this.subCategoryName = subCategoryName;
        this.subCategoryDesc = subCategoryDesc;
        this.category = category;
    }
    @Override
    public String toString() {
        return "SubCategoryMaster [subCategoryId=" + subCategoryId + ", subCategoryName=" + subCategoryName + ", subCategoryDesc=" + subCategoryDesc + ", category=" + category + "]";
    }
}
