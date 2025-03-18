package IMS.Master;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tblDepartment")
public class DepartmentMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deptId;
    
    @NotNull(message = "Department name cannot be null")
    @Size(min = 1, max = 50, message = "Department name must be between 1 and 50 characters")
    private String deptName;
    
    @Size(max = 200, message = "Description must be less than 200 characters")
    private String deptDesc;
    
    @Size(max = 50, message = "name must be less than 50 characters")
    private String deptContactPersonName;
    
    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String deptContactPersonEmail;
    
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digits")
    private String deptContactPersonMobile;
    
    @ManyToOne
    @JoinColumn(name = "locationId", nullable = false)
    private LocationMaster location;
    
    @ManyToOne
    @JoinColumn(name = "floorId", nullable = false)
    private FloorMaster floor;

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
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

	public LocationMaster getLocation() {
		return location;
	}

	public void setLocation(LocationMaster location) {
		this.location = location;
	}

	public FloorMaster getFloor() {
		return floor;
	}

	public void setFloor(FloorMaster floor) {
		this.floor = floor;
	}

	public DepartmentMaster() {
		super();
	}

	public DepartmentMaster(Integer deptId,
			@NotNull(message = "Department name cannot be null") @Size(min = 1, max = 50, message = "Department name must be between 1 and 50 characters") String deptName,
			@Size(max = 200, message = "Description must be less than 200 characters") String deptDesc,
			@Size(max = 50, message = "name must be less than 50 characters") String deptContactPersonName,
			@NotNull(message = "Email cannot be null") @Email(message = "Email should be valid") String deptContactPersonEmail,
			@Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digits") String deptContactPersonMobile,
			LocationMaster location, FloorMaster floor) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptDesc = deptDesc;
		this.deptContactPersonName = deptContactPersonName;
		this.deptContactPersonEmail = deptContactPersonEmail;
		this.deptContactPersonMobile = deptContactPersonMobile;
		this.location = location;
		this.floor = floor;
	}

	@Override
	public String toString() {
		return "DepartmentMaster [deptId=" + deptId + ", deptName=" + deptName + ", deptDesc=" + deptDesc
				+ ", deptContactPersonName=" + deptContactPersonName + ", deptContactPersonEmail="
				+ deptContactPersonEmail + ", deptContactPersonMobile=" + deptContactPersonMobile + ", location="
				+ location + ", floor=" + floor + "]";
	}
    
}
