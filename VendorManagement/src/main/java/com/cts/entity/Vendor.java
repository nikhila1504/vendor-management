package com.cts.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description = "This is the vendor model")
@Entity(name="Vendors")
public class Vendor {
	@ApiModelProperty(value = "A unique key for each vendor")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long vendorId;
	
	@ApiModelProperty(value = "Name of the vendor")
	@NotNull(message=" first name cannot be null")
	@Size(min=8,message="name must be 8 characters" )
	private String name;
	
	@ApiModelProperty(value = "Address city of the vendor")
	private String address;
	
	@Pattern(regexp="^((\\+){1}91){1}[1-9]{1}[0-9]{9}$",message="must +91 be added while giving number")
	@ApiModelProperty(value = "10 digit mobile number of vendor")
	private String mobileNo;
	
	@ApiModelProperty(value = "Email Id of the vendor")
	@NotNull(message=" Email name cannot be null")
	@Email
	private String emailId;
	
	
	public Vendor() {
		super();
	}
	
	
	
	public Vendor(long vendorId, String name, String address, String mobileNo, String emailId) {
		super();
		this.vendorId = vendorId;
		this.name = name;
		this.address = address;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
	}
	


	

	public Long getVendorId() {
		return vendorId;
	}



	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", name=" + name + ", address=" + address + ", mobileNo=" + mobileNo
				+ ", emailId=" + emailId + "]";
	}

	
	

}