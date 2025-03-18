package IMS.Service;

import java.util.List;

import IMS.Master.RAMMaster;

public interface RAMService {

    public Boolean addRAMService(RAMMaster ramMaster);
    public Boolean updateRAMService(RAMMaster ramMaster);
    public Boolean deleteRAMService(RAMMaster ramMaster);
    public RAMMaster getRAMService(Integer ramId);
    public List<RAMMaster> getAllRAMService();
}
