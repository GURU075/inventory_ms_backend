package IMS.Master;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tblfloor")
public class FloorMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer floorId;
    
    @NotNull(message = "Floor name cannot be null")
    @Size(min = 1, max = 50, message = "Floor name must be between 1 and 50 characters")
    private String floorName;
    
    @Size(max = 200, message = "Description must be less than 200 characters")
    private String floorDesc;
        
    public Integer getFloorId() {
        return floorId;
    }
    public void setFloorId(Integer floorId) {
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
    public FloorMaster() {
        super();
    }
    public FloorMaster(Integer floorId, String floorName, String floorDesc) {
        super();
        this.floorId = floorId;
        this.floorName = floorName;
        this.floorDesc = floorDesc;
    }
    @Override
    public String toString() {
        return "FloorMaster [floorId=" + floorId + ", floorName=" + floorName
                + ", floorDesc=" + floorDesc + "]";
    }
}
