package IMS.Master;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblMakeHistory")
public class MakeHistoryMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private int makeId;
    
    private String makeName;
    
    private String makeDesc;
    
    private String action; 
    
    private LocalDateTime timestamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getMakeId() {
        return makeId;
    }

    public void setMakeId(int makeId) {
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

    public MakeHistoryMaster() {
        super();
    }

    public MakeHistoryMaster(Integer id, String action) {
        this.id = id;
        this.action = action;
    }

    public MakeHistoryMaster(Integer id, int makeId, String makeName, String makeDesc,
            String action, LocalDateTime timestamp) {
        super();
        this.id = id;
        this.makeId = makeId;
        this.makeName = makeName;
        this.makeDesc = makeDesc;
        this.action = action;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "MakeHistoryMaster [id=" + id + ", makeId=" + makeId + ", makeName="
                + makeName + ", makeDesc=" + makeDesc + ", action=" + action + ", timestamp="
                + timestamp + "]";
    }
}
