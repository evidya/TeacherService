package com.vidya.teacherServices.dao;

import com.vidya.teacherServices.entities.TeacherProfileEntity;

public interface TeacherProfileDao {
	public void createOrUpdateTeacherProfile(TeacherProfileEntity tfe, int profilePart);
}
