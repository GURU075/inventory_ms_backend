package IMS.Service;

import java.util.List;

import IMS.Master.WarrantyStatusMaster;

public interface WarrantyStatusService {

    public Boolean addWarrantyStatusService(WarrantyStatusMaster warrantyStatusMaster);
    public Boolean updateWarrantyStatusService(WarrantyStatusMaster warrantyStatusMaster);
    public Boolean deleteWarrantyStatusService(WarrantyStatusMaster warrantyStatusMaster);
    public WarrantyStatusMaster getWarrantyStatusService(Integer warrantyStatusId);
    public List<WarrantyStatusMaster> getAllWarrantyStatusService();
}
