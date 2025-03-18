package IMS.Master;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblRoleHistory")
public class RoleHistoryMaster {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;
	
	private int roleId;
	
    private String roleName;

    private String roleDesc;

    private Boolean canAdd;
    
    private Boolean canEdit;
    
    private Boolean canDelete;
    
    private Boolean canView;
    
    private String action; 
    
    private LocalDateTime timestamp;
    
    
    
    public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
	}


	public LocalDateTime getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}


	@PrePersist 
    private void onCreate() { 
    	timestamp = LocalDateTime.now(); 
    }
    
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	
	
	
		public Boolean getCanAdd() {
		return canAdd;
	}


	public void setCanAdd(Boolean canAdd) {
		this.canAdd = canAdd;
	}


	public Boolean getCanEdit() {
		return canEdit;
	}


	public void setCanEdit(Boolean canEdit) {
		this.canEdit = canEdit;
	}


	public Boolean getCanDelete() {
		return canDelete;
	}


	public void setCanDelete(Boolean canDelete) {
		this.canDelete = canDelete;
	}


	public Boolean getCanView() {
		return canView;
	}


	public void setCanView(Boolean canView) {
		this.canView = canView;
	}


		public RoleHistoryMaster() {
		super();
	}

		public RoleHistoryMaster(Integer id, String action)
		{
			this.id = id;
			this.action = action;
			
		}


		public RoleHistoryMaster(Integer id, int roleId, String roleName, String roleDesc, Boolean canAdd,
				Boolean canEdit, Boolean canDelete, Boolean canView, String action, LocalDateTime timestamp) {
			super();
			this.id = id;
			this.roleId = roleId;
			this.roleName = roleName;
			this.roleDesc = roleDesc;
			this.canAdd = canAdd;
			this.canEdit = canEdit;
			this.canDelete = canDelete;
			this.canView = canView;
			this.action = action;
			this.timestamp = timestamp;
		}


		@Override
		public String toString() {
			return "RoleHistoryMaster [id=" + id + ", roleId=" + roleId + ", roleName=" + roleName + ", roleDesc="
					+ roleDesc + ", canAdd=" + canAdd + ", canEdit=" + canEdit + ", canDelete=" + canDelete
					+ ", canView=" + canView + ", action=" + action + ", timestamp=" + timestamp + "]";
		}
}
