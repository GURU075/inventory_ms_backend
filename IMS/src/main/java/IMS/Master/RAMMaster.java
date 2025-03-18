package IMS.Master;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tblRAM")
public class RAMMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ramId;
    
    @NotNull(message = "RAM name cannot be null")
    @Size(min = 1, max = 50, message = "RAM name must be between 1 and 50 characters")
    private String ramName;
    
    @Size(max = 200, message = "Description must be less than 200 characters")
    private String ramDesc;
        
    public Integer getRamId() {
        return ramId;
    }
    public void setRamId(Integer ramId) {
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
    public RAMMaster() {
        super();
    }
    public RAMMaster(Integer ramId, String ramName, String ramDesc) {
        super();
        this.ramId = ramId;
        this.ramName = ramName;
        this.ramDesc = ramDesc;
    }
    @Override
    public String toString() {
        return "RAMMaster [ramId=" + ramId + ", ramName=" + ramName
                + ", ramDesc=" + ramDesc + "]";
    }
}
