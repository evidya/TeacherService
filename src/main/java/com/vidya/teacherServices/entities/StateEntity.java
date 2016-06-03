package com.vidya.teacherServices.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STATE")
public class StateEntity {

	 @Id
	 @Column(name = "STATE_ID", nullable = false)
	 private String STATE_ID;
	 
	 @Column(name = "STATE_DESCRIPTION", nullable = false)
	 private String STATE_DESCRIPTION;
	 
	 @Column(name = "CREATE_USER")
	 private String CREATE_USER;
	 
	 @Column(name = "CREATE_DATE")
	 private Date CREATE_DATE;
	 
	 @Column(name = "UPDATE_USER")
	 private String UPDATE_USER;
	 
	 @Column(name = "UPDATE_DATE")
	 private Date UPDATE_DATE;

	public String getSTATE_ID() {
		return STATE_ID;
	}

	public String getSTATE_DESCRIPTION() {
		return STATE_DESCRIPTION;
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

	public void setSTATE_ID(String sTATE_ID) {
		STATE_ID = sTATE_ID;
	}

	public void setSTATE_DESCRIPTION(String sTATE_DESCRIPTION) {
		STATE_DESCRIPTION = sTATE_DESCRIPTION;
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
	
			
}
