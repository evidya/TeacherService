package com.vidya.teacherServices.services;

import com.vidya.teacherServices.entities.TeacherAccountEntity;

public interface TeacherAccountService {
	public TeacherAccountEntity getTeacherDetailsByID(long id) ;
	public long saveTeacherDetails(TeacherAccountEntity tAccount) ;
}
