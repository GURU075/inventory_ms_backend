package IMS.Master;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tblAssetStatus")
public class AssetStatusMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer assetStatusId;
    
    @NotNull(message = "Asset Status Name cannot be null")
    @Size(min = 1, max = 50, message = "Asset status must be between 1 and 50 characters")
    private String assetStatusName;
    
    
    @NotNull(message = "Asset Status Desc cannot be null")
    @Size(min = 3, max = 200, message = "Asset status must be between 3 and 200 characters")
    private String assetStatusDesc;


	public Integer getAssetStatusId() {
		return assetStatusId;
	}


	public void setAssetStatusId(Integer assetStatusId) {
		this.assetStatusId = assetStatusId;
	}


	public String getAssetStatusName() {
		return assetStatusName;
	}


	public void setAssetStatusName(String assetStatusName) {
		this.assetStatusName = assetStatusName;
	}


	public String getAssetStatusDesc() {
		return assetStatusDesc;
	}


	public void setAssetStatusDesc(String assetStatusDesc) {
		this.assetStatusDesc = assetStatusDesc;
	}


	public AssetStatusMaster() {
		super();
	}


	public AssetStatusMaster(Integer assetStatusId,
			@NotNull(message = "Asset status cannot be null") @Size(min = 1, max = 50, message = "Asset status must be between 1 and 50 characters") String assetStatusName,
			@NotNull(message = "Asset status cannot be null") @Size(min = 3, max = 200, message = "Asset status must be between 1 and 50 characters") String assetStatusDesc) {
		super();
		this.assetStatusId = assetStatusId;
		this.assetStatusName = assetStatusName;
		this.assetStatusDesc = assetStatusDesc;
	}


	@Override
	public String toString() {
		return "AssetStatusMaster [assetStatusId=" + assetStatusId + ", assetStatusName=" + assetStatusName
				+ ", assetStatusDesc=" + assetStatusDesc + "]";
	}
}
