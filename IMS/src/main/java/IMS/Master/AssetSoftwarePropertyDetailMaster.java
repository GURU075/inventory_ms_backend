package IMS.Master;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tblAssetSoftwarePropertyDetail")
public class AssetSoftwarePropertyDetailMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer assetSoftwareDetailId;
    
    @NotNull(message = "Asset Software Property Name cannot be null")
    @Size(min = 1, max = 50, message = "Asset Software Property Name must be between 1 and 50 characters")
    private String assetSoftwarePropertyName;
    
    @Size(max = 100, message = "Asset Software Property Value must be less than 100 characters")
    private String assetSoftwarePropertyValue;
    
    @ManyToOne
    @JoinColumn(name = "AssetId", nullable = false)
    private AssetMaster asset;

	public Integer getAssetSoftwareDetailId() {
		return assetSoftwareDetailId;
	}

	public void setAssetSoftwareDetailId(Integer assetSoftwareDetailId) {
		this.assetSoftwareDetailId = assetSoftwareDetailId;
	}

	public String getAssetSoftwarePropertyName() {
		return assetSoftwarePropertyName;
	}

	public void setAssetSoftwarePropertyName(String assetSoftwarePropertyName) {
		this.assetSoftwarePropertyName = assetSoftwarePropertyName;
	}

	public String getAssetSoftwarePropertyValue() {
		return assetSoftwarePropertyValue;
	}

	public void setAssetSoftwarePropertyValue(String assetSoftwarePropertyValue) {
		this.assetSoftwarePropertyValue = assetSoftwarePropertyValue;
	}

	public AssetMaster getAsset() {
		return asset;
	}

	public void setAsset(AssetMaster asset) {
		this.asset = asset;
	}

	public AssetSoftwarePropertyDetailMaster() {
		super();
	}

	public AssetSoftwarePropertyDetailMaster(Integer assetSoftwareDetailId,
			@NotNull(message = "Asset Software Property Name cannot be null") @Size(min = 1, max = 50, message = "Asset Software Property Name must be between 1 and 50 characters") String assetSoftwarePropertyName,
			@Size(max = 100, message = "Asset Software Property Value must be less than 100 characters") String assetSoftwarePropertyValue,
			AssetMaster asset) {
		super();
		this.assetSoftwareDetailId = assetSoftwareDetailId;
		this.assetSoftwarePropertyName = assetSoftwarePropertyName;
		this.assetSoftwarePropertyValue = assetSoftwarePropertyValue;
		this.asset = asset;
	}

	@Override
	public String toString() {
		return "AssetSoftwarePropertyDetailMaster [assetSoftwareDetailId=" + assetSoftwareDetailId
				+ ", assetSoftwarePropertyName=" + assetSoftwarePropertyName + ", assetSoftwarePropertyValue="
				+ assetSoftwarePropertyValue + ", asset=" + asset + "]";
	}
}
