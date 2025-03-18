package IMS.Master;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tblWarrantyStatus")
public class WarrantyStatusMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer warrantyStatusId;
    
    @NotNull(message = "Warranty status name cannot be null")
    @Size(min = 1, max = 50, message = "Warranty status name must be between 1 and 50 characters")
    private String warrantyStatusName;
    
    @NotNull(message = "Warranty status Desc cannot be null")
    @Size(min = 2, max = 200, message = "Warranty status name must be between 1 and 200 characters")
    private String warrantyStatusDesc;

	public Integer getWarrantyStatusId() {
		return warrantyStatusId;
	}

	public void setWarrantyStatusId(Integer warrantyStatusId) {
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

	public WarrantyStatusMaster() {
		super();
	}

	public WarrantyStatusMaster(Integer warrantyStatusId,
			@NotNull(message = "Warranty status name cannot be null") @Size(min = 1, max = 50, message = "Warranty status name must be between 1 and 50 characters") String warrantyStatusName,
			@NotNull(message = "Warranty status Desc cannot be null") @Size(min = 2, max = 200, message = "Warranty status name must be between 1 and 200 characters") String warrantyStatusDesc) {
		super();
		this.warrantyStatusId = warrantyStatusId;
		this.warrantyStatusName = warrantyStatusName;
		this.warrantyStatusDesc = warrantyStatusDesc;
	}

	@Override
	public String toString() {
		return "WarrantyStatusMaster [warrantyStatusId=" + warrantyStatusId + ", warrantyStatusName="
				+ warrantyStatusName + ", warrantyStatusDesc=" + warrantyStatusDesc + "]";
	}
}
