package IMS.Master;

public class AssetFilterRequest {

	
	private String location;
    private String assetAllocationTo;
    private String allocationType;
    private String warrentyStatus;
    private String category;
    public AssetFilterRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AssetFilterRequest(String location, String assetAllocationTo, String allocationType, String warrentyStatus,
			String category, String subCategory) {
		super();
		this.location = location;
		this.assetAllocationTo = assetAllocationTo;
		this.allocationType = allocationType;
		this.warrentyStatus = warrentyStatus;
		this.category = category;
		this.subCategory = subCategory;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAllocatedTo() {
		return assetAllocationTo;
	}
	public void setAllocatedTo(String allocatedTo) {
		this.assetAllocationTo = allocatedTo;
	}
	public String getAllocationType() {
		return allocationType;
	}
	public void setAllocationType(String allocationType) {
		this.allocationType = allocationType;
	}
	public String getWarrantyStatus() {
		return warrentyStatus;
	}
	public void setWarrantyStatus(String warrantyStatus) {
		this.warrentyStatus = warrantyStatus;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	private String subCategory;
	@Override
	public String toString() {
		return "AssetFilterRequest [location=" + location + ", assetAllocationTo=" + assetAllocationTo + ", allocationType="
				+ allocationType + ", warrantyStatus=" + warrentyStatus + ", category=" + category + ", subCategory="
				+ subCategory + "]";
	}
}
