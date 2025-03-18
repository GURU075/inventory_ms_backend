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
@Table(name = "tblModel")
public class ModelMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer modelId;
    
    @NotNull(message = "Model name cannot be null")
    @Size(min = 1, max = 50, message = "Model name must be between 1 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Model name must contain only letters and spaces")
    private String modelName;
    
    @Size(max = 200, message = "Description must be less than 200 characters")
    private String modelDesc;
        
    public Integer getModelId() {
        return modelId;
    }
    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }
    public String getModelName() {
        return modelName;
    }
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    public String getModelDesc() {
        return modelDesc;
    }
    public void setModelDesc(String modelDesc) {
        this.modelDesc = modelDesc;
    }
    public ModelMaster() {
        super();
    }
    public ModelMaster(Integer modelId, String modelName, String modelDesc) {
        super();
        this.modelId = modelId;
        this.modelName = modelName;
        this.modelDesc = modelDesc;
    }
    @Override
    public String toString() {
        return "ModelMaster [modelId=" + modelId + ", modelName=" + modelName
                + ", modelDesc=" + modelDesc + "]";
    }
}
