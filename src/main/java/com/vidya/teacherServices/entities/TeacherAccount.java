package com.vidya.teacherServices.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TEACHER_ACCOUNT")
public class TeacherAccount {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TEACHER_ID", nullable = false)
    private long TEACHER_ID;
	
	 @Column(name = "TEACHER_FIRST_NAME", nullable = false)
	private String TEACHER_FIRST_NAME;
	
	 @Column(name = "TEACHER_LAST_NAME", nullable = false)
	private String TEACHER_LAST_NAME;
	
	 @Column(name = "TEACHER_EMAIL", nullable = false)
	private String TEACHER_EMAIL;
	
	 @Column(name = "TEACHER_PHONE", nullable = false)
	private String TEACHER_PHONE;
	
	 @Column(name = "LOCATION", nullable = false)
	private String LOCATION;
	 
	 @Column(name = "SCHOOL_ELEMENTARY_FLAG", nullable = false)
	private Integer SCHOOL_ELEMENTARY_FLAG;
	 
	 @Column(name = "SCHOOL_MIDDLE_FLAG", nullable = false)
	private Integer SCHOOL_MIDDLE_FLAG;
	 
	 @Column(name = "SCHOOL_HIGH_FLAG", nullable = false)
	private Integer SCHOOL_HIGH_FLAG;
	 
	 @Column(name = "STATUS", nullable = false)
	private String STATUS;
	 
	 @Column(name = "PROFILE_EST_DATE", nullable = false)
	private Date PROFILE_EST_DATE;
	 
	 @Column(name = "TEACHER_PWD_ENCPT", nullable = false)
	private String TEACHER_PWD_ENCPT;
	 
	 @Column(name = "TEACHER_PROFILE_DATE_COMP_FLAG", nullable = false)
	private Integer TEACHER_PROFILE_DATE_COMP_FLAG;
	 
	 @Column(name = "CREATE_USER", nullable = false)
	private String CREATE_USER; 
	 
	 @Column(name = "CREATE_DATE", nullable = false)
	private Date CREATE_DATE;
	 
	 @Column(name = "UPDATE_USER", nullable = false)
	private String UPDATE_USER;
	 
	 @Column(name = "UPDATE_DATE", nullable = false)
	private Date UPDATE_DATE;

	public String getTEACHER_FIRST_NAME() {
		return TEACHER_FIRST_NAME;
	}
	public String getTEACHER_LAST_NAME() {
		return TEACHER_LAST_NAME;
	}
	public String getTEACHER_EMAIL() {
		return TEACHER_EMAIL;
	}
	public String getTEACHER_PHONE() {
		return TEACHER_PHONE;
	}
	public String getLOCATION() {
		return LOCATION;
	}
	public Integer getSCHOOL_ELEMENTARY_FLAG() {
		return SCHOOL_ELEMENTARY_FLAG;
	}
	public Integer getSCHOOL_MIDDLE_FLAG() {
		return SCHOOL_MIDDLE_FLAG;
	}
	public Integer getSCHOOL_HIGH_FLAG() {
		return SCHOOL_HIGH_FLAG;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public Date getPROFILE_EST_DATE() {
		return PROFILE_EST_DATE;
	}
	public String getTEACHER_PWD_ENCPT() {
		return TEACHER_PWD_ENCPT;
	}
	public Integer getTEACHER_PROFILE_DATE_COMP_FLAG() {
		return TEACHER_PROFILE_DATE_COMP_FLAG;
	}
	public String getCREATE_USER() {
		return CREATE_USER;
	}
	public Date getCREATE_DATE() {
		return CREATE_DATE;
	}
	public String getUPDATE_USER() {
		return UPDATE_USER;
	}
	public Date getUPDATE_DATE() {
		return UPDATE_DATE;
	}
	
	public void setTEACHER_FIRST_NAME(String tEACHER_FIRST_NAME) {
		TEACHER_FIRST_NAME = tEACHER_FIRST_NAME;
	}
	public void setTEACHER_LAST_NAME(String tEACHER_LAST_NAME) {
		TEACHER_LAST_NAME = tEACHER_LAST_NAME;
	}
	public void setTEACHER_EMAIL(String tEACHER_EMAIL) {
		TEACHER_EMAIL = tEACHER_EMAIL;
	}
	public void setTEACHER_PHONE(String tEACHER_PHONE) {
		TEACHER_PHONE = tEACHER_PHONE;
	}
	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}
	public void setSCHOOL_ELEMENTARY_FLAG(Integer sCHOOL_ELEMENTARY_FLAG) {
		SCHOOL_ELEMENTARY_FLAG = sCHOOL_ELEMENTARY_FLAG;
	}
	public void setSCHOOL_MIDDLE_FLAG(Integer sCHOOL_MIDDLE_FLAG) {
		SCHOOL_MIDDLE_FLAG = sCHOOL_MIDDLE_FLAG;
	}
	public void setSCHOOL_HIGH_FLAG(Integer sCHOOL_HIGH_FLAG) {
		SCHOOL_HIGH_FLAG = sCHOOL_HIGH_FLAG;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public void setPROFILE_EST_DATE(Date pROFILE_EST_DATE) {
		PROFILE_EST_DATE = pROFILE_EST_DATE;
	}
	public void setTEACHER_PWD_ENCPT(String tEACHER_PWD_ENCPT) {
		TEACHER_PWD_ENCPT = tEACHER_PWD_ENCPT;
	}
	public void setTEACHER_PROFILE_DATE_COMP_FLAG(Integer tEACHER_PROFILE_DATE_COMP_FLAG) {
		TEACHER_PROFILE_DATE_COMP_FLAG = tEACHER_PROFILE_DATE_COMP_FLAG;
	}
	public void setCREATE_USER(String cREATE_USER) {
		CREATE_USER = cREATE_USER;
	}
	public void setCREATE_DATE(Date cREATE_DATE) {
		CREATE_DATE = cREATE_DATE;
	}
	public void setUPDATE_USER(String uPDATE_USER) {
		UPDATE_USER = uPDATE_USER;
	}
	public void setUPDATE_DATE(Date uPDATE_DATE) {
		UPDATE_DATE = uPDATE_DATE;
	}
	public long getTEACHER_ID() {
		return TEACHER_ID;
	}
	public void setTEACHER_ID(long tEACHER_ID) {
		TEACHER_ID = tEACHER_ID;
	}
	
}
