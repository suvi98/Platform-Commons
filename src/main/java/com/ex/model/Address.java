package com.ex.model;

import jakarta.persistence.*;

@Entity
public class Address {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Column
	    private String type; // Permanent, Residential, etc.
	    @Column
	    private String line1;
	    @Column
	    private String city;
	    @Column
	    private String state;
	    @Column
	    private String zip;

		@ManyToOne
		@JoinColumn(name = "employee_id")
	    private Employee employee;
	    
	    
	    
	    @Override
		public String toString() {
			return "Address [id=" + id + ", type=" + type + ", line1=" + line1 + ", city=" + city + ", state=" + state
					+ ", zip=" + zip + ", employee=" + employee + "]";
		}


		public Address() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Address(Long id, String type, String line1, String city, String state, String zip, Employee employee) {
			super();
			this.id = id;
			this.type = type;
			this.line1 = line1;
			this.city = city;
			this.state = state;
			this.zip = zip;
			this.employee = employee;
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getType() {
			return type;
		}


		public void setType(String type) {
			this.type = type;
		}


		public String getLine1() {
			return line1;
		}


		public void setLine1(String line1) {
			this.line1 = line1;
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


		public String getZip() {
			return zip;
		}


		public void setZip(String zip) {
			this.zip = zip;
		}


		public Employee getEmployee() {
			return employee;
		}


		public void setEmployee(Employee employee) {
			this.employee = employee;
		}


	
	    
	}