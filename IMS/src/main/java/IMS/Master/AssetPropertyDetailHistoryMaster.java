package IMS.Master;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblAssetPropertyDetailHistory")
public class AssetPropertyDetailHistoryMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private int assetPropertyDetailId;
    
    private String assetPropertyDetailName;
    
    private String assetPropertyDetailValue;

    private int assetId;
    
    private String action;
    
    private LocalDateTime timestamp;

    @PrePersist
    private void onCreate() {
        timestamp = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAssetPropertyDetailId() {
        return assetPropertyDetailId;
    }

    public void setAssetPropertyDetailId(int assetPropertyDetailId) {
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

    public AssetPropertyDetailHistoryMaster() {
        super();
    }

    public AssetPropertyDetailHistoryMaster(Integer id, String action) {
        super();
        this.id = id;
        this.action = action;
    }

    public AssetPropertyDetailHistoryMaster(Integer id, int assetPropertyDetailId, String assetPropertyDetailName, 
                                             String assetPropertyDetailValue, int assetId, String action, LocalDateTime timestamp) {
        super();
        this.id = id;
        this.assetPropertyDetailId = assetPropertyDetailId;
        this.assetPropertyDetailName = assetPropertyDetailName;
        this.assetPropertyDetailValue = assetPropertyDetailValue;
        this.assetId = assetId;
        this.action = action;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "AssetPropertyDetailHistoryMaster [id=" + id + ", assetPropertyDetailId=" + assetPropertyDetailId 
                + ", assetPropertyDetailName=" + assetPropertyDetailName + ", assetPropertyDetailValue=" 
                + assetPropertyDetailValue + ", assetId=" + assetId + ", action=" + action + ", timestamp=" 
                + timestamp + "]";
    }
}
