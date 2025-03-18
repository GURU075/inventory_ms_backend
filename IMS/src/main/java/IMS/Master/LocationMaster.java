package IMS.Master;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "tblLocation")
public class LocationMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer locationId;
    
    @NotNull(message = "Location name cannot be null")
    @Size(min = 1, max = 50, message = "Location name must be between 1 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Location name must contain only letters and spaces")
    private String locationName;
    
    @Size(max = 200, message = "Description must be less than 200 characters")
    private String locationDesc;
        
    public Integer getLocationId() {
        return locationId;
    }
    public void setLocationId(Integer locationId) {
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
    public LocationMaster() {
        super();
    }
    public LocationMaster(Integer locationId, String locationName, String locationDesc) {
        super();
        this.locationId = locationId;
        this.locationName = locationName;
        this.locationDesc = locationDesc;
    }
    @Override
    public String toString() {
        return "LocationMaster [locationId=" + locationId + ", locationName=" + locationName
                + ", locationDesc=" + locationDesc + "]";
    }
}
