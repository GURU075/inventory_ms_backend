package IMS.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IMS.DAO.ModelDAO;
import IMS.DAO.ModelHistoryDAO;
import IMS.Master.ModelHistoryMaster;
import IMS.Master.ModelMaster;
import IMS.Service.ModelService;

@Service
public class ModelServiceImpl implements ModelService {

    private static final Logger logger = LogManager.getLogger(ModelServiceImpl.class);

    @Autowired
    private ModelDAO modelDAO;

    @Autowired
    private ModelHistoryDAO modelHistoryDAO;

    @Override
    public Boolean addModelService(ModelMaster modelMaster) {
        try {
            logger.info("In addModelService");
            modelDAO.save(modelMaster);

            ModelHistoryMaster oldModel = new ModelHistoryMaster();
            oldModel.setModelId(modelMaster.getModelId());
            oldModel.setModelName(modelMaster.getModelName());
            oldModel.setModelDesc(modelMaster.getModelDesc());
            oldModel.setAction("Create");
            oldModel.setTimestamp(LocalDateTime.now());

            modelHistoryDAO.save(oldModel);
            logger.info("Out of addModelService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean updateModelService(ModelMaster modelMaster) {
        try {
            logger.info("In updateModelService");
            ModelMaster model = modelDAO.findById(modelMaster.getModelId()).orElseThrow(() -> new RuntimeException("Model not found"));

            ModelHistoryMaster oldModel = new ModelHistoryMaster();
            oldModel.setModelId(model.getModelId());
            oldModel.setModelName(model.getModelName());
            oldModel.setModelDesc(model.getModelDesc());
            oldModel.setAction("Update");
            oldModel.setTimestamp(LocalDateTime.now());

            model.setModelName(modelMaster.getModelName());
            model.setModelDesc(modelMaster.getModelDesc());
            model = modelDAO.save(model);

            modelHistoryDAO.save(oldModel);
            logger.info("Out of updateModelService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean deleteModelService(ModelMaster modelMaster) {
        try {
            logger.info("In deleteModelService");
            ModelMaster model = modelDAO.findById(modelMaster.getModelId()).orElseThrow(() -> new RuntimeException("Model not found"));

            ModelHistoryMaster oldModel = new ModelHistoryMaster();
            oldModel.setModelId(model.getModelId());
            oldModel.setModelName(model.getModelName());
            oldModel.setModelDesc(model.getModelDesc());
            oldModel.setAction("Delete");
            oldModel.setTimestamp(LocalDateTime.now());

            modelDAO.delete(model);

            modelHistoryDAO.save(oldModel);
            logger.info("Out of deleteModelService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public ModelMaster getModelService(Integer modelId) {
        try {
            logger.info("In getModelService");
            ModelMaster modelMaster = modelDAO.findById(modelId).orElse(null);
            logger.info("Out of getModelService");
            return modelMaster;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<ModelMaster> getAllModelService() {
        List<ModelMaster> allModels = new ArrayList<>();
        try {
            logger.info("In getAllModelService");
            allModels = (List<ModelMaster>) modelDAO.findAll();
            logger.info("Out of getAllModelService");
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
        }
        return allModels;
    }
}
