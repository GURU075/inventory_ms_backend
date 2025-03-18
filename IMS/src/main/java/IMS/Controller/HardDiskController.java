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

import IMS.Master.HardDiskMaster;
import IMS.Service.HardDiskService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/HardDisk")
public class HardDiskController {

    @Autowired
    private HardDiskService hardDiskService;

    @PostMapping("/addHardDisk")
    public ResponseEntity<String> addHardDisk(@RequestBody @Valid HardDiskMaster hardDiskMaster) {
        Boolean isAdded = hardDiskService.addHardDiskService(hardDiskMaster);
        if (isAdded) {
            return new ResponseEntity<>("Hard Disk added successfully!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add Hard Disk.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateHardDisk/{hardDiskId}")
    public ResponseEntity<String> updateHardDisk(
            @PathVariable("hardDiskId") @Positive(message = "Hard Disk ID must be positive") Integer hardDiskId,
            @RequestBody @Valid HardDiskMaster hardDiskMaster) {
        hardDiskMaster.setHardDiskId(hardDiskId);
        Boolean isUpdated = hardDiskService.updateHardDiskService(hardDiskMaster);
        if (isUpdated) {
            return new ResponseEntity<>("Hard Disk updated successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update Hard Disk.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteHardDisk/{hardDiskId}")
    public ResponseEntity<String> deleteHardDisk(@PathVariable("hardDiskId") @Positive(message = "Hard Disk ID must be positive") Integer hardDiskId) {
        HardDiskMaster hardDiskMaster = hardDiskService.getHardDiskService(hardDiskId);
        if (hardDiskMaster != null) {
            Boolean isDeleted = hardDiskService.deleteHardDiskService(hardDiskMaster);
            if (isDeleted) {
                return new ResponseEntity<>("Hard Disk deleted successfully!", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Failed to delete Hard Disk.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getHardDisk/{hardDiskId}")
    public ResponseEntity<HardDiskMaster> getHardDisk(@PathVariable("hardDiskId") @Positive(message = "Hard Disk ID must be positive") Integer hardDiskId) {
        HardDiskMaster hardDiskMaster = hardDiskService.getHardDiskService(hardDiskId);
        if (hardDiskMaster != null) {
            return new ResponseEntity<>(hardDiskMaster, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllHardDisk")
    public ResponseEntity<List<HardDiskMaster>> getAllHardDisks() {
        List<HardDiskMaster> allHardDisks = hardDiskService.getAllHardDiskService();
        return new ResponseEntity<>(allHardDisks, HttpStatus.OK);
    }
}
