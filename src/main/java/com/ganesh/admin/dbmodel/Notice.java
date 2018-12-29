package com.ganesh.admin.dbmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="notice_details")
public class Notice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id",length=11)
	private int id;
	
	@Column(name="dept_id",length=11)
	private int deptId;
	
	@Column(name="title",length=200)
	private String title;
	
	@Column(name="short_desc",length=100)
	private String shortDesc;
	
	@Column(name="full_desc")
	@Type(type="text")
	private String fullDesc;
 
	
	@Column(name="file",length=100, nullable=true)
	private String file;

	@Column(name="del_status",length=11)
	private int delStatus;
	
	@Column(name="status",length=11)
	private int status;
	
	@Column(name="date",length=100)
	private String date;
	
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getFullDesc() {
		return fullDesc;
	}

	public void setFullDesc(String fullDesc) {
		this.fullDesc = fullDesc;
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

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	@Override
	public String toString() {
		return "Notice [id=" + id + ", deptId=" + deptId + ", title=" + title + ", shortDesc=" + shortDesc
				+ ", fullDesc=" + fullDesc + ", file=" + file + ", delStatus=" + delStatus + ", status=" + status
				+ ", date=" + date + "]";
	}

	
	 

 
	
	

}
