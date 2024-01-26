package com.appfood.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="customer")
public class Customer 
{
   @Id
   //@GeneratedValue(strategy=GenerationType.IDENTITY)
   
   
   @Column(name="customerId")
   private int customerId;
   
   @Column(name="fullName")
   private String fullName;
   
   @Column(name="age")
   private int age;
   
   @Column(name="gender")
   private String gender;
   
   @Column(name="mobileNumber")
   private Long mobileNumber;
   
   @Column(name="email")
   private String email;
   
   @Column(name="password")
   private String password;
   
  

public int getCustomerId() {
	return customerId;
}

public void setCustomerId(int customerId) {
	this.customerId = customerId;
}

public String getFullName() {
	return fullName;
}

public void setFullName(String fullName) {
	this.fullName = fullName;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public Long getMobileNumber() {
	return mobileNumber;
}

public void setMobileNumber(Long mobileNumber) {
	this.mobileNumber = mobileNumber;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public Customer(int customerId, String fullName, int age, String gender, Long mobileNumber, String email,
		String password) {
	super();
	this.customerId = customerId;
	this.fullName = fullName;
	this.age = age;
	this.gender = gender;
	this.mobileNumber = mobileNumber;
	this.email = email;
	this.password = password;
}

public Customer() {
	super();
	// TODO Auto-generated constructor stub
}
   
  




   
   

   
   
}
   


