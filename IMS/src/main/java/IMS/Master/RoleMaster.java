package IMS.Master;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tblRole")
public class RoleMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;
    
    @NotNull(message = "Role name cannot be null")
    @Size(min = 1, max = 50, message = "Role name must be between 1 and 50 characters")
    private String roleName;

    @Size(max = 200, message = "Description must be less than 200 characters")
    private String roleDesc;

    private Boolean canAdd;
    
    private Boolean canEdit;
    
    private Boolean canDelete;
    
    private Boolean canView;
    
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
    public RoleMaster() {
        super();
    }
    public RoleMaster(int roleId, String roleName, String roleDesc, Boolean canAdd, Boolean canEdit, Boolean canDelete,
            Boolean canView) {
        super();
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
        this.canAdd = canAdd;
        this.canEdit = canEdit;
        this.canDelete = canDelete;
        this.canView = canView;
    }
    @Override
    public String toString() {
        return "RoleMaster [roleId=" + roleId + ", roleName=" + roleName + ", roleDesc=" + roleDesc + ", canAdd="
                + canAdd + ", canEdit=" + canEdit + ", canDelete=" + canDelete + ", canView=" + canView + "]";
    }
}
