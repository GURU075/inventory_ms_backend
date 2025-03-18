package IMS.ServiceImpl;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.*;

import IMS.DAO.AssetFilterRepository;
import IMS.Master.AssetFilterRequest;
import IMS.Master.AssetMaster;
import specifications.AssetSpecifications;

@Service
public class AssetFilterServiceImpl {
	private final AssetFilterRepository assetRepository;

    public AssetFilterServiceImpl(AssetFilterRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public List<AssetMaster> getFilteredAssets(AssetFilterRequest filterRequest) {
        Specification<AssetMaster> spec = Specification.where(AssetSpecifications.hasLocation(filterRequest.getLocation()))
                .and(AssetSpecifications.hasAllocatedTo(filterRequest.getAllocatedTo()))
                .and(AssetSpecifications.hasAllocationType(filterRequest.getAllocationType()))
                .and(AssetSpecifications.hasWarrantyStatus(filterRequest.getWarrantyStatus()))
                .and(AssetSpecifications.hasCategory(filterRequest.getCategory()));

        return assetRepository.findAll(spec);
    }
}
