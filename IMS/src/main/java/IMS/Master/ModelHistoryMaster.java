package IMS.Master;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblModelHistory")
public class ModelHistoryMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private int modelId;
    
    private String modelName;
    
    private String modelDesc;
    
    private String action; 
    
    private LocalDateTime timestamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
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

    public ModelHistoryMaster() {
        super();
    }

    public ModelHistoryMaster(Integer id, String action) {
        this.id = id;
        this.action = action;
    }

    public ModelHistoryMaster(Integer id, int modelId, String modelName, String modelDesc,
            String action, LocalDateTime timestamp) {
        super();
        this.id = id;
        this.modelId = modelId;
        this.modelName = modelName;
        this.modelDesc = modelDesc;
        this.action = action;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ModelHistoryMaster [id=" + id + ", modelId=" + modelId + ", modelName="
                + modelName + ", modelDesc=" + modelDesc + ", action=" + action + ", timestamp="
                + timestamp + "]";
    }
}
