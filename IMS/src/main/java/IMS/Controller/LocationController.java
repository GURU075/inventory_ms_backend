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

import IMS.Master.LocationMaster;
import IMS.Service.LocationService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/Location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping("/addLocation")
    public ResponseEntity<String> addLocation(@RequestBody @Valid LocationMaster locationMaster) {
        Boolean isAdded = locationService.addLocationService(locationMaster);
        if (isAdded) {
            return new ResponseEntity<>("Location added successfully!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add Location.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateLocation/{locationId}")
    public ResponseEntity<String> updateLocation(
            @PathVariable("locationId") @Positive(message = "Location ID must be positive") Integer locationId,
            @RequestBody @Valid LocationMaster locationMaster) {
        locationMaster.setLocationId(locationId);
        Boolean isUpdated = locationService.updateLocationService(locationMaster);
        if (isUpdated) {
            return new ResponseEntity<>("Location updated successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update Location.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteLocation/{locationId}")
    public ResponseEntity<String> deleteLocation(@PathVariable("locationId") @Positive(message = "Location ID must be positive") Integer locationId) {
        LocationMaster locationMaster = locationService.getLocationService(locationId);
        if (locationMaster != null) {
            Boolean isDeleted = locationService.deleteLocationService(locationMaster);
            if (isDeleted) {
                return new ResponseEntity<>("Location deleted successfully!", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Failed to delete Location.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getLocation/{locationId}")
    public ResponseEntity<LocationMaster> getLocation(@PathVariable("locationId") @Positive(message = "Location ID must be positive") Integer locationId) {
        LocationMaster locationMaster = locationService.getLocationService(locationId);
        if (locationMaster != null) {
            return new ResponseEntity<>(locationMaster, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllLocations")
    public ResponseEntity<List<LocationMaster>> getAllLocations() {
        List<LocationMaster> allLocations = locationService.getAllLocationService();
        return new ResponseEntity<>(allLocations, HttpStatus.OK);
    }
}