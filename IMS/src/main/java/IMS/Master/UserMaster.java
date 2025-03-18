package IMS.Master;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tblUser")
public class UserMaster {
//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @NotNull(message = "First name cannot be null")
    @Size(min = 1, max = 50, message = "First name must be between 1 and 50 characters")
    private String userFirstName;

    private String userMiddleName;

    @NotNull(message = "Last name cannot be null")
    @Size(min = 1, max = 50, message = "Last name must be between 1 and 50 characters")
    private String userLastName;

    @NotNull(message = "Login name cannot be null")
    @Size(min = 5, max = 20, message = "Login name must be between 5 and 20 characters")
    private String userLoginName;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String userLoginPassword;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String userEmail;

    @Size(max = 200, message = "Address must be less than 200 characters")
    private String userAddress;

    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digits")
    private String userMobile;

    private String userGender;

    private String userStatus;
    
    @Past(message = "Date of birth must be a past date") 
    private Date userDateOfBirth;
    
    
    @Pattern(regexp = "^[a-zA-Z]+$", message = "City should contain only letters") 
    @Size(max = 100, message = "City must be less than 100 characters") 
    private String userCity; 
    
    @Pattern(regexp = "^[a-zA-Z]+$", message = "State should contain only letters") 
    @Size(max = 100, message = "State must be less than 100 characters") 
    private String userState; 
    
    @Pattern(regexp = "^[0-9]{6}$", message = "ZIP code should be 6 digits") 
    private String userZipCode; 
    
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Country should contain only letters") 
    private String userCountry;
    
    @ManyToOne
    @JoinColumn(name = "roleId", nullable = false)
    private RoleMaster role;

    @ManyToOne
    @JoinColumn(name = "departmentId", nullable = false)
    private DepartmentMaster department;
   
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
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

	public String getUserLoginPassword() {
		return userLoginPassword;
	}

	public void setUserLoginPassword(String userLoginPassword) {
		this.userLoginPassword = userLoginPassword;
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

	public String getUserZipCode() {
		return userZipCode;
	}

	public void setUserZipCode(String userZipCode) {
		this.userZipCode = userZipCode;
	}

	public String getUserCountry() {
		return userCountry;
	}

	public void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}

	public RoleMaster getRole() {
		return role;
	}

	public void setRole(RoleMaster role) {
		this.role = role;
	}

	public DepartmentMaster getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentMaster department) {
		this.department = department;
	}

	public UserMaster() {
		super();
	}

	public UserMaster(Integer userId,
			@NotNull(message = "First name cannot be null") @Size(min = 1, max = 50, message = "First name must be between 1 and 50 characters") String userFirstName,
			String userMiddleName,
			@NotNull(message = "Last name cannot be null") @Size(min = 1, max = 50, message = "Last name must be between 1 and 50 characters") String userLastName,
			@NotNull(message = "Login name cannot be null") @Size(min = 5, max = 20, message = "Login name must be between 5 and 20 characters") String userLoginName,
			@NotNull(message = "Password cannot be null") @Size(min = 8, message = "Password must be at least 8 characters long") String userLoginPassword,
			@NotNull(message = "Email cannot be null") @Email(message = "Email should be valid") String userEmail,
			@Size(max = 200, message = "Address must be less than 200 characters") String userAddress,
			@Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digits") String userMobile,
			String userGender, String userStatus,
			@Past(message = "Date of birth must be a past date") Date userDateOfBirth,
			@Pattern(regexp = "^[a-zA-Z]+$", message = "City should contain only letters") @Size(max = 100, message = "City must be less than 100 characters") String userCity,
			@Pattern(regexp = "^[a-zA-Z]+$", message = "State should contain only letters") @Size(max = 100, message = "State must be less than 100 characters") String userState,
			@Pattern(regexp = "^[0-9]{6}$", message = "ZIP code should be 6 digits") String userZipCode,
			@Pattern(regexp = "^[a-zA-Z]+$", message = "Country should contain only letters") String userCountry,
			RoleMaster role, DepartmentMaster department) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userMiddleName = userMiddleName;
		this.userLastName = userLastName;
		this.userLoginName = userLoginName;
		this.userLoginPassword = userLoginPassword;
		this.userEmail = userEmail;
		this.userAddress = userAddress;
		this.userMobile = userMobile;
		this.userGender = userGender;
		this.userStatus = userStatus;
		this.userDateOfBirth = userDateOfBirth;
		this.userCity = userCity;
		this.userState = userState;
		this.userZipCode = userZipCode;
		this.userCountry = userCountry;
		this.role = role;
		this.department = department;
	}

	@Override
	public String toString() {
		return "UserMaster [userId=" + userId + ", userFirstName=" + userFirstName + ", userMiddleName="
				+ userMiddleName + ", userLastName=" + userLastName + ", userLoginName=" + userLoginName
				+ ", userLoginPassword=" + userLoginPassword + ", userEmail=" + userEmail + ", userAddress="
				+ userAddress + ", userMobile=" + userMobile + ", userGender=" + userGender + ", userStatus="
				+ userStatus + ", userDateOfBirth=" + userDateOfBirth + ", userCity=" + userCity + ", userState="
				+ userState + ", userZipCode=" + userZipCode + ", userCountry=" + userCountry + ", role=" + role
				+ ", department=" + department + "]";
	}
}
