package com.vidya.teacherServices.dao;


import com.vidya.teacherServices.entities.TeacherAccountEntity;

public interface TeacherAccountDao {
	public TeacherAccountEntity getTeacherDetailsByID(long id) ;
	public TeacherAccountEntity getTeacherDetailsByEmail(String email) ;
	public long saveTeacherDetails(TeacherAccountEntity tAccount) ;
	
}
