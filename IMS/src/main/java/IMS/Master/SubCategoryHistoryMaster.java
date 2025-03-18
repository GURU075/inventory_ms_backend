package IMS.Master;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblSubCategoryHistory")
public class SubCategoryHistoryMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int subCategoryId;

    private String subCategoryName;

    private String subCategoryDesc;

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

    public int getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(int subCategoryId) {
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

    public SubCategoryHistoryMaster() {
        super();
    }

    public SubCategoryHistoryMaster(Integer id, String action) {
        super();
        this.id = id;
        this.action = action;
    }

    public SubCategoryHistoryMaster(Integer id, int subCategoryId, String subCategoryName, String subCategoryDesc, int categoryId, String action, LocalDateTime timestamp) {
        super();
        this.id = id;
        this.subCategoryId = subCategoryId;
        this.subCategoryName = subCategoryName;
        this.subCategoryDesc = subCategoryDesc;
        this.categoryId = categoryId;
        this.action = action;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "SubCategoryHistoryMaster [id=" + id + ", subCategoryId=" + subCategoryId + ", subCategoryName=" + subCategoryName + ", subCategoryDesc=" + subCategoryDesc + ", categoryId=" + categoryId + ", action=" + action + ", timestamp=" + timestamp + "]";
    }
}
