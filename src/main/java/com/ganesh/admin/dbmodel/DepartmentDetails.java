package com.ganesh.admin.dbmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin_details")
public class DepartmentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="dept_id",length=11)
	private int deptId;
	
	@Column(name="dept_name",length=200)
	private String deptName;
	
	@Column(name="email",length=100)
	private String email;
	
	@Column(name="password",length=50)
	private String password;
 
	
	@Column(name="contact_no",length=13)
	private String contactNo;

	@Column(name="del_status",length=11)
	private int delStatus;

	public int getDeptId() {
		return deptId;
	}


	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}


	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
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


	public String getContactNo() {
		return contactNo;
	}


	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}


	public int getDelStatus() {
		return delStatus;
	}


	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}


	@Override
	public String toString() {
		return "DepartmentDetails [deptId=" + deptId + ", deptName=" + deptName + ", email=" + email + ", password="
				+ password + ", contactNo=" + contactNo + ", delStatus=" + delStatus + "]";
	}


	 
	
	

}
