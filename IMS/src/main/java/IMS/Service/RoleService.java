package IMS.Service;

import java.util.List;

import IMS.Master.RoleMaster;

public interface RoleService {

	public Boolean addRoleService(RoleMaster roleMaster);
	public Boolean updateRoleService(RoleMaster roleMaster);
	public Boolean deleteRoleService(RoleMaster roleMaster);
	public RoleMaster getRoleService(Integer roleId);
	public List<RoleMaster> getAllRoleService();
	RoleMaster getRoleByName(String roleName);

}