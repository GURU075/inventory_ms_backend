package IMS.Service;

import java.util.List;

import IMS.Master.HardDiskMaster;

public interface HardDiskService {

    public Boolean addHardDiskService(HardDiskMaster hardDiskMaster);
    public Boolean updateHardDiskService(HardDiskMaster hardDiskMaster);
    public Boolean deleteHardDiskService(HardDiskMaster hardDiskMaster);
    public HardDiskMaster getHardDiskService(Integer hardDiskId);
    public List<HardDiskMaster> getAllHardDiskService();
}
