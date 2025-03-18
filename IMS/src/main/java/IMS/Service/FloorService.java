package IMS.Service;

import java.util.List;

import IMS.Master.FloorMaster;

public interface FloorService {

    public Boolean addFloorService(FloorMaster floorMaster);
    public Boolean updateFloorService(FloorMaster floorMaster);
    public Boolean deleteFloorService(FloorMaster floorMaster);
    public FloorMaster getFloorService(Integer floorId);
    public List<FloorMaster> getAllFloorService();
}
