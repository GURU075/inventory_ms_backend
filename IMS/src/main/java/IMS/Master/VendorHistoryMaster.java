package IMS.Master;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblVendorHistory")
public class VendorHistoryMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private int vendorId;
    
    private String vendorName;
    
    private String vendorContactPersonName;
    
    private String vendorContactPersonNumber;
    
    private String vendorContactPersonEmail;
    
    private String vendorAddress;
    
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

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorContactPersonName() {
        return vendorContactPersonName;
    }

    public void setVendorContactPersonName(String vendorContactPersonName) {
        this.vendorContactPersonName = vendorContactPersonName;
    }

    public String getVendorContactPersonNumber() {
        return vendorContactPersonNumber;
    }

    public void setVendorContactPersonNumber(String vendorContactPersonNumber) {
        this.vendorContactPersonNumber = vendorContactPersonNumber;
    }

    public String getVendorContactPersonEmail() {
        return vendorContactPersonEmail;
    }

    public void setVendorContactPersonEmail(String vendorContactPersonEmail) {
        this.vendorContactPersonEmail = vendorContactPersonEmail;
    }

    public String getVendorAddress() {
        return vendorAddress;
    }

    public void setVendorAddress(String vendorAddress) {
        this.vendorAddress = vendorAddress;
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
    public VendorHistoryMaster() {
        super();
    }

    public VendorHistoryMaster(Integer id, int vendorId, String vendorName, String vendorContactPersonName,
            String vendorContactPersonNumber, String vendorContactPersonEmail, String vendorAddress, String action,
            LocalDateTime timestamp) {
        super();
        this.id = id;
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.vendorContactPersonName = vendorContactPersonName;
        this.vendorContactPersonNumber = vendorContactPersonNumber;
        this.vendorContactPersonEmail = vendorContactPersonEmail;
        this.vendorAddress = vendorAddress;
        this.action = action;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "VendorHistoryMaster [id=" + id + ", vendorId=" + vendorId + ", vendorName=" + vendorName
                + ", vendorContactPersonName=" + vendorContactPersonName + ", vendorContactPersonNumber="
                + vendorContactPersonNumber + ", vendorContactPersonEmail=" + vendorContactPersonEmail
                + ", vendorAddress=" + vendorAddress + ", action=" + action + ", timestamp=" + timestamp + "]";
    }
}
