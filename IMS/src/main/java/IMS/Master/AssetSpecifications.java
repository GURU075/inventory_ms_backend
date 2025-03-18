package IMS.Master;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class AssetSpecifications {

    public static Specification<AssetMaster> hasLocation(String locationName) {
        return (root, query, builder) -> 
            StringUtils.hasText(locationName) ? builder.equal(root.get("location").get("locationName"), locationName) : null;
    }

    public static Specification<AssetMaster> hasCategory(String categoryName) {
        return (root, query, builder) -> 
            StringUtils.hasText(categoryName) ? builder.equal(root.get("category").get("categoryName"), categoryName) : null;
    }

    public static Specification<AssetMaster> hasSubCategory(String subCategoryName) {
        return (root, query, builder) -> 
            StringUtils.hasText(subCategoryName) ? builder.equal(root.get("subCategory").get("subCategoryName"), subCategoryName) : null;
    }

    public static Specification<AssetMaster> hasAllocationType(String allocationType) {
        return (root, query, builder) -> 
            StringUtils.hasText(allocationType) ? builder.equal(root.get("allocationType").get("allocationTypeName"), allocationType) : null;
    }

    public static Specification<AssetMaster> hasAssetStatus(String assetStatus) {
        return (root, query, builder) -> 
            StringUtils.hasText(assetStatus) ? builder.equal(root.get("warrantyStatus").get("warrantyStatusName"), assetStatus) : null;
    }
}
