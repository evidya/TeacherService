package com.vidya.teacherServices.services;

import com.vidya.teacherServices.entities.TeacherAccount;

public interface TeacherAccountService {
	public TeacherAccount getTeacherDetailsByID(long id) ;
	public long saveTeacherDetails(TeacherAccount tAccount) ;
}
