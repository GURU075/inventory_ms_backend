package IMS.Master;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblUserHistory")
public class UserHistoryMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int userId;

    private String userFirstName;

    private String userMiddleName;

    private String userLastName;

    private String userLoginName;

    private String userEmail;

    private String userAddress;

    private String userMobile;

    private String userGender;

    private String userStatus;
    
    private Date userDateOfBirth; 
    
    private String userCity; 
    
    private String userState;
    
    private String userCountry; 

    private int roleId;

    private int departmentId;
    
    private int locationId;

    private String action;

    private LocalDateTime timestamp;

    @PrePersist
    private void onCreate() {
        timestamp = LocalDateTime.now();
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserMiddleName() {
		return userMiddleName;
	}

	public void setUserMiddleName(String userMiddleName) {
		this.userMiddleName = userMiddleName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserLoginName() {
		return userLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public Date getUserDateOfBirth() {
		return userDateOfBirth;
	}

	public void setUserDateOfBirth(Date userDateOfBirth) {
		this.userDateOfBirth = userDateOfBirth;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public String getUserCountry() {
		return userCountry;
	}

	public void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public UserHistoryMaster() {
		super();
	}

	public UserHistoryMaster(Integer id, String action) {
        this.id = id;
        this.action = action;
    }

	public UserHistoryMaster(Integer id, int userId, String userFirstName, String userMiddleName, String userLastName,
			String userLoginName, String userEmail, String userAddress, String userMobile, String userGender,
			String userStatus, Date userDateOfBirth, String userCity, String userState, String userCountry, int roleId,
			int departmentId, int locationId, String action, LocalDateTime timestamp) {
		super();
		this.id = id;
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userMiddleName = userMiddleName;
		this.userLastName = userLastName;
		this.userLoginName = userLoginName;
		this.userEmail = userEmail;
		this.userAddress = userAddress;
		this.userMobile = userMobile;
		this.userGender = userGender;
		this.userStatus = userStatus;
		this.userDateOfBirth = userDateOfBirth;
		this.userCity = userCity;
		this.userState = userState;
		this.userCountry = userCountry;
		this.roleId = roleId;
		this.departmentId = departmentId;
		this.locationId = locationId;
		this.action = action;
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "UserHistoryMaster [id=" + id + ", userId=" + userId + ", userFirstName=" + userFirstName
				+ ", userMiddleName=" + userMiddleName + ", userLastName=" + userLastName + ", userLoginName="
				+ userLoginName + ", userEmail=" + userEmail + ", userAddress=" + userAddress + ", userMobile="
				+ userMobile + ", userGender=" + userGender + ", userStatus=" + userStatus + ", userDateOfBirth="
				+ userDateOfBirth + ", userCity=" + userCity + ", userState=" + userState + ", userCountry="
				+ userCountry + ", roleId=" + roleId + ", departmentId=" + departmentId + ", locationId=" + locationId
				+ ", action=" + action + ", timestamp=" + timestamp + "]";
	}
	
}
