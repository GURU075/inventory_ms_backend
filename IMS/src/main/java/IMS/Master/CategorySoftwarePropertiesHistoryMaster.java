package IMS.Master;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblCategorySoftwarePropertiesHistory")
public class CategorySoftwarePropertiesHistoryMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private int categorySoftwarePropertiesId;
    
    private String categorySoftwarePropertiesName;
    
    private Boolean categorySoftwarePropertyMandatory;
    
    private Integer srNo;
    
    private String assetSoftwarePropertyValue;
    
    private int categoryId;
    
    private String action;
    
    private LocalDateTime timestamp;
    
    @PrePersist
    private void onCreate() {
        timestamp = LocalDateTime.now();
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCategorySoftwarePropertiesId() {
        return categorySoftwarePropertiesId;
    }

    public void setCategorySoftwarePropertiesId(int categorySoftwarePropertiesId) {
        this.categorySoftwarePropertiesId = categorySoftwarePropertiesId;
    }

    public String getCategorySoftwarePropertiesName() {
        return categorySoftwarePropertiesName;
    }

    public void setCategorySoftwarePropertiesName(String categorySoftwarePropertiesName) {
        this.categorySoftwarePropertiesName = categorySoftwarePropertiesName;
    }

    public Boolean getCategorySoftwarePropertyMandatory() {
        return categorySoftwarePropertyMandatory;
    }

    public void setCategorySoftwarePropertyMandatory(Boolean categorySoftwarePropertyMandatory) {
        this.categorySoftwarePropertyMandatory = categorySoftwarePropertyMandatory;
    }

    public Integer getSrNo() {
        return srNo;
    }

    public void setSrNo(Integer srNo) {
        this.srNo = srNo;
    }

    public String getAssetSoftwarePropertyValue() {
        return assetSoftwarePropertyValue;
    }

    public void setAssetSoftwarePropertyValue(String assetSoftwarePropertyValue) {
        this.assetSoftwarePropertyValue = assetSoftwarePropertyValue;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    // Constructors
    public CategorySoftwarePropertiesHistoryMaster() {
        super();
    }
    
    public CategorySoftwarePropertiesHistoryMaster(Integer id, String action) {
        super();
        this.id = id;
        this.action = action;
    }

    public CategorySoftwarePropertiesHistoryMaster(Integer id, int categorySoftwarePropertiesId, String categorySoftwarePropertiesName,
            Boolean categorySoftwarePropertyMandatory, Integer srNo, String assetSoftwarePropertyValue, int categoryId,
            String action, LocalDateTime timestamp) {
        super();
        this.id = id;
        this.categorySoftwarePropertiesId = categorySoftwarePropertiesId;
        this.categorySoftwarePropertiesName = categorySoftwarePropertiesName;
        this.categorySoftwarePropertyMandatory = categorySoftwarePropertyMandatory;
        this.srNo = srNo;
        this.assetSoftwarePropertyValue = assetSoftwarePropertyValue;
        this.categoryId = categoryId;
        this.action = action;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "CategorySoftwarePropertiesHistoryMaster [id=" + id + ", categorySoftwarePropertiesId=" + categorySoftwarePropertiesId
                + ", categorySoftwarePropertiesName=" + categorySoftwarePropertiesName
                + ", categorySoftwarePropertyMandatory=" + categorySoftwarePropertyMandatory + ", srNo=" + srNo
                + ", assetSoftwarePropertyValue=" + assetSoftwarePropertyValue + ", categoryId=" + categoryId
                + ", action=" + action + ", timestamp=" + timestamp + "]";
    }
}
