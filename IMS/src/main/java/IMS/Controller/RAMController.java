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

import IMS.Master.RAMMaster;
import IMS.Service.RAMService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/RAM")
public class RAMController {

    @Autowired
    private RAMService ramService;

    @PostMapping("/addRAM")
    public ResponseEntity<String> addRAM(@RequestBody @Valid RAMMaster ramMaster) {
        Boolean isAdded = ramService.addRAMService(ramMaster);
        if (isAdded) {
            return new ResponseEntity<>("RAM added successfully!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add RAM.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateRAM/{ramId}")
    public ResponseEntity<String> updateRAM(
            @PathVariable("ramId") @Positive(message = "RAM ID must be positive") Integer ramId,
            @RequestBody @Valid RAMMaster ramMaster) {
        ramMaster.setRamId(ramId);
        Boolean isUpdated = ramService.updateRAMService(ramMaster);
        if (isUpdated) {
            return new ResponseEntity<>("RAM updated successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update RAM.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteRAM/{ramId}")
    public ResponseEntity<String> deleteRAM(@PathVariable("ramId") @Positive(message = "RAM ID must be positive") Integer ramId) {
        RAMMaster ramMaster = ramService.getRAMService(ramId);
        if (ramMaster != null) {
            Boolean isDeleted = ramService.deleteRAMService(ramMaster);
            if (isDeleted) {
                return new ResponseEntity<>("RAM deleted successfully!", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Failed to delete RAM.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getRAM/{ramId}")
    public ResponseEntity<RAMMaster> getRAM(@PathVariable("ramId") @Positive(message = "RAM ID must be positive") Integer ramId) {
        RAMMaster ramMaster = ramService.getRAMService(ramId);
        if (ramMaster != null) {
            return new ResponseEntity<>(ramMaster, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllRAM")
    public ResponseEntity<List<RAMMaster>> getAllRAMs() {
        List<RAMMaster> allRAMs = ramService.getAllRAMService();
        return new ResponseEntity<>(allRAMs, HttpStatus.OK);
    }
}
