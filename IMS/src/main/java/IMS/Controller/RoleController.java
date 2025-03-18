package IMS.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import IMS.Master.RoleMaster;
import IMS.Service.RoleService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    
    @PostMapping("/addRole")
    public ResponseEntity<String> addRole(@RequestBody @Valid RoleMaster roleMaster) {
        Boolean isAdded = roleService.addRoleService(roleMaster);
        if (isAdded) {
            return new ResponseEntity<>("Role added successfully!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add role.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateRole/{roleId}")
    public ResponseEntity<String> updateRole(
            @PathVariable("roleId") @Positive(message = "Role ID must be positive") Integer roleId,
            @RequestBody @Valid RoleMaster roleMaster) {
        roleMaster.setRoleId(roleId);
        Boolean isUpdated = roleService.updateRoleService(roleMaster);
        if (isUpdated) {
            return new ResponseEntity<>("Role updated successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update role.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteRole/{roleId}")
    public ResponseEntity<String> deleteRole(@PathVariable("roleId") @Positive(message = "Role ID must be positive") Integer roleId) {
        RoleMaster roleMaster = roleService.getRoleService(roleId);
        if (roleMaster != null) {
            Boolean isDeleted = roleService.deleteRoleService(roleMaster);
            if (isDeleted) {
                return new ResponseEntity<>("Role deleted successfully!", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Failed to delete role.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getRole/{roleId}")
    public ResponseEntity<RoleMaster> getRole(@PathVariable("roleId") @Positive(message = "Role ID must be positive") Integer roleId) {
        RoleMaster roleMaster = roleService.getRoleService(roleId);
        if (roleMaster != null) {
            return new ResponseEntity<>(roleMaster, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllRoles")
    public ResponseEntity<List<RoleMaster>> getAllRoles() {
        List<RoleMaster> allRoles = roleService.getAllRoleService();
        return new ResponseEntity<>(allRoles, HttpStatus.OK);
    }
}
