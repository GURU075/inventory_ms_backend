package IMS.Master;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tblAssetDetails")
public class AssetDetailsMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer assetDetailsId;
    
//    @NotNull(message = "Asset property name cannot be null")
//    @Size(min = 1, max = 100, message = "Asset property name must be between 1 and 100 characters")
    private String assetPropertyName;
    
//    @NotNull(message = "Asset property value cannot be null") 
//    @Size(min = 1, max = 200, message = "Asset property value must be between 1 and 200 characters") 
//    @Pattern(regexp = ".*[a-zA-Z].*", message = "Asset property value must contain at least one letter") 
//    @Pattern(regexp = ".*\\d.*", message = "Asset property value must contain at least one number") 
    private String assetPropertyValue;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "assetId")
    private AssetMaster asset;

	public Integer getAssetDetailsId() {
		return assetDetailsId;
	}

	public void setAssetDetailsId(Integer assetDetailsId) {
		this.assetDetailsId = assetDetailsId;
	}

	public String getAssetPropertyName() {
		return assetPropertyName;
	}

	public void setAssetPropertyName(String assetPropertyName) {
		this.assetPropertyName = assetPropertyName;
	}

	public String getAssetPropertyValue() {
		return assetPropertyValue;
	}

	public void setAssetPropertyValue(String assetPropertyValue) {
		this.assetPropertyValue = assetPropertyValue;
	}

	public AssetMaster getAsset() {
		return asset;
	}

	public void setAsset(AssetMaster asset) {
		this.asset = asset;
	}

	public AssetDetailsMaster() {
		super();
	}

	public AssetDetailsMaster(Integer assetDetailsId,
	       String assetPropertyName,
			       String assetPropertyValue,
			AssetMaster asset) {
		super();
		this.assetDetailsId = assetDetailsId;
		this.assetPropertyName = assetPropertyName;
		this.assetPropertyValue = assetPropertyValue;
		this.asset = asset;
	}

	@Override
	public String toString() {
		return "AssetDetailsMaster [assetDetailsId=" + assetDetailsId + ", assetPropertyName=" + assetPropertyName
				+ ", assetPropertyValue=" + assetPropertyValue + ", asset=" + asset + "]";
	}
}
