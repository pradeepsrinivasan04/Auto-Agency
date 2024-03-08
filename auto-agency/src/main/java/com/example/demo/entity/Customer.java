package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Entity
public class Customer  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	
	@Size(min = 3 , message = "Name must be more than 2 letters")
	private String name;
	
	@Past(message = "Birthdate should be in the past")
	private Date dob;
	
	
	private String password;
	
	private String gender;
	
	@OneToOne(cascade = CascadeType.ALL)
	private UserAddress  address;
	
	
	@Digits(integer = 10 , fraction = 0)
	@Min(value = 6000000000L , message = "Enter Valid phone number , Phone number must be 10 digits")
	@Max(value = 9999999999L , message = "Enter Valid phone number , Phone number must be 10 digits")
	private long mobileNo;
	
	@Email(message = "Enter Valid E-mail id")
	private String emailId;
	
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	
	
	public Customer() {
		
	}



	public Customer(Integer customerId, String name, Date dob,String password,String gender, UserAddress address,long mobileNo, String emailId, Role role) 
	{
		this.customerId = customerId;
		this.name = name;
		this.dob = dob;
		this.password = password;
		this.gender = gender;
		this.address = address;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.role = role;
	}






	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", dob=" + dob + ", password=" + password
				+ ", gender=" + gender + ", address=" + address + ", mobileNo=" + mobileNo + ", emailId=" + emailId
				+ ", role=" + role + "]";
	}



	public Integer getCustomerId() {
		return customerId;
	}



	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Date getDob() {
		return dob;
	}



	public void setDob(Date dob) {
		this.dob = dob;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public UserAddress getAddress() {
		return address;
	}



	public void setAddress(UserAddress address) {
		this.address = address;
	}



	public long getMobileNo() {
		return mobileNo;
	}



	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}



	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}





	
	
	

}

