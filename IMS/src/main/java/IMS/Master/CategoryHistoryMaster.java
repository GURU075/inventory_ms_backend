package IMS.Master;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblCategoryHistory")
public class CategoryHistoryMaster {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    private int categoryId;
    
    private String categoryName;

    private String categoryDesc;

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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
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

    public CategoryHistoryMaster() {
        super();
    }

    public CategoryHistoryMaster(Integer id, String action) {
        super();
        this.id = id;
        this.action = action;
    }

    public CategoryHistoryMaster(Integer id, int categoryId, String categoryName, String categoryDesc, String action, LocalDateTime timestamp) {
        super();
        this.id = id;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDesc = categoryDesc;
        this.action = action;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "CategoryHistoryMaster [id=" + id + ", categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryDesc=" + categoryDesc + ", action=" + action + ", timestamp=" + timestamp + "]";
    }
}
