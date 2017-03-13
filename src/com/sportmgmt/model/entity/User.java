package com.sportmgmt.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="USER")
public class User {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="USER_ID")
	private Integer userId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="DISPLAY_NAME")
	private String displayName;
		
	@Column(name="LOGON_ID")
	private String logonID;
	
	@Column(name="LOGON_PASSWORD")
	private String logonPassword;
	
	@Column(name="USER_TYPE")
	private String userType;
	
	@Column(name="DATE_OF_BIRTH")
	private Date dateOfBirth;
	
	@Column(name="LAST_LOGIN")
	private Date lastLogin;
	
	@Column(name="LAST_UPDATE")
	private Date lastUpdate;
	
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@Column(name="REGISTERED_DATE")
	private Date registerDate;
	
	@Column(name="EMAIL_ID")
	private String emailId;
	
	@Column(name="CONTACT_NUMBER")
	private String contactNumber;
	
	@Column(name="FULL_ADDRESS")
	private String fullAaddress;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="FIELD1_INTEGER")
	private Integer field1_integer;
	
	@Column(name="FIELD1_STRING")
	private String field_string;
	
	@Column(name="FIELD1_DATE")
	private Date field1_date;
	
	@Column(name="FIELD2")
	private String field2;
	
	@Column(name="FIELD3")
	private String field3;
	
	@Column(name="POLICY")
	private String policy;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="COUNTRY")
	private String country;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="PINCODE")
	private String pincode;
	
	@Column(name="ADDRESS1")
	private String address1;
	
	@Column(name="ADDRESS2")
	private String address2;
	
	/*@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="ADDRESS_ID",insertable=true, updatable=true,nullable=true,unique=true)
	private Address addressDetails;*/

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogonID() {
		return logonID;
	}

	public void setLogonID(String logonID) {
		this.logonID = logonID;
	}

	public String getLogonPassword() {
		return logonPassword;
	}

	public void setLogonPassword(String logonPassword) {
		this.logonPassword = logonPassword;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getField1_integer() {
		return field1_integer;
	}

	public void setField1_integer(Integer field1_integer) {
		this.field1_integer = field1_integer;
	}

	public String getField_string() {
		return field_string;
	}

	public void setField_string(String field_string) {
		this.field_string = field_string;
	}

	public Date getField1_date() {
		return field1_date;
	}

	public void setField1_date(Date field1_date) {
		this.field1_date = field1_date;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}

	public String getPolicy() {
		return policy;
	}

	public void setPolicy(String policy) {
		this.policy = policy;
	}

	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getFullAaddress() {
		return fullAaddress;
	}

	public void setFullAaddress(String fullAaddress) {
		this.fullAaddress = fullAaddress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
}
