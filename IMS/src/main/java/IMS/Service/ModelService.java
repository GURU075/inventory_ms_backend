package IMS.Service;

import java.util.List;

import IMS.Master.ModelMaster;

public interface ModelService {

    public Boolean addModelService(ModelMaster modelMaster);
    public Boolean updateModelService(ModelMaster modelMaster);
    public Boolean deleteModelService(ModelMaster modelMaster);
    public ModelMaster getModelService(Integer modelId);
    public List<ModelMaster> getAllModelService();
}
