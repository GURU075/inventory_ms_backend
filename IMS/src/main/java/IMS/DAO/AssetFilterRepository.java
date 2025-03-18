package IMS.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import IMS.Master.AssetMaster;

public interface AssetFilterRepository extends JpaRepository<AssetMaster, Integer>, JpaSpecificationExecutor<AssetMaster> {

}
