package IMS.Service;

import java.util.List;

import IMS.Master.AllocationTypeMaster;

public interface AllocationTypeService {

    public Boolean addAllocationTypeService(AllocationTypeMaster allocationTypeMaster);
    public Boolean updateAllocationTypeService(AllocationTypeMaster allocationTypeMaster);
    public Boolean deleteAllocationTypeService(AllocationTypeMaster allocationTypeMaster);
    public AllocationTypeMaster getAllocationTypeService(Integer allocationTypeId);
    public List<AllocationTypeMaster> getAllAllocationTypeService();
}
