package IMS.Master;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tblAssetMaster")
public class AssetMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer assetId;

    @NotNull
    @Size(min = 1, max = 100)
    private String assetDesc;


    private String assetBarCode;

    @NotNull
    @PastOrPresent(message = "AMC start date must be in the past or present")
    private Date amcStartDate;

    
    @FutureOrPresent(message = "AMC end date must be in the future or present")
    private Date amcEndDate;

    @NotNull(message = "Allocation type name cannot be null")
    @Size(min = 1, max = 50, message = "Allocation type name must be between 1 and 50 characters")
    private String assetAllocationTo;

    @PastOrPresent(message = "AMC start date must be in the past or present")
    private Date assetAllocationDate;
    
    private String warrentyStatus;
    
    private String allocationType;
    
    // Relationships to other tables
    @ManyToOne
    @JoinColumn(name = "locationId")
    private LocationMaster location;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private CategoryMaster category;

    @ManyToOne
    @JoinColumn(name = "subCategoryId")
    private SubCategoryMaster subCategory;

	public Integer getAssetId() {
		return assetId;
	}

	public void setAssetId(Integer assetId) {
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

	public String getWarrentyStatus() {
		return warrentyStatus;
	}

	public void setWarrentyStatus(String warrentyStatus) {
		this.warrentyStatus = warrentyStatus;
	}

	public String getAllocationType() {
		return allocationType;
	}

	public void setAllocationType(String allocationType) {
		this.allocationType = allocationType;
	}

	public LocationMaster getLocation() {
		return location;
	}

	public void setLocation(LocationMaster location) {
		this.location = location;
	}

	public CategoryMaster getCategory() {
		return category;
	}

	public void setCategory(CategoryMaster category) {
		this.category = category;
	}

	public SubCategoryMaster getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategoryMaster subCategory) {
		this.subCategory = subCategory;
	}

	public AssetMaster() {
		super();
	}

	public AssetMaster(Integer assetId, @NotNull @Size(min = 1, max = 100) String assetDesc, String assetBarCode,
			@NotNull @PastOrPresent(message = "AMC start date must be in the past or present") Date amcStartDate,
			@NotNull @FutureOrPresent(message = "AMC end date must be in the future or present") Date amcEndDate,
			@NotNull(message = "Allocation type name cannot be null") @Size(min = 1, max = 50, message = "Allocation type name must be between 1 and 50 characters") String assetAllocationTo,
			@PastOrPresent(message = "AMC start date must be in the past or present") Date assetAllocationDate,
			String warrentyStatus, String allocationType, LocationMaster location, CategoryMaster category,
			SubCategoryMaster subCategory) {
		super();
		this.assetId = assetId;
		this.assetDesc = assetDesc;
		this.assetBarCode = assetBarCode;
		this.amcStartDate = amcStartDate;
		this.amcEndDate = amcEndDate;
		this.assetAllocationTo = assetAllocationTo;
		this.assetAllocationDate = assetAllocationDate;
		this.warrentyStatus = warrentyStatus;
		this.allocationType = allocationType;
		this.location = location;
		this.category = category;
		this.subCategory = subCategory;
	}

	@Override
	public String toString() {
		return "AssetMaster [assetId=" + assetId + ", assetDesc=" + assetDesc + ", assetBarCode=" + assetBarCode
				+ ", amcStartDate=" + amcStartDate + ", amcEndDate=" + amcEndDate + ", assetAllocationTo="
				+ assetAllocationTo + ", assetAllocationDate=" + assetAllocationDate + ", warrentyStatus="
				+ warrentyStatus + ", allocationType=" + allocationType + ", location=" + location + ", category="
				+ category + ", subCategory=" + subCategory + "]";
	}

}
