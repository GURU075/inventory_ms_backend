package IMS.Service;

import java.util.List;

import IMS.Master.MakeMaster;

public interface MakeService {

    public Boolean addMakeService(MakeMaster makeMaster);
    public Boolean updateMakeService(MakeMaster makeMaster);
    public Boolean deleteMakeService(MakeMaster makeMaster);
    public MakeMaster getMakeService(Integer makeId);
    public List<MakeMaster> getAllMakeService();
}
