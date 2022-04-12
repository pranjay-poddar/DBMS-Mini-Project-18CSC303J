package net.ems.springboot.dto;


public class EmployeeSearchDto {
	private String first_name;
	private String last_name;
	private String position;
	private String leaves;
	private String posting;
	private String email_id;
	private String phone;
	
	public String getFname() {
		return first_name;
	}
	public void setFname(String fname) {
		this.first_name = fname;
	}
	public String getLname() {
		return last_name;
	}
	public void setLname(String lname) {
		this.last_name = lname;
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
	public String getPosting() {
		return posting;
	}
	public void setPosting(String posting) {
		this.posting = posting;
	}
	public String getEmail() {
		return email_id;
	}
	public void setEmail(String email) {
		this.email_id = email;
	}
	public String getPhone() {
		return phone;
	}
	public EmployeeSearchDto(String first_name, String last_name, String position, String leaves, String posting,
			String email_id, String phone) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.position = position;
		this.leaves = leaves;
		this.posting = posting;
		this.email_id = email_id;
		this.phone = phone;
	}
	public EmployeeSearchDto() {
		
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}

