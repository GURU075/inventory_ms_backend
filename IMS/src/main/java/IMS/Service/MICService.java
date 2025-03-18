package IMS.Service;

import java.util.List;

import IMS.Master.MICMaster;

public interface MICService {

    public Boolean addMICService(MICMaster micMaster);
    public Boolean updateMICService(MICMaster micMaster);
    public Boolean deleteMICService(MICMaster micMaster);
    public MICMaster getMICService(Integer micId);
    public List<MICMaster> getAllMICService();
}
