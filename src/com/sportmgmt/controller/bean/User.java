package com.sportmgmt.controller.bean;

import java.sql.Date;
import java.util.Map;

public class User {
		
		private Integer userId;
		
		private String firstName;
		
		private String lastName;
		
		private String displayName;
			
		private String logonID;
		
		private String logonPassword;
		
		private String userType;
		
		private Date dateOfBirth;
		
		private Date lastLogin;
		
		private Date lastUpdate;
		
		private Date createdDate;
		
		private Date registerDate;
		
		private String emailId;
		
		private String contactNumber;
		
		private String fullAaddress;
		
		private String gender;
		
		private Integer field1_integer;
		
		private String field_string;
		
		private Date field1_date;
		
		private String field2;
		
		private String field3;
		
		private String policy;
		
		private String status;
		
		private String country;
		
		private String state;
		
		private String city;
		
		private String pincode;
		
		private String address1;
		
		private String address2;
		
		private boolean hasActivePlan;
		
		private Map<String,String> userGameMap;
		
		private ActivePlan activePlan;
		
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

		public boolean isHasActivePlan() {
			return hasActivePlan;
		}

		public void setHasActivePlan(boolean hasActivePlan) {
			this.hasActivePlan = hasActivePlan;
		}

		public ActivePlan getActivePlan() {
			return activePlan;
		}

		public void setActivePlan(ActivePlan activePlan) {
			this.activePlan = activePlan;
		}

		public Map<String, String> getUserGameMap() {
			return userGameMap;
		}

		public void setUserGameMap(Map<String, String> userGameMap) {
			this.userGameMap = userGameMap;
		}
		
}