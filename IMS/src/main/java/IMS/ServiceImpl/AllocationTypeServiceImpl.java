package IMS.ServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IMS.DAO.AllocationTypeDAO;
import IMS.DAO.AllocationTypeHistoryDAO;
import IMS.Master.AllocationTypeHistoryMaster;
import IMS.Master.AllocationTypeMaster;
import IMS.Service.AllocationTypeService;

@Service
public class AllocationTypeServiceImpl implements AllocationTypeService {

    private static final Logger logger = LogManager.getLogger(AllocationTypeServiceImpl.class);

    @Autowired
    private AllocationTypeDAO allocationTypeDAO;

    @Autowired
    private AllocationTypeHistoryDAO allocationTypeHistoryDAO;

    @Override
    public Boolean addAllocationTypeService(AllocationTypeMaster allocationTypeMaster) {
        try {
            logger.info("In addAllocationTypeService");
            allocationTypeDAO.save(allocationTypeMaster);

            AllocationTypeHistoryMaster oldAllocationType = new AllocationTypeHistoryMaster();
            oldAllocationType.setAllocationTypeId(allocationTypeMaster.getAllocationTypeId());
            oldAllocationType.setAllocationTypeName(allocationTypeMaster.getAllocationTypeName());
            oldAllocationType.setAllocationTypeDesc(allocationTypeMaster.getAllocationTypeDesc());
            oldAllocationType.setAction("Create");
            oldAllocationType.setTimestamp(LocalDateTime.now());

            allocationTypeHistoryDAO.save(oldAllocationType);
            logger.info("Out of addAllocationTypeService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean updateAllocationTypeService(AllocationTypeMaster allocationTypeMaster) {
        try {
            logger.info("In updateAllocationTypeService");
            AllocationTypeMaster allocationType = allocationTypeDAO.findById(allocationTypeMaster.getAllocationTypeId()).orElseThrow(() -> new RuntimeException("Allocation Type not found"));

            AllocationTypeHistoryMaster oldAllocationType = new AllocationTypeHistoryMaster();
            oldAllocationType.setAllocationTypeId(allocationType.getAllocationTypeId());
            oldAllocationType.setAllocationTypeName(allocationType.getAllocationTypeName());
            oldAllocationType.setAllocationTypeDesc(allocationType.getAllocationTypeDesc());
            oldAllocationType.setAction("Update");
            oldAllocationType.setTimestamp(LocalDateTime.now());

            allocationType.setAllocationTypeName(allocationTypeMaster.getAllocationTypeName());
            allocationType.setAllocationTypeDesc(allocationTypeMaster.getAllocationTypeDesc());
            allocationType = allocationTypeDAO.save(allocationType);

            allocationTypeHistoryDAO.save(oldAllocationType);
            logger.info("Out of updateAllocationTypeService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean deleteAllocationTypeService(AllocationTypeMaster allocationTypeMaster) {
        try {
            logger.info("In deleteAllocationTypeService");
            AllocationTypeMaster allocationType = allocationTypeDAO.findById(allocationTypeMaster.getAllocationTypeId()).orElseThrow(() -> new RuntimeException("Allocation Type not found"));

            AllocationTypeHistoryMaster oldAllocationType = new AllocationTypeHistoryMaster();
            oldAllocationType.setAllocationTypeId(allocationType.getAllocationTypeId());
            oldAllocationType.setAllocationTypeName(allocationType.getAllocationTypeName());
            oldAllocationType.setAllocationTypeDesc(allocationType.getAllocationTypeDesc());
            oldAllocationType.setAction("Delete");
            oldAllocationType.setTimestamp(LocalDateTime.now());

            allocationTypeDAO.delete(allocationType);

            allocationTypeHistoryDAO.save(oldAllocationType);
            logger.info("Out of deleteAllocationTypeService");
            return true;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public AllocationTypeMaster getAllocationTypeService(Integer allocationTypeId) {
        try {
            logger.info("In getAllocationTypeService");
            AllocationTypeMaster allocationTypeMaster = allocationTypeDAO.findById(allocationTypeId).orElse(null);
            logger.info("Out of getAllocationTypeService");
            return allocationTypeMaster;
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<AllocationTypeMaster> getAllAllocationTypeService() {
        List<AllocationTypeMaster> allAllocationTypes = new ArrayList<>();
        try {
            logger.info("In getAllAllocationTypeService");
            allAllocationTypes = (List<AllocationTypeMaster>) allocationTypeDAO.findAll();
            logger.info("Out of getAllAllocationTypeService");
        } catch (Exception e) {
            logger.error("IMS: " + e.getMessage(), e);
        }
        return allAllocationTypes;
    }
}
