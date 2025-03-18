package IMS.Service;

import java.util.List;

import IMS.Master.AssetDetailsMaster;

public interface AssetDetailsService {

    public Boolean addAssetDetailsService(AssetDetailsMaster assetDetailsMaster);
    public Boolean updateAssetDetailsService(AssetDetailsMaster assetDetailsMaster);
    public Boolean deleteAssetDetailsService(AssetDetailsMaster assetDetailsMaster);
    public AssetDetailsMaster getAssetDetailsService(Integer assetDetailsId);
    public List<AssetDetailsMaster> getAllAssetDetailsService();
}
