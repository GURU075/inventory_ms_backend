package IMS.Service;

import java.util.List;

import IMS.Master.DesignationMaster;

public interface DesignationService {

	public Boolean addDesignationService(DesignationMaster designationMaster);
	public Boolean updateDesignationService(DesignationMaster designationMaster);
	public Boolean deleteDesignationService(DesignationMaster designationMaster);
	public DesignationMaster getDesignationService(Integer designationId);
	public List<DesignationMaster> getAllDesignationService();
}
