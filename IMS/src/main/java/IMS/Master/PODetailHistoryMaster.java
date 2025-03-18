package IMS.Master;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblPODetailHistory")
public class PODetailHistoryMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int poDetailId;

    private int assetQty;

    private Double assetRate;

    private int poId;

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

    public int getPoDetailId() {
        return poDetailId;
    }

    public void setPoDetailId(int poDetailId) {
        this.poDetailId = poDetailId;
    }

    public int getAssetQty() {
        return assetQty;
    }

    public void setAssetQty(int assetQty) {
        this.assetQty = assetQty;
    }

    public Double getAssetRate() {
        return assetRate;
    }

    public void setAssetRate(Double assetRate) {
        this.assetRate = assetRate;
    }

    public int getPoId() {
        return poId;
    }

    public void setPoId(int poId) {
        this.poId = poId;
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
    public PODetailHistoryMaster() {
        super();
    }

    
    
    public PODetailHistoryMaster(Integer id, int poDetailId, int assetQty, Double assetRate, int poId, int assetId,
            String action, LocalDateTime timestamp) {
        super();
        this.id = id;
        this.poDetailId = poDetailId;
        this.assetQty = assetQty;
        this.assetRate = assetRate;
        this.poId = poId;
        this.assetId = assetId;
        this.action = action;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "PODetailHistoryMaster [id=" + id + ", poDetailId=" + poDetailId + ", assetQty=" + assetQty
                + ", assetRate=" + assetRate + ", poId=" + poId + ", assetId=" + assetId + ", action=" + action
                + ", timestamp=" + timestamp + "]";
    }
}
