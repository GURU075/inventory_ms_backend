package specifications;
import org.springframework.data.jpa.domain.Specification;

import IMS.Master.AssetMaster;

public class AssetSpecifications {


    public static Specification<AssetMaster> hasLocation(String location) {
        return (root, query, criteriaBuilder) ->
                location != null ? criteriaBuilder.equal(root.get("location").get("locationName"), location) : null;
    }

    public static Specification<AssetMaster> hasAllocatedTo(String assetAllocationTo) {
        return (root, query, criteriaBuilder) ->
        assetAllocationTo != null ? criteriaBuilder.equal(root.get("assetAllocationTo"), assetAllocationTo) : null;
    }

    public static Specification<AssetMaster> hasAllocationType(String allocationType) {
        return (root, query, criteriaBuilder) ->
                allocationType != null ? criteriaBuilder.equal(root.get("allocationType"), allocationType) : null;
    }

    public static Specification<AssetMaster> hasWarrantyStatus(String warrentyStatus) {
        return (root, query, criteriaBuilder) ->
        warrentyStatus != null ? criteriaBuilder.equal(root.get("warrentyStatus"), warrentyStatus) : null;
    }

    public static Specification<AssetMaster> hasCategory(String category) {
        return (root, query, criteriaBuilder) ->
                category != null ? criteriaBuilder.equal(root.get("category").get("categoryName"), category) : null;
    }
}
