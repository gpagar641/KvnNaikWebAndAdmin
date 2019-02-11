package com.ganesh.admin.dbmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="faculty_images_details")
public class FacultyImages {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id",length=11)
	private int id;
	
	@Column(name="dept_id",length=11)
	private int deptId;
	
	@Column(name="dept_name",length=200)
	private String deptName;
	
	@Column(name="name",length=200)
	private String name;
	
	@Column(name="post",length=100)
	private String post;
	
	@Column(name="photo",length=50)
	private String photo;
 
	
	@Column(name="file",length=100, nullable=true)
	private String file;
	
	@Column(name="order_by",length=11)
	private int order;
 
	@Column(name="del_status",length=11)
	private int delStatus;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPost() {
		return post;
	}


	public void setPost(String post) {
		this.post = post;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public String getFile() {
		return file;
	}


	public void setFile(String file) {
		this.file = file;
	}


	public int getDelStatus() {
		return delStatus;
	}


	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}


	public int getOrder() {
		return order;
	}


	public void setOrder(int order) {
		this.order = order;
	}


	@Override
	public String toString() {
		return "FacultyImages [id=" + id + ", deptId=" + deptId + ", deptName=" + deptName + ", name=" + name
				+ ", post=" + post + ", photo=" + photo + ", file=" + file + ", order=" + order + ", delStatus="
				+ delStatus + "]";
	}

 
	
}
