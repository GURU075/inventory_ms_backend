package IMS.Master;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tblAssetHistoryNew")
public class AssetHistoryMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int assetId;

    private String assetDesc;

    private String assetBarCode;

    private Date amcStartDate;

    private Date amcEndDate;

    private String assetAllocationTo;

    private Date assetAllocationDate;
    
    private int locationId;
    
    private int categoryId;
    
    private int subCategoryId;
    
    private String allocationType;
    
    private String warrantyStatus;

    private String action;

    @NotNull
    private LocalDateTime timestamp;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public String getAssetDesc() {
		return assetDesc;
	}

	public void setAssetDesc(String assetDesc) {
		this.assetDesc = assetDesc;
	}

	public String getAssetBarCode() {
		return assetBarCode;
	}

	public void setAssetBarCode(String assetBarCode) {
		this.assetBarCode = assetBarCode;
	}

	public Date getAmcStartDate() {
		return amcStartDate;
	}

	public void setAmcStartDate(Date amcStartDate) {
		this.amcStartDate = amcStartDate;
	}

	public Date getAmcEndDate() {
		return amcEndDate;
	}

	public void setAmcEndDate(Date amcEndDate) {
		this.amcEndDate = amcEndDate;
	}

	public String getAssetAllocationTo() {
		return assetAllocationTo;
	}

	public void setAssetAllocationTo(String assetAllocationTo) {
		this.assetAllocationTo = assetAllocationTo;
	}

	public Date getAssetAllocationDate() {
		return assetAllocationDate;
	}

	public void setAssetAllocationDate(Date assetAllocationDate) {
		this.assetAllocationDate = assetAllocationDate;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getAllocationType() {
		return allocationType;
	}

	public void setAllocationType(String allocationType) {
		this.allocationType = allocationType;
	}

	public String getWarrantyStatus() {
		return warrantyStatus;
	}

	public void setWarrantyStatus(String warrantyStatus) {
		this.warrantyStatus = warrantyStatus;
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

	public AssetHistoryMaster() {
		super();
	}
	
	public AssetHistoryMaster(Integer id, String action) {
        super();
        this.id = id;
        this.action = action;
    }

	public AssetHistoryMaster(Integer id, int assetId, String assetDesc, String assetBarCode, Date amcStartDate,
			Date amcEndDate, String assetAllocationTo, Date assetAllocationDate, int locationId, int categoryId,
			int subCategoryId, String allocationType, String warrantyStatus, String action,
			@NotNull LocalDateTime timestamp) {
		super();
		this.id = id;
		this.assetId = assetId;
		this.assetDesc = assetDesc;
		this.assetBarCode = assetBarCode;
		this.amcStartDate = amcStartDate;
		this.amcEndDate = amcEndDate;
		this.assetAllocationTo = assetAllocationTo;
		this.assetAllocationDate = assetAllocationDate;
		this.locationId = locationId;
		this.categoryId = categoryId;
		this.subCategoryId = subCategoryId;
		this.allocationType = allocationType;
		this.warrantyStatus = warrantyStatus;
		this.action = action;
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "AssetHistoryMaster [id=" + id + ", assetId=" + assetId + ", assetDesc=" + assetDesc + ", assetBarCode="
				+ assetBarCode + ", amcStartDate=" + amcStartDate + ", amcEndDate=" + amcEndDate
				+ ", assetAllocationTo=" + assetAllocationTo + ", assetAllocationDate=" + assetAllocationDate
				+ ", locationId=" + locationId + ", categoryId=" + categoryId + ", subCategoryId=" + subCategoryId
				+ ", allocationType=" + allocationType + ", warrantyStatus=" + warrantyStatus + ", action=" + action
				+ ", timestamp=" + timestamp + "]";
	}

}
