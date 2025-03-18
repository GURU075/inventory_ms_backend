package IMS.Master;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblCategoryPropertiesHistory")
public class CategoryPropertiesHistoryMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private int categoryPropertyId;
    
    private String categoryPropertyName;
    
    private Boolean categoryPropertyMandatory;
    
    private int srNo;
    
    private String assetPropertyValue;

    private int categoryId;
    
    private String action;
    
    private LocalDateTime timestamp;
    
    @PrePersist
    private void onCreate() {
        timestamp = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCategoryPropertyId() {
        return categoryPropertyId;
    }

    public void setCategoryPropertyId(int categoryPropertyId) {
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

    public int getSrNo() {
        return srNo;
    }

    public void setSrNo(int srNo) {
        this.srNo = srNo;
    }

    public String getAssetPropertyValue() {
        return assetPropertyValue;
    }

    public void setAssetPropertyValue(String assetPropertyValue) {
        this.assetPropertyValue = assetPropertyValue;
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

    public CategoryPropertiesHistoryMaster(Integer id, String action) {
        super();
        this.id = id;
        this.action = action;
    }

    public CategoryPropertiesHistoryMaster() {
        super();
    }

    public CategoryPropertiesHistoryMaster(Integer id, int categoryPropertyId, String categoryPropertyName,
                                     Boolean categoryPropertyMandatory, int srNo, String assetPropertyValue,
                                     int categoryId, String action, LocalDateTime timestamp) {
        super();
        this.id = id;
        this.categoryPropertyId = categoryPropertyId;
        this.categoryPropertyName = categoryPropertyName;
        this.categoryPropertyMandatory = categoryPropertyMandatory;
        this.srNo = srNo;
        this.assetPropertyValue = assetPropertyValue;
        this.categoryId = categoryId;
        this.action = action;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "CategoryPropertiesHistory [id=" + id + ", categoryPropertyId=" + categoryPropertyId 
                + ", categoryPropertyName=" + categoryPropertyName + ", categoryPropertyMandatory=" 
                + categoryPropertyMandatory + ", srNo=" + srNo + ", assetPropertyValue=" 
                + assetPropertyValue + ", categoryId=" + categoryId + ", action=" 
                + action + ", timestamp=" + timestamp + "]";
    }
}
