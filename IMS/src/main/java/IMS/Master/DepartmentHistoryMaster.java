package IMS.Master;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblDepartmentHistory")
public class DepartmentHistoryMaster {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    private int deptId;
    
    private String deptName;
    
    private String deptDesc;
    
    private String deptContactPersonName;
    
    private String deptContactPersonEmail;
    
    private String deptContactPersonMobile;

    private int locationId;
    
    private int floorId;

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



	public int getDeptId() {
		return deptId;
	}



	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}



	public String getDeptName() {
		return deptName;
	}



	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}



	public String getDeptDesc() {
		return deptDesc;
	}



	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}



	public String getDeptContactPersonName() {
		return deptContactPersonName;
	}



	public void setDeptContactPersonName(String deptContactPersonName) {
		this.deptContactPersonName = deptContactPersonName;
	}



	public String getDeptContactPersonEmail() {
		return deptContactPersonEmail;
	}



	public void setDeptContactPersonEmail(String deptContactPersonEmail) {
		this.deptContactPersonEmail = deptContactPersonEmail;
	}



	public String getDeptContactPersonMobile() {
		return deptContactPersonMobile;
	}



	public void setDeptContactPersonMobile(String deptContactPersonMobile) {
		this.deptContactPersonMobile = deptContactPersonMobile;
	}



	public int getLocationId() {
		return locationId;
	}



	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}



	public int getFloorId() {
		return floorId;
	}



	public void setFloorId(int floorId) {
		this.floorId = floorId;
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



	public DepartmentHistoryMaster(Integer id, String action) {
        super();
        this.id = id;
        this.action = action;
    }



	public DepartmentHistoryMaster() {
		super();
	}



	public DepartmentHistoryMaster(Integer id, int deptId, String deptName, String deptDesc,
			String deptContactPersonName, String deptContactPersonEmail, String deptContactPersonMobile, int locationId,
			int floorId, String action, LocalDateTime timestamp) {
		super();
		this.id = id;
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptDesc = deptDesc;
		this.deptContactPersonName = deptContactPersonName;
		this.deptContactPersonEmail = deptContactPersonEmail;
		this.deptContactPersonMobile = deptContactPersonMobile;
		this.locationId = locationId;
		this.floorId = floorId;
		this.action = action;
		this.timestamp = timestamp;
	}



	@Override
	public String toString() {
		return "DepartmentHistoryMaster [id=" + id + ", deptId=" + deptId + ", deptName=" + deptName + ", deptDesc="
				+ deptDesc + ", deptContactPersonName=" + deptContactPersonName + ", deptContactPersonEmail="
				+ deptContactPersonEmail + ", deptContactPersonMobile=" + deptContactPersonMobile + ", locationId="
				+ locationId + ", floorId=" + floorId + ", action=" + action + ", timestamp=" + timestamp + "]";
	}
    
}
