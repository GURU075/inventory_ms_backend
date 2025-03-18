package IMS.Master;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblAllocationTypeHistory")
public class AllocationTypeHistoryMaster {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    private int allocationTypeId;
    
    private String allocationTypeName;
    
    private String allocationTypeDesc;

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

    public int getAllocationTypeId() {
        return allocationTypeId;
    }

    public void setAllocationTypeId(int allocationTypeId) {
        this.allocationTypeId = allocationTypeId;
    }

    public String getAllocationTypeName() {
        return allocationTypeName;
    }

    public void setAllocationTypeName(String allocationTypeName) {
        this.allocationTypeName = allocationTypeName;
    }
    
    public String getAllocationTypeDesc() {
        return allocationTypeDesc;
    }

    public void setAllocationTypeDesc(String allocationTypeDesc) {
        this.allocationTypeDesc = allocationTypeDesc;
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

    public AllocationTypeHistoryMaster() {
        super();
    }

    public AllocationTypeHistoryMaster(Integer id, String action) {
        super();
        this.id = id;
        this.action = action;
    }

    public AllocationTypeHistoryMaster(Integer id, int allocationTypeId, String allocationTypeName, String allocationTypeDesc, String action, LocalDateTime timestamp) {
        super();
        this.id = id;
        this.allocationTypeId = allocationTypeId;
        this.allocationTypeName = allocationTypeName;
        this.allocationTypeDesc = allocationTypeDesc;
        this.action = action;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "AllocationTypeHistoryMaster [id=" + id + ", allocationTypeId=" + allocationTypeId + ", allocationTypeName=" + allocationTypeName + ", allocationTypeDesc=" + allocationTypeDesc + ", action=" + action + ", timestamp=" + timestamp + "]";
    }
}
