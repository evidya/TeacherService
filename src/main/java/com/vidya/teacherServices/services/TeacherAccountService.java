package com.vidya.teacherServices.services;

import java.util.List;

import com.vidya.teacherServices.entities.TeacherAccountEntity;
import com.vidya.teacherServices.model.Grade;

public interface TeacherAccountService {
	public TeacherAccountEntity getTeacherDetailsByID(long id) ;
	public long saveTeacherDetails(TeacherAccountEntity tAccount) ;
	public TeacherAccountEntity getTeacherDetailsByEmail(String email) ;
	
	public List<Grade> getGrades(long teacherID);
}
