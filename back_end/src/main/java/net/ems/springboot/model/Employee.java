package net.ems.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
	
	@Column(name = "first_name")
  private String firstname;
	
	@Column(name = "last_name")
  private String last_name;
	
	@Column(name = "email_id")
  private String emailId;
	
	@Column(name = "posting")
  private String posting;
		
	@Column(name = "phone")
  private String phone;
		
	@Column(name = "position")
  private String position;
	
	@Column(name = "leaves")
	
	  private String leaves;
		
		
  public Employee() {
	  
  }
  
public Employee(String first_name, String last_name, String emailId,String posting,String phone,String position,String leaves) {
	super();
	this.firstname = first_name;
	this.last_name = last_name;
	this.emailId = emailId;
	this.posting = posting;
	this.phone = phone;
	this.position = position;
	this.leaves = leaves;
	
}
public String getPosting() {
	return posting;
}

public void setPosting(String posting) {
	this.posting = posting;
}

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return last_name;
}
public void setLastname(String lastname) {
	this.last_name = lastname;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getPosition() {
	return position;
}

public void setPosition(String position) {
	this.position = position;
}

public String getLeaves() {
	return leaves;
}

public void setLeaves(String leaves) {
	this.leaves = leaves;
}
  
}
