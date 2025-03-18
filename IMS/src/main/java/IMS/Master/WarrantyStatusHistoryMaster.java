package IMS.Master;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblWarrantyStatusHistory")
public class WarrantyStatusHistoryMaster {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    private int warrantyStatusId;
    
    private String warrantyStatusName;
    
    private String warrantyStatusDesc;

    private String action; 
    
    private LocalDateTime timestamp;
    
    @PrePersist 
    private void onCreate() { 
        timestamp = LocalDateTime.now(); 
    }

    

    public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public int getWarrantyStatusId() {
		return warrantyStatusId;
	}



	public void setWarrantyStatusId(int warrantyStatusId) {
		this.warrantyStatusId = warrantyStatusId;
	}



	public String getWarrantyStatusName() {
		return warrantyStatusName;
	}



	public void setWarrantyStatusName(String warrantyStatusName) {
		this.warrantyStatusName = warrantyStatusName;
	}



	public String getWarrantyStatusDesc() {
		return warrantyStatusDesc;
	}



	public void setWarrantyStatusDesc(String warrantyStatusDesc) {
		this.warrantyStatusDesc = warrantyStatusDesc;
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



	public WarrantyStatusHistoryMaster() {
        super();
    }

    public WarrantyStatusHistoryMaster(Integer id, String action) {
        super();
        this.id = id;
        this.action = action;
    }



	public WarrantyStatusHistoryMaster(Integer id, int warrantyStatusId, String warrantyStatusName,
			String warrantyStatusDesc, String action, LocalDateTime timestamp) {
		super();
		this.id = id;
		this.warrantyStatusId = warrantyStatusId;
		this.warrantyStatusName = warrantyStatusName;
		this.warrantyStatusDesc = warrantyStatusDesc;
		this.action = action;
		this.timestamp = timestamp;
	}



	@Override
	public String toString() {
		return "WarrantyStatusHistoryMaster [id=" + id + ", warrantyStatusId=" + warrantyStatusId
				+ ", warrantyStatusName=" + warrantyStatusName + ", warrantyStatusDesc=" + warrantyStatusDesc
				+ ", action=" + action + ", timestamp=" + timestamp + "]";
	}
}
