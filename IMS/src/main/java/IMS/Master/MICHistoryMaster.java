package IMS.Master;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblMICHistory")
public class MICHistoryMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private int micId;
    
    private String micName;
    
    private String micDesc;
    
    private String action; 
    
    private LocalDateTime timestamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getMicId() {
        return micId;
    }

    public void setMicId(int micId) {
        this.micId = micId;
    }

    public String getMicName() {
        return micName;
    }

    public void setMicName(String micName) {
        this.micName = micName;
    }

    public String getMicDesc() {
        return micDesc;
    }

    public void setMicDesc(String micDesc) {
        this.micDesc = micDesc;
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

    public MICHistoryMaster() {
        super();
    }

    public MICHistoryMaster(Integer id, String action) {
        this.id = id;
        this.action = action;
    }

    public MICHistoryMaster(Integer id, int micId, String micName, String micDesc,
            String action, LocalDateTime timestamp) {
        super();
        this.id = id;
        this.micId = micId;
        this.micName = micName;
        this.micDesc = micDesc;
        this.action = action;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "MICHistoryMaster [id=" + id + ", micId=" + micId + ", micName="
                + micName + ", micDesc=" + micDesc + ", action=" + action + ", timestamp="
                + timestamp + "]";
    }
}
