package com.vidya.teacherServices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.vidya.teacherServices.dao.TeacherAccountDao;
import com.vidya.teacherServices.entities.TeacherAccount;
@Service("teacherAccountService")
public class TeacherAccountServiceImpl implements TeacherAccountService {
	@Autowired
    private TeacherAccountDao teacherAccountDao;
	
	@Override
	@javax.transaction.Transactional
	public TeacherAccount getTeacherDetailsByID(long id) {
		return teacherAccountDao.getTeacherDetailsByID(id);
	}

	@Override
	public long saveTeacherDetails(TeacherAccount tAccount) {
		return teacherAccountDao.saveTeacherDetails(tAccount);
	}

}
