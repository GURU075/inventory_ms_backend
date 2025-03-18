package IMS.Master;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tblPODetail")
public class PODetailMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer poDetailId;

    @NotNull(message = "Asset Quantity cannot be null")
    private Integer assetQty;

    @NotNull(message = "Asset Rate cannot be null")
    private Double assetRate;

    @ManyToOne
    @JoinColumn(name = "poId", nullable = false)
    private PurchaseOrderMaster purchaseOrder;

    @ManyToOne
    @JoinColumn(name = "assetId", nullable = false)
    private AssetMaster asset;

    // Getters and Setters
    public Integer getPoDetailId() {
        return poDetailId;
    }

    public void setPoDetailId(Integer poDetailId) {
        this.poDetailId = poDetailId;
    }

    public Integer getAssetQty() {
        return assetQty;
    }

    public void setAssetQty(Integer assetQty) {
        this.assetQty = assetQty;
    }

    public Double getAssetRate() {
        return assetRate;
    }

    public void setAssetRate(Double assetRate) {
        this.assetRate = assetRate;
    }

    public PurchaseOrderMaster getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrderMaster purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public AssetMaster getAsset() {
        return asset;
    }

    public void setAsset(AssetMaster asset) {
        this.asset = asset;
    }

    // Constructors
    public PODetailMaster() {
        super();
    }

    public PODetailMaster(Integer poDetailId, @NotNull(message = "Asset Quantity cannot be null") Integer assetQty,
                          @NotNull(message = "Asset Rate cannot be null") Double assetRate,
                          PurchaseOrderMaster purchaseOrder, AssetMaster asset) {
        super();
        this.poDetailId = poDetailId;
        this.assetQty = assetQty;
        this.assetRate = assetRate;
        this.purchaseOrder = purchaseOrder;
        this.asset = asset;
    }

    @Override
    public String toString() {
        return "PODetailMaster [poDetailId=" + poDetailId + ", assetQty=" + assetQty + ", assetRate=" + assetRate
                + ", purchaseOrder=" + purchaseOrder + ", asset=" + asset + "]";
    }
}
