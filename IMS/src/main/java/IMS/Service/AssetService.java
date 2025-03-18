package IMS.Service;

import java.util.List;

import IMS.Master.AssetMaster;

public interface AssetService {

    public AssetMaster addAssetService(AssetMaster assetMaster);
    public Boolean updateAssetService(AssetMaster assetMaster);
    public Boolean deleteAssetService(AssetMaster assetMaster);
    public AssetMaster getAssetService(Integer assetId);
    public List<AssetMaster> getAllAssetService();
    
    
//	public List<AssetMaster> getAssetsByLocation(String locationName);
//	
//	public List<AssetMaster> getAssetsByFilters(String locationName, String categoryName, String subCategoryName, 
//            String allocationType, String assetStatus);
}
