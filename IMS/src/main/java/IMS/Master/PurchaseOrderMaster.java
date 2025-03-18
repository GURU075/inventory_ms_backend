package IMS.Master;

import java.time.LocalDate;
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
@Table(name = "tblPurchaseOrder")
public class PurchaseOrderMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer poId;

    @NotNull(message = "Purchase Order Date cannot be null")
    private LocalDate poDate;

    @NotNull(message = "Purchase Order Amount cannot be null")
    private Double poAmount;

    @Size(max = 500, message = "Terms and Conditions must be less than 500 characters")
    private String poTermsAndConditions;

    @ManyToOne
    @JoinColumn(name = "vendorId", nullable = false)
    private VendorMaster vendor;

    // Getters and Setters
    public Integer getPoId() {
        return poId;
    }

    public void setPoId(Integer poId) {
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

    public VendorMaster getVendor() {
        return vendor;
    }

    public void setVendor(VendorMaster vendor) {
        this.vendor = vendor;
    }

    // Constructors
    public PurchaseOrderMaster() {
        super();
    }

    public PurchaseOrderMaster(Integer poId, @NotNull(message = "Purchase Order Date cannot be null") LocalDate poDate,
            @NotNull(message = "Purchase Order Amount cannot be null") Double poAmount,
            @Size(max = 500, message = "Terms and Conditions must be less than 500 characters") String poTermsAndConditions,
            VendorMaster vendor) {
        super();
        this.poId = poId;
        this.poDate = poDate;
        this.poAmount = poAmount;
        this.poTermsAndConditions = poTermsAndConditions;
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        return "PurchaseOrderMaster [poId=" + poId + ", poDate=" + poDate + ", poAmount=" + poAmount
                + ", poTermsAndConditions=" + poTermsAndConditions + ", vendor=" + vendor + "]";
    }
}
