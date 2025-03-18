package IMS.Master;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tblMIC")
public class MICMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer micId;
    
    @NotNull(message = "MIC name cannot be null")
    @Size(min = 1, max = 50, message = "MIC name must be between 1 and 50 characters")
    private String micName;
    
    @Size(max = 200, message = "Description must be less than 200 characters")
    private String micDesc;
        
    public Integer getMicId() {
        return micId;
    }
    public void setMicId(Integer micId) {
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
    public MICMaster() {
        super();
    }
    public MICMaster(Integer micId, String micName, String micDesc) {
        super();
        this.micId = micId;
        this.micName = micName;
        this.micDesc = micDesc;
    }
    @Override
    public String toString() {
        return "MICMaster [micId=" + micId + ", micName=" + micName
                + ", micDesc=" + micDesc + "]";
    }
}
