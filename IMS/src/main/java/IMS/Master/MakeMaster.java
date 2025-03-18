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
@Table(name = "tblMake")
public class MakeMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer makeId;
    
    @NotNull(message = "Make name cannot be null")
    @Size(min = 1, max = 50, message = "Make name must be between 1 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Make name must contain only letters and spaces")
    private String makeName;
    
    @Size(max = 200, message = "Description must be less than 200 characters")
    private String makeDesc;
        
    public Integer getMakeId() {
        return makeId;
    }
    public void setMakeId(Integer makeId) {
        this.makeId = makeId;
    }
    public String getMakeName() {
        return makeName;
    }
    public void setMakeName(String makeName) {
        this.makeName = makeName;
    }
    public String getMakeDesc() {
        return makeDesc;
    }
    public void setMakeDesc(String makeDesc) {
        this.makeDesc = makeDesc;
    }
    public MakeMaster() {
        super();
    }
    public MakeMaster(Integer makeId, String makeName, String makeDesc) {
        super();
        this.makeId = makeId;
        this.makeName = makeName;
        this.makeDesc = makeDesc;
    }
    @Override
    public String toString() {
        return "MakeMaster [makeId=" + makeId + ", makeName=" + makeName
                + ", makeDesc=" + makeDesc + "]";
    }
}
