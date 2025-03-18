package IMS.Master;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tblHardDisk")
public class HardDiskMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hardDiskId;
    
    @NotNull(message = "Hard Disk name cannot be null")
    @Size(min = 1, max = 50, message = "Hard Disk name must be between 1 and 50 characters")
    private String hardDiskName;
    
    @Size(max = 200, message = "Description must be less than 200 characters")
    private String hardDiskDesc;
        
    public Integer getHardDiskId() {
        return hardDiskId;
    }
    public void setHardDiskId(Integer hardDiskId) {
        this.hardDiskId = hardDiskId;
    }
    public String getHardDiskName() {
        return hardDiskName;
    }
    public void setHardDiskName(String hardDiskName) {
        this.hardDiskName = hardDiskName;
    }
    public String getHardDiskDesc() {
        return hardDiskDesc;
    }
    public void setHardDiskDesc(String hardDiskDesc) {
        this.hardDiskDesc = hardDiskDesc;
    }
    public HardDiskMaster() {
        super();
    }
    public HardDiskMaster(Integer hardDiskId, String hardDiskName, String hardDiskDesc) {
        super();
        this.hardDiskId = hardDiskId;
        this.hardDiskName = hardDiskName;
        this.hardDiskDesc = hardDiskDesc;
    }
    @Override
    public String toString() {
        return "HardDiskMaster [hardDiskId=" + hardDiskId + ", hardDiskName=" + hardDiskName
                + ", hardDiskDesc=" + hardDiskDesc + "]";
    }
}
