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

import IMS.Master.MakeMaster;
import IMS.Service.MakeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/Make")
public class MakeController {

    @Autowired
    private MakeService makeService;

    @PostMapping("/addMake")
    public ResponseEntity<String> addMake(@RequestBody @Valid MakeMaster makeMaster) {
        Boolean isAdded = makeService.addMakeService(makeMaster);
        if (isAdded) {
            return new ResponseEntity<>("Make added successfully!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add Make.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateMake/{makeId}")
    public ResponseEntity<String> updateMake(
            @PathVariable("makeId") @Positive(message = "Make ID must be positive") Integer makeId,
            @RequestBody @Valid MakeMaster makeMaster) {
        makeMaster.setMakeId(makeId);
        Boolean isUpdated = makeService.updateMakeService(makeMaster);
        if (isUpdated) {
            return new ResponseEntity<>("Make updated successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update Make.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteMake/{makeId}")
    public ResponseEntity<String> deleteMake(@PathVariable("makeId") @Positive(message = "Make ID must be positive") Integer makeId) {
        MakeMaster makeMaster = makeService.getMakeService(makeId);
        if (makeMaster != null) {
            Boolean isDeleted = makeService.deleteMakeService(makeMaster);
            if (isDeleted) {
                return new ResponseEntity<>("Make deleted successfully!", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Failed to delete Make.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getMake/{makeId}")
    public ResponseEntity<MakeMaster> getMake(@PathVariable("makeId") @Positive(message = "Make ID must be positive") Integer makeId) {
        MakeMaster makeMaster = makeService.getMakeService(makeId);
        if (makeMaster != null) {
            return new ResponseEntity<>(makeMaster, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllMake")
    public ResponseEntity<List<MakeMaster>> getAllMakes() {
        List<MakeMaster> allMakes = makeService.getAllMakeService();
        return new ResponseEntity<>(allMakes, HttpStatus.OK);
    }
}
