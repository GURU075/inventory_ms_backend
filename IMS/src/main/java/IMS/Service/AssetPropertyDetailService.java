package IMS.Service;

import java.util.List;

import IMS.Master.AssetPropertyDetailMaster;

public interface AssetPropertyDetailService {

    Boolean addAssetPropertyDetailService(AssetPropertyDetailMaster assetPropertyDetail);
    Boolean updateAssetPropertyDetailService(AssetPropertyDetailMaster assetPropertyDetail);
    Boolean deleteAssetPropertyDetailService(AssetPropertyDetailMaster assetPropertyDetail);
    AssetPropertyDetailMaster getAssetPropertyDetailService(Integer assetPropertyDetailId);
    List<AssetPropertyDetailMaster> getAllAssetPropertyDetailsService();
}
