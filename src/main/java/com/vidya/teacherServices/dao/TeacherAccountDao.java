package com.vidya.teacherServices.dao;

import com.vidya.teacherServices.entities.TeacherAccount;

public interface TeacherAccountDao {
	public TeacherAccount getTeacherDetailsByID(long id) ;
	public long saveTeacherDetails(TeacherAccount tAccount) ;
}
