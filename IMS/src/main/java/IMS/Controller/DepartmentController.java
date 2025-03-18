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
import IMS.Master.LocationMaster;
import IMS.Service.DepartmentService;
import IMS.Service.LocationService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/Department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private LocationService locationService;

    @PostMapping("/addDepartment")
    public ResponseEntity<String> addDepartment(@RequestBody @Valid DepartmentMaster departmentMaster) {
        LocationMaster location = locationService.getLocationByName(departmentMaster.getLocation().getLocationName());
        if (location != null) {
            departmentMaster.setLocation(location);
            Boolean isAdded = departmentService.addDepartmentService(departmentMaster);
            if (isAdded) {
                return new ResponseEntity<>("Department added successfully!", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Failed to add Department.", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Invalid location name.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateDepartment/{deptId}")
    public ResponseEntity<String> updateDepartment(
            @PathVariable("deptId") @Positive(message = "Department ID must be positive") Integer deptId,
            @RequestBody @Valid DepartmentMaster departmentMaster) {
        LocationMaster location = locationService.getLocationByName(departmentMaster.getLocation().getLocationName());
        if (location != null) {
            departmentMaster.setLocation(location);
            departmentMaster.setDeptId(deptId);
            Boolean isUpdated = departmentService.updateDepartmentService(departmentMaster);
            if (isUpdated) {
                return new ResponseEntity<>("Department updated successfully!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Failed to update Department.", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Invalid location name.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteDepartment/{deptId}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("deptId") @Positive(message = "Department ID must be positive") Integer deptId) {
        DepartmentMaster departmentMaster = departmentService.getDepartmentService(deptId);
        if (departmentMaster != null) {
            Boolean isDeleted = departmentService.deleteDepartmentService(departmentMaster);
            if (isDeleted) {
                return new ResponseEntity<>("Department deleted successfully!", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Failed to delete Department.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getDepartment/{deptId}")
    public ResponseEntity<DepartmentMaster> getDepartment(@PathVariable("deptId") @Positive(message = "Department ID must be positive") Integer deptId) {
        DepartmentMaster departmentMaster = departmentService.getDepartmentService(deptId);
        if (departmentMaster != null) {
            return new ResponseEntity<>(departmentMaster, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllDepartments")
    public ResponseEntity<List<DepartmentMaster>> getAllDepartments() {
        List<DepartmentMaster> allDepartments = departmentService.getAllDepartmentService();
        return new ResponseEntity<>(allDepartments, HttpStatus.OK);
    }
}
//