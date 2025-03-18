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
@Table(name = "tblCategorySoftwareProperties")
public class CategorySoftwarePropertiesMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CategorySoftwarePropertiesId;
    
    @NotNull(message = "Category Software Property Name cannot be null")
    @Size(min = 1, max = 50, message = "Category Software Property Name must be between 1 and 50 characters")
    private String CategorySoftwarePropertiesName;
    
    private Boolean CategorySoftwarePropertyMandatory;
    
    private Integer SrNo;
    
    @Size(max = 100, message = "Asset Software Property Value must be less than 100 characters")
    private String AssetSoftwarePropertyValue;
    
    @ManyToOne
    @JoinColumn(name = "CategoryId", nullable = false)
    private CategoryMaster Category;

    // Getters and Setters
    public Integer getCategorySoftwarePropertiesId() {
        return CategorySoftwarePropertiesId;
    }

    public void setCategorySoftwarePropertiesId(Integer categorySoftwarePropertiesId) {
        CategorySoftwarePropertiesId = categorySoftwarePropertiesId;
    }

    public String getCategorySoftwarePropertiesName() {
        return CategorySoftwarePropertiesName;
    }

    public void setCategorySoftwarePropertiesName(String categorySoftwarePropertiesName) {
        CategorySoftwarePropertiesName = categorySoftwarePropertiesName;
    }

    public Boolean getCategorySoftwarePropertyMandatory() {
        return CategorySoftwarePropertyMandatory;
    }

    public void setCategorySoftwarePropertyMandatory(Boolean categorySoftwarePropertyMandatory) {
        CategorySoftwarePropertyMandatory = categorySoftwarePropertyMandatory;
    }

    public Integer getSrNo() {
        return SrNo;
    }

    public void setSrNo(Integer srNo) {
        SrNo = srNo;
    }

    public String getAssetSoftwarePropertyValue() {
        return AssetSoftwarePropertyValue;
    }

    public void setAssetSoftwarePropertyValue(String assetSoftwarePropertyValue) {
        AssetSoftwarePropertyValue = assetSoftwarePropertyValue;
    }

    public CategoryMaster getCategory() {
        return Category;
    }

    public void setCategory(CategoryMaster category) {
        Category = category;
    }

    // Constructors
    public CategorySoftwarePropertiesMaster() {
        super();
    }

    public CategorySoftwarePropertiesMaster(Integer categorySoftwarePropertiesId,
            @NotNull(message = "Category Software Property Name cannot be null") @Size(min = 1, max = 50, message = "Category Software Property Name must be between 1 and 50 characters") String categorySoftwarePropertiesName,
            Boolean categorySoftwarePropertyMandatory, Integer srNo,
            @Size(max = 100, message = "Asset Software Property Value must be less than 100 characters") String assetSoftwarePropertyValue,
            CategoryMaster category) {
        super();
        CategorySoftwarePropertiesId = categorySoftwarePropertiesId;
        CategorySoftwarePropertiesName = categorySoftwarePropertiesName;
        CategorySoftwarePropertyMandatory = categorySoftwarePropertyMandatory;
        SrNo = srNo;
        AssetSoftwarePropertyValue = assetSoftwarePropertyValue;
        Category = category;
    }

    @Override
    public String toString() {
        return "CategorySoftwarePropertiesMaster [CategorySoftwarePropertiesId=" + CategorySoftwarePropertiesId
                + ", CategorySoftwarePropertiesName=" + CategorySoftwarePropertiesName
                + ", CategorySoftwarePropertyMandatory=" + CategorySoftwarePropertyMandatory + ", SrNo=" + SrNo
                + ", AssetSoftwarePropertyValue=" + AssetSoftwarePropertyValue + ", Category=" + Category + "]";
    }
}
