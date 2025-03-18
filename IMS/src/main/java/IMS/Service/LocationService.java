package IMS.Service;

import java.util.List;

import IMS.Master.LocationMaster;

public interface LocationService {

    public Boolean addLocationService(LocationMaster locationMaster);
    public Boolean updateLocationService(LocationMaster locationMaster);
    public Boolean deleteLocationService(LocationMaster locationMaster);
    public LocationMaster getLocationService(Integer locationId);
    public List<LocationMaster> getAllLocationService();
    LocationMaster getLocationByName(String locationName);
}
