package IMS.Master;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblAssetStatusHistory")
public class AssetStatusHistoryMaster {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    private int assetStatusId;
    
    private String assetStatusName;
    
    private String assetStatusDesc;

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



	public int getAssetStatusId() {
		return assetStatusId;
	}



	public void setAssetStatusId(int assetStatusId) {
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



	public AssetStatusHistoryMaster() {
        super();
    }

    public AssetStatusHistoryMaster(Integer id, String action) {
        super();
        this.id = id;
        this.action = action;
    }



	public AssetStatusHistoryMaster(Integer id, int assetStatusId, String assetStatusName, String assetStatusDesc,
			String action, LocalDateTime timestamp) {
		super();
		this.id = id;
		this.assetStatusId = assetStatusId;
		this.assetStatusName = assetStatusName;
		this.assetStatusDesc = assetStatusDesc;
		this.action = action;
		this.timestamp = timestamp;
	}



	@Override
	public String toString() {
		return "AssetStatusHistoryMaster [id=" + id + ", assetStatusId=" + assetStatusId + ", assetStatusName="
				+ assetStatusName + ", assetStatusDesc=" + assetStatusDesc + ", action=" + action + ", timestamp="
				+ timestamp + "]";
	}
}
