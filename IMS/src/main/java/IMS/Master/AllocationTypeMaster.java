package IMS.Master;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tblAllocationType")
public class AllocationTypeMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer allocationTypeId;
    
    @NotNull(message = "Allocation type name cannot be null")
    @Size(min = 1, max = 50, message = "Allocation type name must be between 1 and 50 characters")
    private String allocationTypeName;
    
    @Size(max = 200, message = "Description must be less than 200 characters")
    private String allocationTypeDesc;
    
    public Integer getAllocationTypeId() {
        return allocationTypeId;
    }
    public void setAllocationTypeId(Integer allocationTypeId) {
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
    public AllocationTypeMaster() {
        super();
    }
    public AllocationTypeMaster(Integer allocationTypeId, String allocationTypeName, String allocationTypeDesc) {
        super();
        this.allocationTypeId = allocationTypeId;
        this.allocationTypeName = allocationTypeName;
        this.allocationTypeDesc = allocationTypeDesc;
    }
    @Override
    public String toString() {
        return "AllocationTypeMaster [allocationTypeId=" + allocationTypeId + ", allocationTypeName=" + allocationTypeName + ", allocationTypeDesc=" + allocationTypeDesc + "]";
    }
}
