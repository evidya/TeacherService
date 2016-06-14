package com.vidya.teacherServices.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.vidya.teacherServices.entities.StateEntity;
import com.vidya.teacherServices.entities.TeacherAccountEntity;
import com.vidya.teacherServices.model.Grade;
import com.vidya.teacherServices.model.Subject;



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
		
		System.out.println("after session.flush : teacher id : "+ tAccount.getTEACHER_ID());
		return tAccount.getTEACHER_ID();
	}
	
	public TeacherAccountEntity getTeacherDetailsByEmail(String email) {
		TeacherAccountEntity tAccount = new TeacherAccountEntity();
		Session session = getSession();
			
			Criteria criteria = session.createCriteria(TeacherAccountEntity.class);
	        criteria.add(Restrictions.eq("TEACHER_EMAIL",email));
	        tAccount = (TeacherAccountEntity)criteria.uniqueResult();
	        return tAccount;
		}

	@Override
	public List<Grade> getGrades(long teacherID) {
		List<Grade> returnList = new ArrayList<Grade>();
		Session session = getSession();
		
		SQLQuery query = session.createSQLQuery("select GRADE_ID, GRADE_SHORT_DESC "
				+ " from GRADE where SCHOOL_LEVEL in ("
				+ " 	select 'Elementary' as schoolType"
				+ "		from TEACHER_ACCOUNT where TEACHER_ID = "
				+ teacherID + " and SCHOOL_ELEMENTARY_FLAG = 1 "
				+ "	union  "
				+ "		select 'Middle' as schoolType"
				+ "		from TEACHER_ACCOUNT where TEACHER_ID= "
				+ teacherID + " and SCHOOL_MIDDLE_FLAG = 1 "
				+ "	union  "
				+ "		select 'High' as schoolType"
				+ "		from TEACHER_ACCOUNT where TEACHER_ID = "
				+ teacherID + " and SCHOOL_HIGH_FLAG = 1 "
				+ " ) order by DISPLAY_ORDER ;" );

		query.setResultTransformer(Transformers.aliasToBean(Grade.class));
		returnList = (List<Grade>)query.list();

		return returnList;
	}

	@Override
	public List<Subject> getMasterSubjects(long teacherID) {
		List<Subject> returnList = new ArrayList<Subject>();
		Session session = getSession();
		
	//get the subjects based on teacher id and school type and grades
		SQLQuery query = session.createSQLQuery("select distinct sm.SUBJECT_MASTER_ID, sm.SUBJECT_MASTER_NAME"
				+ " FROM  SUBJECT_MASTER sm inner join SUBJECT s on"
				+ " sm.subject_master_id=s.subject_master_id"
				+ " where s.grade_id in ("
				+ "select GRADE_ID "
				+ " from GRADE where SCHOOL_LEVEL in ("
				+ " 	select 'Elementary' as schoolType"
				+ "		from TEACHER_ACCOUNT where TEACHER_ID = "
				+ teacherID + " and SCHOOL_ELEMENTARY_FLAG = 1 "
				+ "	union  "
				+ "		select 'Middle' as schoolType"
				+ "		from TEACHER_ACCOUNT where TEACHER_ID= "
				+ teacherID + " and SCHOOL_MIDDLE_FLAG = 1 "
				+ "	union  "
				+ "		select 'High' as schoolType"
				+ "		from TEACHER_ACCOUNT where TEACHER_ID = "
				+ teacherID + " and SCHOOL_HIGH_FLAG = 1 "
				+ " )"
				+ " ) order by sm.SUBJECT_MASTER_ID; " );

		query.setResultTransformer(Transformers.aliasToBean(Subject.class));
		returnList = (List<Subject>)query.list();
		return returnList;
	}
}
