package IMS.Master;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbldesignationHistory")
public class DesignationHistoryMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private int designationId;
	
	private String designationName;
	
	private String designationDesc;
	
    private String action; 
    
    private LocalDateTime timestamp;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getDesignationId() {
		return designationId;
	}

	public void setDesignationId(int designationId) {
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

	public DesignationHistoryMaster() {
		super();
	}	
	
	public DesignationHistoryMaster(Integer id, String action)
	{
		this.id = id;
		this.action = action;
		
	}

	public DesignationHistoryMaster(Integer id, int designationId, String designationName, String designationDesc,
			String action, LocalDateTime timestamp) {
		super();
		this.id = id;
		this.designationId = designationId;
		this.designationName = designationName;
		this.designationDesc = designationDesc;
		this.action = action;
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "DesignationHistoryMaster [id=" + id + ", designationId=" + designationId + ", designationName="
				+ designationName + ", designationDesc=" + designationDesc + ", action=" + action + ", timestamp="
				+ timestamp + "]";
	}	
}
