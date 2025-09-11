package com.example.sportshopee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Address {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long AddrId;

    private String doorNo;
    private String street;
    private String area;
    private String city;
    private String state;
    private String pincode;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
    
    
    public Address() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Address(Long addrId, String doorNo, String street, String area, String city, String state, String pincode,
			Customer customer) {
		super();
		AddrId = addrId;
		this.doorNo = doorNo;
		this.street = street;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.customer = customer;
	}



	public Long getAddrId() {
		return AddrId;
	}



	public void setAddrId(Long addrId) {
		AddrId = addrId;
	}



	public String getDoorNo() {
		return doorNo;
	}



	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}



	public String getStreet() {
		return street;
	}



	public void setStreet(String street) {
		this.street = street;
	}



	public String getArea() {
		return area;
	}



	public void setArea(String area) {
		this.area = area;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getPincode() {
		return pincode;
	}



	public void setPincode(String pincode) {
		this.pincode = pincode;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	@Override
	public String toString() {
		return "Address [AddrId=" + AddrId + ", doorNo=" + doorNo + ", street=" + street + ", area=" + area + ", city="
				+ city + ", state=" + state + ", pincode=" + pincode + ", customer=" + customer + "]";
	}
	
	
	
    

    
}

