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

import IMS.Master.ModelMaster;
import IMS.Service.ModelService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/Model")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @PostMapping("/addModel")
    public ResponseEntity<String> addModel(@RequestBody @Valid ModelMaster modelMaster) {
        Boolean isAdded = modelService.addModelService(modelMaster);
        if (isAdded) {
            return new ResponseEntity<>("Model added successfully!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add Model.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateModel/{modelId}")
    public ResponseEntity<String> updateModel(
            @PathVariable("modelId") @Positive(message = "Model ID must be positive") Integer modelId,
            @RequestBody @Valid ModelMaster modelMaster) {
        modelMaster.setModelId(modelId);
        Boolean isUpdated = modelService.updateModelService(modelMaster);
        if (isUpdated) {
            return new ResponseEntity<>("Model updated successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update Model.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteModel/{modelId}")
    public ResponseEntity<String> deleteModel(@PathVariable("modelId") @Positive(message = "Model ID must be positive") Integer modelId) {
        ModelMaster modelMaster = modelService.getModelService(modelId);
        if (modelMaster != null) {
            Boolean isDeleted = modelService.deleteModelService(modelMaster);
            if (isDeleted) {
                return new ResponseEntity<>("Model deleted successfully!", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Failed to delete Model.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getModel/{modelId}")
    public ResponseEntity<ModelMaster> getModel(@PathVariable("modelId") @Positive(message = "Model ID must be positive") Integer modelId) {
        ModelMaster modelMaster = modelService.getModelService(modelId);
        if (modelMaster != null) {
            return new ResponseEntity<>(modelMaster, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllModels")
    public ResponseEntity<List<ModelMaster>> getAllModels() {
        List<ModelMaster> allModels = modelService.getAllModelService();
        return new ResponseEntity<>(allModels, HttpStatus.OK);
    }
}
