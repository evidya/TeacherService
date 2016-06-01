package com.vidya.teacherServices.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.vidya.teacherServices.entities.TeacherAccountEntity;



@Repository("teacherAccountDAO")
public class TeacherAccountDaoImpl extends TeacherServicesAbstractDAO implements TeacherAccountDao {

	public TeacherAccountEntity getTeacherDetailsByID(long id) {
	TeacherAccountEntity tAccount = new TeacherAccountEntity();
	Session session = getSession();
		
		Criteria criteria = session.createCriteria(TeacherAccountEntity.class);
        criteria.add(Restrictions.eq("TEACHER_ID",id));
        tAccount = (TeacherAccountEntity)criteria.uniqueResult();
        return tAccount;
	}

	@Override
	public long saveTeacherDetails(TeacherAccountEntity tAccount) {
		Session session = getSession();
		session.save(tAccount);
		
		session.flush();
		return tAccount.getTEACHER_ID();
	}
}
