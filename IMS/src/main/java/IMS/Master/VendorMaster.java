package IMS.Master;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tblVendor")
public class VendorMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vendorId;
    
    @NotNull(message = "Vendor Name cannot be null")
    @Size(min = 1, max = 50, message = "Vendor Name must be between 1 and 50 characters")
    private String vendorName;
    
    @Size(max = 50, message = "Contact Person Name must be less than 50 characters")
    private String vendorContactPersonName;
    
    @Pattern(regexp = "^[0-9]{10}$", message = "Contact Person Number should be 10 digits")
    private String vendorContactPersonNumber;
    
    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String vendorContactPersonEmail;
    
    @Size(max = 200, message = "Address must be less than 200 characters")
    private String vendorAddress;

	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorContactPersonName() {
		return vendorContactPersonName;
	}

	public void setVendorContactPersonName(String vendorContactPersonName) {
		this.vendorContactPersonName = vendorContactPersonName;
	}

	public String getVendorContactPersonNumber() {
		return vendorContactPersonNumber;
	}

	public void setVendorContactPersonNumber(String vendorContactPersonNumber) {
		this.vendorContactPersonNumber = vendorContactPersonNumber;
	}

	public String getVendorContactPersonEmail() {
		return vendorContactPersonEmail;
	}

	public void setVendorContactPersonEmail(String vendorContactPersonEmail) {
		this.vendorContactPersonEmail = vendorContactPersonEmail;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public VendorMaster() {
		super();
	}

	public VendorMaster(Integer vendorId,
			@NotNull(message = "Vendor Name cannot be null") @Size(min = 1, max = 50, message = "Vendor Name must be between 1 and 50 characters") String vendorName,
			@Size(max = 50, message = "Contact Person Name must be less than 50 characters") String vendorContactPersonName,
			@Pattern(regexp = "^[0-9]{10}$", message = "Contact Person Number should be 10 digits") String vendorContactPersonNumber,
			@NotNull(message = "Email cannot be null") @Email(message = "Email should be valid") String vendorContactPersonEmail,
			@Size(max = 200, message = "Address must be less than 200 characters") String vendorAddress) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.vendorContactPersonName = vendorContactPersonName;
		this.vendorContactPersonNumber = vendorContactPersonNumber;
		this.vendorContactPersonEmail = vendorContactPersonEmail;
		this.vendorAddress = vendorAddress;
	}

	@Override
	public String toString() {
		return "VendorMaster [vendorId=" + vendorId + ", vendorName=" + vendorName + ", vendorContactPersonName="
				+ vendorContactPersonName + ", vendorContactPersonNumber=" + vendorContactPersonNumber
				+ ", vendorContactPersonEmail=" + vendorContactPersonEmail + ", vendorAddress=" + vendorAddress + "]";
	}
}
