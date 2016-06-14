package com.vidya.teacherServices.dao;


import java.util.List;

import com.vidya.teacherServices.entities.TeacherAccountEntity;
import com.vidya.teacherServices.model.Grade;
import com.vidya.teacherServices.model.Subject;

public interface TeacherAccountDao {
	public TeacherAccountEntity getTeacherDetailsByID(long id) ;
	public TeacherAccountEntity getTeacherDetailsByEmail(String email) ;
	public long saveTeacherDetails(TeacherAccountEntity tAccount) ;
	List<Grade> getGrades(long teacherID);
	
	List<Subject> getMasterSubjects(long teacherID);
}
