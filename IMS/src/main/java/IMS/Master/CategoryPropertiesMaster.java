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
@Table(name = "tblCategoryProperties")
public class CategoryPropertiesMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryPropertyId;
    
    @NotNull(message = "Category property name cannot be null")
    @Size(min = 1, max = 50, message = "Category property name must be between 1 and 50 characters")
    private String categoryPropertyName;
    
    @NotNull(message = "Category property mandatory cannot be null")
    private Boolean categoryPropertyMandatory;
    
    @NotNull(message = "Serial number cannot be null")
    private Integer srNo;
    
    @Size(max = 200, message = "Asset property value must be less than 200 characters")
    private String assetPropertyValue;
    
    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private CategoryMaster category;

    public Integer getCategoryPropertyId() {
        return categoryPropertyId;
    }

    public void setCategoryPropertyId(Integer categoryPropertyId) {
        this.categoryPropertyId = categoryPropertyId;
    }

    public String getCategoryPropertyName() {
        return categoryPropertyName;
    }

    public void setCategoryPropertyName(String categoryPropertyName) {
        this.categoryPropertyName = categoryPropertyName;
    }

    public Boolean getCategoryPropertyMandatory() {
        return categoryPropertyMandatory;
    }

    public void setCategoryPropertyMandatory(Boolean categoryPropertyMandatory) {
        this.categoryPropertyMandatory = categoryPropertyMandatory;
    }

    public Integer getSrNo() {
        return srNo;
    }

    public void setSrNo(Integer srNo) {
        this.srNo = srNo;
    }

    public String getAssetPropertyValue() {
        return assetPropertyValue;
    }

    public void setAssetPropertyValue(String assetPropertyValue) {
        this.assetPropertyValue = assetPropertyValue;
    }

    public CategoryMaster getCategory() {
        return category;
    }

    public void setCategory(CategoryMaster category) {
        this.category = category;
    }

    public CategoryPropertiesMaster() {
        super();
    }

    public CategoryPropertiesMaster(Integer categoryPropertyId,
            @NotNull(message = "Category property name cannot be null") @Size(min = 1, max = 50, message = "Category property name must be between 1 and 50 characters") String categoryPropertyName,
            @NotNull(message = "Category property mandatory cannot be null") Boolean categoryPropertyMandatory,
            @NotNull(message = "Serial number cannot be null") Integer srNo,
            @Size(max = 200, message = "Asset property value must be less than 200 characters") String assetPropertyValue,
            CategoryMaster category) {
        super();
        this.categoryPropertyId = categoryPropertyId;
        this.categoryPropertyName = categoryPropertyName;
        this.categoryPropertyMandatory = categoryPropertyMandatory;
        this.srNo = srNo;
        this.assetPropertyValue = assetPropertyValue;
        this.category = category;
    }

    @Override
    public String toString() {
        return "CategoryProperties [categoryPropertyId=" + categoryPropertyId + ", categoryPropertyName=" + categoryPropertyName
                + ", categoryPropertyMandatory=" + categoryPropertyMandatory + ", srNo=" + srNo + ", assetPropertyValue="
                + assetPropertyValue + ", category=" + category + "]";
    }
    
}
