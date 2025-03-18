package IMS.Master;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblAssetSoftwarePropertyDetailHistory")
public class AssetSoftwarePropertyDetailHistoryMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private int assetSoftwareDetailId;
    
    private String assetSoftwarePropertyName;
    
    private String assetSoftwarePropertyValue;
    
    private int assetId;
    
    private String action;
    
    private LocalDateTime timestamp;
    
    @PrePersist
    private void onCreate() {
        timestamp = LocalDateTime.now();
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAssetSoftwareDetailId() {
        return assetSoftwareDetailId;
    }

    public void setAssetSoftwareDetailId(int assetSoftwareDetailId) {
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

    public int getAssetId() {
        return assetId;
    }

    public void setAssetId(int assetId) {
        this.assetId = assetId;
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

    // Constructors
    public AssetSoftwarePropertyDetailHistoryMaster() {
        super();
    }

    public AssetSoftwarePropertyDetailHistoryMaster(Integer id, int assetSoftwareDetailId, String assetSoftwarePropertyName,
            String assetSoftwarePropertyValue, int assetId, String action, LocalDateTime timestamp) {
        super();
        this.id = id;
        this.assetSoftwareDetailId = assetSoftwareDetailId;
        this.assetSoftwarePropertyName = assetSoftwarePropertyName;
        this.assetSoftwarePropertyValue = assetSoftwarePropertyValue;
        this.assetId = assetId;
        this.action = action;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "AssetSoftwarePropertyDetailHistoryMaster [id=" + id + ", assetSoftwareDetailId=" + assetSoftwareDetailId
                + ", assetSoftwarePropertyName=" + assetSoftwarePropertyName + ", assetSoftwarePropertyValue="
                + assetSoftwarePropertyValue + ", assetId=" + assetId + ", action=" + action + ", timestamp="
                + timestamp + "]";
    }
}
