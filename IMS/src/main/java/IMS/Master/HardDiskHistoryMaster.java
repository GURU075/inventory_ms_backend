package IMS.Master;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblHardDiskHistory")
public class HardDiskHistoryMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private int hardDiskId;
    
    private String hardDiskName;
    
    private String hardDiskDesc;
    
    private String action; 
    
    private LocalDateTime timestamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getHardDiskId() {
        return hardDiskId;
    }

    public void setHardDiskId(int hardDiskId) {
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

    public HardDiskHistoryMaster() {
        super();
    }

    public HardDiskHistoryMaster(Integer id, String action) {
        this.id = id;
        this.action = action;
    }

    public HardDiskHistoryMaster(Integer id, int hardDiskId, String hardDiskName, String hardDiskDesc,
            String action, LocalDateTime timestamp) {
        super();
        this.id = id;
        this.hardDiskId = hardDiskId;
        this.hardDiskName = hardDiskName;
        this.hardDiskDesc = hardDiskDesc;
        this.action = action;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "HardDiskHistoryMaster [id=" + id + ", hardDiskId=" + hardDiskId + ", hardDiskName="
                + hardDiskName + ", hardDiskDesc=" + hardDiskDesc + ", action=" + action + ", timestamp="
                + timestamp + "]";
    }
}
