package IMS.Service;

import java.util.List;

import IMS.Master.AssetStatusMaster;

public interface AssetStatusService {

    public Boolean addAssetStatusService(AssetStatusMaster assetStatusMaster);
    public Boolean updateAssetStatusService(AssetStatusMaster assetStatusMaster);
    public Boolean deleteAssetStatusService(AssetStatusMaster assetStatusMaster);
    public AssetStatusMaster getAssetStatusService(Integer assetStatusId);
    public List<AssetStatusMaster> getAllAssetStatusService();
}
