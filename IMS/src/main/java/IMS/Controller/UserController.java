package IMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import IMS.Master.DepartmentMaster;
import IMS.Master.RoleMaster;
import IMS.Master.UserMaster;
import IMS.Service.DepartmentService;
import IMS.Service.RoleService;
import IMS.Service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody @Valid UserMaster userMaster) {
        RoleMaster role = roleService.getRoleByName(userMaster.getRole().getRoleName());
        DepartmentMaster department = departmentService.getDepartmentService(userMaster.getDepartment().getDeptId());
        if (role != null && department != null) {
            userMaster.setRole(role);
            userMaster.setDepartment(department);
            Boolean isAdded = userService.addUserService(userMaster);
            if (isAdded) {
                return new ResponseEntity<>("User added successfully!", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Failed to add User.", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Invalid role or department.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<String> updateUser(
            @PathVariable("userId") @Positive(message = "User ID must be positive") Integer userId,
            @RequestBody @Valid UserMaster userMaster) {
        RoleMaster role = roleService.getRoleByName(userMaster.getRole().getRoleName());
        DepartmentMaster department = departmentService.getDepartmentService(userMaster.getDepartment().getDeptId());
        if (role != null && department != null) {
            userMaster.setRole(role);
            userMaster.setDepartment(department);
            userMaster.setUserId(userId);
            Boolean isUpdated = userService.updateUserService(userMaster);
            if (isUpdated) {
                return new ResponseEntity<>("User updated successfully!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Failed to update User.", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Invalid role or department.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") @Positive(message = "User ID must be positive") Integer userId) {
        UserMaster userMaster = userService.getUserService(userId);
        if (userMaster != null) {
            Boolean isDeleted = userService.deleteUserService(userMaster);
            if (isDeleted) {
                return new ResponseEntity<>("User deleted successfully!", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Failed to delete User.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getUser/{userId}")
    public ResponseEntity<UserMaster> getUser(@PathVariable("userId") @Positive(message = "User ID must be positive") Integer userId) {
        UserMaster userMaster = userService.getUserService(userId);
        if (userMaster != null) {
            return new ResponseEntity<>(userMaster, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserMaster>> getAllUsers() {
        List<UserMaster> allUsers = userService.getAllUserService();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
    
//    @GetMapping("/getUserByLocationId/{locationId}") 
//    public List<UserMaster> getUserByDepartmentId(@PathVariable("departmentId") Integer departmentId) { 
//    	return userService.getUserByDepartmentId(departmentId); 
//    	}
}
