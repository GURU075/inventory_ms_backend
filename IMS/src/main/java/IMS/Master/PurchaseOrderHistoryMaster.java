package IMS.Master;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblPurchaseOrderHistory")
public class PurchaseOrderHistoryMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int poId;
    
    private LocalDate poDate;

    private Double poAmount;

    private String poTermsAndConditions;

    private int vendorId;

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

    public int getPoId() {
        return poId;
    }

    public void setPoId(int poId) {
        this.poId = poId;
    }

    public LocalDate getPoDate() {
        return poDate;
    }

    public void setPoDate(LocalDate poDate) {
        this.poDate = poDate;
    }

    public Double getPoAmount() {
        return poAmount;
    }

    public void setPoAmount(Double poAmount) {
        this.poAmount = poAmount;
    }

    public String getPoTermsAndConditions() {
        return poTermsAndConditions;
    }

    public void setPoTermsAndConditions(String poTermsAndConditions) {
        this.poTermsAndConditions = poTermsAndConditions;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
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
    public PurchaseOrderHistoryMaster() {
        super();
    }

    public PurchaseOrderHistoryMaster(Integer id, int poId, LocalDate poDate, Double poAmount,
            String poTermsAndConditions, int vendorId, String action, LocalDateTime timestamp) {
        super();
        this.id = id;
        this.poId = poId;
        this.poDate = poDate;
        this.poAmount = poAmount;
        this.poTermsAndConditions = poTermsAndConditions;
        this.vendorId = vendorId;
        this.action = action;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "PurchaseOrderHistoryMaster [id=" + id + ", poId=" + poId + ", poDate=" + poDate + ", poAmount=" + poAmount
                + ", poTermsAndConditions=" + poTermsAndConditions + ", vendorId=" + vendorId + ", action=" + action
                + ", timestamp=" + timestamp + "]";
    }
}
