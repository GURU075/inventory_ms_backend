package IMS.Master;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblfloorHistory")
public class FloorHistoryMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private int floorId;
    
    private String floorName;
    
    private String floorDesc;
    
    private String action; 
    
    private LocalDateTime timestamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public String getFloorDesc() {
        return floorDesc;
    }

    public void setFloorDesc(String floorDesc) {
        this.floorDesc = floorDesc;
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

    public FloorHistoryMaster() {
        super();
    }

    public FloorHistoryMaster(Integer id, String action) {
        this.id = id;
        this.action = action;
    }

    public FloorHistoryMaster(Integer id, int floorId, String floorName, String floorDesc,
            String action, LocalDateTime timestamp) {
        super();
        this.id = id;
        this.floorId = floorId;
        this.floorName = floorName;
        this.floorDesc = floorDesc;
        this.action = action;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "FloorHistoryMaster [id=" + id + ", floorId=" + floorId + ", floorName="
                + floorName + ", floorDesc=" + floorDesc + ", action=" + action + ", timestamp="
                + timestamp + "]";
    }
}
