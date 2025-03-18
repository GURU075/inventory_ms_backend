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
@Table(name = "tblAssetPropertyDetail")
public class AssetPropertyDetailMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer assetPropertyDetailId;
    
//    @NotNull(message = "Asset property detail name cannot be null")
//    @Size(min = 1, max = 50, message = "Asset property detail name must be between 1 and 50 characters")
    private String assetPropertyDetailName;
    
//    @NotNull(message = "Asset property detail value cannot be null")
//    @Size(max = 200, message = "Asset property detail value must be less than 200 characters")
    private String assetPropertyDetailValue;
    
    @ManyToOne
    @JoinColumn(name = "assetId", nullable = false)
    private AssetMaster asset;

    public Integer getAssetPropertyDetailId() {
        return assetPropertyDetailId;
    }

    public void setAssetPropertyDetailId(Integer assetPropertyDetailId) {
        this.assetPropertyDetailId = assetPropertyDetailId;
    }

    public String getAssetPropertyDetailName() {
        return assetPropertyDetailName;
    }

    public void setAssetPropertyDetailName(String assetPropertyDetailName) {
        this.assetPropertyDetailName = assetPropertyDetailName;
    }

    public String getAssetPropertyDetailValue() {
        return assetPropertyDetailValue;
    }

    public void setAssetPropertyDetailValue(String assetPropertyDetailValue) {
        this.assetPropertyDetailValue = assetPropertyDetailValue;
    }

    public AssetMaster getAsset() {
        return asset;
    }

    public void setAsset(AssetMaster asset) {
        this.asset = asset;
    }

    public AssetPropertyDetailMaster() {
        super();
    }

    public AssetPropertyDetailMaster(Integer assetPropertyDetailId,
                             String assetPropertyDetailName,
                    String assetPropertyDetailValue,
                                     AssetMaster asset) {
        super();
        this.assetPropertyDetailId = assetPropertyDetailId;
        this.assetPropertyDetailName = assetPropertyDetailName;
        this.assetPropertyDetailValue = assetPropertyDetailValue;
        this.asset = asset;
    }

    @Override
    public String toString() {
        return "AssetPropertyDetailMaster [assetPropertyDetailId=" + assetPropertyDetailId + ", assetPropertyDetailName=" + assetPropertyDetailName
                + ", assetPropertyDetailValue=" + assetPropertyDetailValue + ", asset=" + asset + "]";
    }
}
