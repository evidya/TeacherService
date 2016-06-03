package com.vidya.teacherServices.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.vidya.teacherServices.dao.TeacherAccountDao;
import com.vidya.teacherServices.entities.TeacherAccountEntity;
@Service("teacherAccountService")
public class TeacherAccountServiceImpl implements TeacherAccountService {
	@Autowired
    private TeacherAccountDao teacherAccountDao;
	
	@Override
	@Transactional
	public TeacherAccountEntity getTeacherDetailsByID(long id) {
		return teacherAccountDao.getTeacherDetailsByID(id);
	}

	@Override
	@Transactional
	public long saveTeacherDetails(TeacherAccountEntity tAccount) {
		return teacherAccountDao.saveTeacherDetails(tAccount);
	}

	@Override
	@Transactional
	public TeacherAccountEntity getTeacherDetailsByEmail(String email) {
		return teacherAccountDao.getTeacherDetailsByEmail(email);
	}

}
