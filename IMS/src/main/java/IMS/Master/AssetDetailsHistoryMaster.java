package IMS.Master;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblAssetDetailsHistory")
public class AssetDetailsHistoryMaster {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    private int assetDetailsId;
    
    private String assetPropertyName;
    
    private String assetPropertyValue;

    private String action; 
    
    private int assetId;
    
    public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

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

    public int getAssetDetailsId() {
        return assetDetailsId;
    }

    public void setAssetDetailsId(int assetDetailsId) {
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

    public AssetDetailsHistoryMaster() {
        super();
    }

    public AssetDetailsHistoryMaster(Integer id, String action) {
        super();
        this.id = id;
        this.action = action;
    }

	public AssetDetailsHistoryMaster(Integer id, int assetDetailsId, String assetPropertyName,
			String assetPropertyValue, String action, int assetId, LocalDateTime timestamp) {
		super();
		this.id = id;
		this.assetDetailsId = assetDetailsId;
		this.assetPropertyName = assetPropertyName;
		this.assetPropertyValue = assetPropertyValue;
		this.action = action;
		this.assetId = assetId;
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "AssetDetailsHistoryMaster [id=" + id + ", assetDetailsId=" + assetDetailsId + ", assetPropertyName="
				+ assetPropertyName + ", assetPropertyValue=" + assetPropertyValue + ", action=" + action + ", assetId="
				+ assetId + ", timestamp=" + timestamp + "]";
	}
}
