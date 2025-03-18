package IMS.Service;

import java.util.List;

import IMS.Master.PODetailMaster;

public interface PODetailService {

    public Boolean addPODetail(PODetailMaster poDetail);
    public Boolean updatePODetail(PODetailMaster poDetail);
    public Boolean deletePODetail(PODetailMaster poDetail);
    public PODetailMaster getPODetail(Integer poDetailId);
    public List<PODetailMaster> getAllPODetails();
    
}
