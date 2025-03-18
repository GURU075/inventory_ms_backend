package IMS.Master;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tbldesignation")
public class DesignationMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer designationId;
    
    @NotNull(message = "Designation name cannot be null")
    @Size(min = 1, max = 50, message = "Designation name must be between 1 and 50 characters")
    private String designationName;
    
    @Size(max = 200, message = "Description must be less than 200 characters")
    private String designationDesc;
        
    public Integer getDesignationId() {
        return designationId;
    }
    public void setDesignationId(Integer designationId) {
        this.designationId = designationId;
    }
    public String getDesignationName() {
        return designationName;
    }
    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }
    public String getDesignationDesc() {
        return designationDesc;
    }
    public void setDesignationDesc(String designationDesc) {
        this.designationDesc = designationDesc;
    }
    public DesignationMaster() {
        super();
    }
    public DesignationMaster(Integer designationId, String designationName, String designationDesc) {
        super();
        this.designationId = designationId;
        this.designationName = designationName;
        this.designationDesc = designationDesc;
    }
    @Override
    public String toString() {
        return "DesignationMaster [designationId=" + designationId + ", designationName=" + designationName
                + ", designationDesc=" + designationDesc + "]";
    }
}
