package com.vidya.teacherServices.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.vidya.teacherServices.common.TeacherServiceConstants;
import com.vidya.teacherServices.entities.TeacherAccountEntity;
import com.vidya.teacherServices.entities.TeacherProfileEntity;

@Repository("teacherProfileDAO")
public class TeacherProfileDaoImpl extends TeacherServicesAbstractDAO implements TeacherProfileDao {

	@Override
	public void createOrUpdateTeacherProfile(TeacherProfileEntity tfe, int profilePart) {
		Session session = getSession();
		TeacherProfileEntity existingRecord = null;
		Criteria criteria = session.createCriteria(TeacherProfileEntity.class);
        criteria.add(Restrictions.eq("TEACHER_ID",tfe.getTEACHER_ID()));
        existingRecord = (TeacherProfileEntity)criteria.uniqueResult();
        
        
        if(existingRecord == null)
        {
        	//create new record
        	session.save(tfe);
        }
        else
        {
        	//copy relevant fields to the existing record
        	if(profilePart == TeacherServiceConstants.ProfileSubjects)
        	{
        		existingRecord.setREG_SUBJECT_COMPLETE_FLAG(tfe.getREG_SUBJECT_COMPLETE_FLAG());
        		existingRecord.setSUBJECT_MASTER_ID1(tfe.getSUBJECT_MASTER_ID1());
        		existingRecord.setSUBJECT_MASTER_ID1_EXP(tfe.getSUBJECT_MASTER_ID1_EXP());
        		existingRecord.setSUBJECT_MASTER_ID1_PRM_FLAG(tfe.getSUBJECT_MASTER_ID1_PRM_FLAG());
        		existingRecord.setSUBJECT_MASTER_ID1_SEC_FLAG(tfe.getSUBJECT_MASTER_ID1_SEC_FLAG());
        		existingRecord.setSUBJECT_MASTER_ID2(tfe.getSUBJECT_MASTER_ID2());
        		existingRecord.setSUBJECT_MASTER_ID2_EXP(tfe.getSUBJECT_MASTER_ID2_EXP());
        		existingRecord.setSUBJECT_MASTER_ID2_PRM_FLAG(tfe.getSUBJECT_MASTER_ID2_PRM_FLAG());
        		existingRecord.setSUBJECT_MASTER_ID2_SEC_FLAG(tfe.getSUBJECT_MASTER_ID2_SEC_FLAG());
        		existingRecord.setSUBJECT_MASTER_ID3(tfe.getSUBJECT_MASTER_ID3());
        		existingRecord.setSUBJECT_MASTER_ID3_EXP(tfe.getSUBJECT_MASTER_ID3_EXP());
        		existingRecord.setSUBJECT_MASTER_ID3_PRM_FLAG(tfe.getSUBJECT_MASTER_ID3_PRM_FLAG());
        		existingRecord.setSUBJECT_MASTER_ID3_SEC_FLAG(tfe.getSUBJECT_MASTER_ID3_SEC_FLAG());
        	}
        	else if(profilePart == TeacherServiceConstants.ProfileAvailability)
        	{
        		
        	}
        	else if(profilePart == TeacherServiceConstants.ProfileBasicInfo)
        	{
        		
        	}
        	else if(profilePart == TeacherServiceConstants.ProfilePersonal)
        	{
        		
        	}
        	else if(profilePart == TeacherServiceConstants.ProfileHowItWorks)
        	{
        		
        	}
        	else if(profilePart == TeacherServiceConstants.ProfileTerms)
        	{
        		
        	}
        	else if(profilePart == TeacherServiceConstants.ProfileEmailConf)
        	{
        		
        	}
        	session.update(existingRecord);
        	//update the record
        }
	}

}
