package IMS.Master;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblLocationHistory")
public class LocationHistoryMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private int locationId;
    
    private String locationName;
    
    private String locationDesc;
    
    private String action; 
    
    private LocalDateTime timestamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationDesc() {
        return locationDesc;
    }

    public void setLocationDesc(String locationDesc) {
        this.locationDesc = locationDesc;
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

    public LocationHistoryMaster() {
        super();
    }

    public LocationHistoryMaster(Integer id, String action) {
        this.id = id;
        this.action = action;
    }

    public LocationHistoryMaster(Integer id, int locationId, String locationName, String locationDesc,
            String action, LocalDateTime timestamp) {
        super();
        this.id = id;
        this.locationId = locationId;
        this.locationName = locationName;
        this.locationDesc = locationDesc;
        this.action = action;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "LocationHistoryMaster [id=" + id + ", locationId=" + locationId + ", locationName="
                + locationName + ", locationDesc=" + locationDesc + ", action=" + action + ", timestamp="
                + timestamp + "]";
    }
}
