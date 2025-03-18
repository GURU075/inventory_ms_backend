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

import IMS.Master.PODetailMaster;
import IMS.Service.PODetailService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/PODetail")
public class PODetailController {

    @Autowired
    private PODetailService poDetailService;

    @PostMapping("/addPODetail")
    public ResponseEntity<String> addPODetail(@RequestBody @Valid PODetailMaster poDetail) {
        Boolean isAdded = poDetailService.addPODetail(poDetail);
        if (isAdded) {
            return new ResponseEntity<>("PODetail added successfully!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add PODetail.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updatePODetail/{poDetailId}")
    public ResponseEntity<String> updatePODetail(
            @PathVariable("poDetailId") @Positive(message = "PODetail ID must be positive") Integer poDetailId,
            @RequestBody @Valid PODetailMaster poDetail) {
        poDetail.setPoDetailId(poDetailId);
        Boolean isUpdated = poDetailService.updatePODetail(poDetail);
        if (isUpdated) {
            return new ResponseEntity<>("PODetail updated successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update PODetail.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deletePODetail/{poDetailId}")
    public ResponseEntity<String> deletePODetail(@PathVariable("poDetailId") @Positive(message = "PODetail ID must be positive") Integer poDetailId) {
        PODetailMaster poDetail = poDetailService.getPODetail(poDetailId);
        if (poDetail != null) {
            Boolean isDeleted = poDetailService.deletePODetail(poDetail);
            if (isDeleted) {
                return new ResponseEntity<>("PODetail deleted successfully!", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Failed to delete PODetail.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getPODetail/{poDetailId}")
    public ResponseEntity<PODetailMaster> getPODetail(@PathVariable("poDetailId") @Positive(message = "PODetail ID must be positive") Integer poDetailId) {
        PODetailMaster poDetail = poDetailService.getPODetail(poDetailId);
        if (poDetail != null) {
            return new ResponseEntity<>(poDetail, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllPODetails")
    public ResponseEntity<List<PODetailMaster>> getAllPODetails() {
        List<PODetailMaster> allPODetails = poDetailService.getAllPODetails();
        return new ResponseEntity<>(allPODetails, HttpStatus.OK);
    }
}
