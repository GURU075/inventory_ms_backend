package IMS.Master;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblRAMHistory")
public class RAMHistoryMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private int ramId;
    
    private String ramName;
    
    private String ramDesc;
    
    private String action; 
    
    private LocalDateTime timestamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRamId() {
        return ramId;
    }

    public void setRamId(int ramId) {
        this.ramId = ramId;
    }

    public String getRamName() {
        return ramName;
    }

    public void setRamName(String ramName) {
        this.ramName = ramName;
    }

    public String getRamDesc() {
        return ramDesc;
    }

    public void setRamDesc(String ramDesc) {
        this.ramDesc = ramDesc;
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

    public RAMHistoryMaster() {
        super();
    }

    public RAMHistoryMaster(Integer id, String action) {
        this.id = id;
        this.action = action;
    }

    public RAMHistoryMaster(Integer id, int ramId, String ramName, String ramDesc,
            String action, LocalDateTime timestamp) {
        super();
        this.id = id;
        this.ramId = ramId;
        this.ramName = ramName;
        this.ramDesc = ramDesc;
        this.action = action;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "RAMHistoryMaster [id=" + id + ", ramId=" + ramId + ", ramName="
                + ramName + ", ramDesc=" + ramDesc + ", action=" + action + ", timestamp="
                + timestamp + "]";
    }
}
