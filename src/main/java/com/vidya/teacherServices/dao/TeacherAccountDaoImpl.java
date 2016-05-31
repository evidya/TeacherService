package com.vidya.teacherServices.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.vidya.teacherServices.entities.TeacherAccount;



@Repository("teacherAccountDAO")
public class TeacherAccountDaoImpl extends TeacherServicesAbstractDAO implements TeacherAccountDao {

	public TeacherAccount getTeacherDetailsByID(long id) {
	TeacherAccount tAccount = new TeacherAccount();
	Session session = getSession();
		
		Criteria criteria = session.createCriteria(TeacherAccount.class);
        criteria.add(Restrictions.eq("TEACHER_ID",id));
        tAccount = (TeacherAccount)criteria.uniqueResult();
        return tAccount;
	}

	@Override
	public long saveTeacherDetails(TeacherAccount tAccount) {
		Session session = getSession();
		session.save(tAccount);
		
		session.flush();
		return tAccount.getTEACHER_ID();
	}
}
