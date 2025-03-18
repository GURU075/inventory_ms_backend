package IMS.Service;

import java.util.List;

import IMS.Master.VendorMaster;

public interface VendorService {

    public Boolean addVendor(VendorMaster vendor);
    public Boolean updateVendor(VendorMaster vendor);
    public Boolean deleteVendor(VendorMaster vendor);
    public VendorMaster getVendor(Integer vendorId);
    public List<VendorMaster> getAllVendors();
    
}
