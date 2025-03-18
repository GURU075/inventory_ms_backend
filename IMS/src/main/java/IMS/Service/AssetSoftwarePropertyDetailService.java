package IMS.Service;

import java.util.List;

import IMS.Master.AssetSoftwarePropertyDetailMaster;

public interface AssetSoftwarePropertyDetailService {

    public Boolean addAssetSoftwarePropertyDetail(AssetSoftwarePropertyDetailMaster assetSoftwarePropertyDetail);
    public Boolean updateAssetSoftwarePropertyDetail(AssetSoftwarePropertyDetailMaster assetSoftwarePropertyDetail);
    public Boolean deleteAssetSoftwarePropertyDetail(AssetSoftwarePropertyDetailMaster assetSoftwarePropertyDetail);
    public AssetSoftwarePropertyDetailMaster getAssetSoftwarePropertyDetail(Integer assetSoftwareDetailId);
    public List<AssetSoftwarePropertyDetailMaster> getAllAssetSoftwarePropertyDetails();
    
}
