package com.vidya.teacherServices.dao;


import java.util.List;

import com.vidya.teacherServices.entities.TeacherAccountEntity;
import com.vidya.teacherServices.model.Grade;

public interface TeacherAccountDao {
	public TeacherAccountEntity getTeacherDetailsByID(long id) ;
	public TeacherAccountEntity getTeacherDetailsByEmail(String email) ;
	public long saveTeacherDetails(TeacherAccountEntity tAccount) ;
	List<Grade> getGrades(long teacherID);
}
