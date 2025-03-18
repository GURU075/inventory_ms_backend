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

import IMS.Master.DesignationMaster;
import IMS.Service.DesignationService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/Designation")
public class DesignationController {

    @Autowired
    private DesignationService designationService;

    @PostMapping("/addDesignation")
    public ResponseEntity<String> addDesignation(@RequestBody @Valid DesignationMaster designationMaster) {
        Boolean isAdded = designationService.addDesignationService(designationMaster);
        if (isAdded) {
            return new ResponseEntity<>("Designation added successfully!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add Designation.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateDesignation/{designationId}")
    public ResponseEntity<String> updateDesignation(
            @PathVariable("designationId") @Positive(message = "Designation ID must be positive") Integer designationId,
            @RequestBody @Valid DesignationMaster designationMaster) {
        designationMaster.setDesignationId(designationId);
        Boolean isUpdated = designationService.updateDesignationService(designationMaster);
        if (isUpdated) {
            return new ResponseEntity<>("Designation updated successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update Designation.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteDesignation/{designationId}")
    public ResponseEntity<String> deleteDesignation(@PathVariable("designationId") @Positive(message = "Designation ID must be positive") Integer designationId) {
        DesignationMaster designationMaster = designationService.getDesignationService(designationId);
        if (designationMaster != null) {
            Boolean isDeleted = designationService.deleteDesignationService(designationMaster);
            if (isDeleted) {
                return new ResponseEntity<>("Designation deleted successfully!", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Failed to delete Designation.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getDesignation/{designationId}")
    public ResponseEntity<DesignationMaster> getDesignation(@PathVariable("designationId") @Positive(message = "Designation ID must be positive") Integer designationId) {
        DesignationMaster designationMaster = designationService.getDesignationService(designationId);
        if (designationMaster != null) {
            return new ResponseEntity<>(designationMaster, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllDesignation")
    public ResponseEntity<List<DesignationMaster>> getAllDesignations() {
        List<DesignationMaster> allDesignations = designationService.getAllDesignationService();
        return new ResponseEntity<>(allDesignations, HttpStatus.OK);
    }
}
