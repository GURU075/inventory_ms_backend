package IMS.Controller;

import java.util.List;

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

import IMS.Master.MICMaster;
import IMS.Service.MICService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/MIC")
public class MICController {

    @Autowired
    private MICService micService;

    @PostMapping("/addMIC")
    public ResponseEntity<String> addMIC(@RequestBody @Valid MICMaster micMaster) {
        Boolean isAdded = micService.addMICService(micMaster);
        if (isAdded) {
            return new ResponseEntity<>("MIC added successfully!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add MIC.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateMIC/{micId}")
    public ResponseEntity<String> updateMIC(
            @PathVariable("micId") @Positive(message = "MIC ID must be positive") Integer micId,
            @RequestBody @Valid MICMaster micMaster) {
        micMaster.setMicId(micId);
        Boolean isUpdated = micService.updateMICService(micMaster);
        if (isUpdated) {
            return new ResponseEntity<>("MIC updated successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update MIC.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteMIC/{micId}")
    public ResponseEntity<String> deleteMIC(@PathVariable("micId") @Positive(message = "MIC ID must be positive") Integer micId) {
        MICMaster micMaster = micService.getMICService(micId);
        if (micMaster != null) {
            Boolean isDeleted = micService.deleteMICService(micMaster);
            if (isDeleted) {
                return new ResponseEntity<>("MIC deleted successfully!", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Failed to delete MIC.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getMIC/{micId}")
    public ResponseEntity<MICMaster> getMIC(@PathVariable("micId") @Positive(message = "MIC ID must be positive") Integer micId) {
        MICMaster micMaster = micService.getMICService(micId);
        if (micMaster != null) {
            return new ResponseEntity<>(micMaster, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllMIC")
    public ResponseEntity<List<MICMaster>> getAllMICs() {
        List<MICMaster> allMICs = micService.getAllMICService();
        return new ResponseEntity<>(allMICs, HttpStatus.OK);
    }
}
