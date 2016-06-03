package com.vidya.teacherServices.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.vidya.teacherServices.entities.StateEntity;


@Repository("stateDAO")
public class StateDaoImpl extends TeacherServicesAbstractDAO implements StateDao {

	@Override
	public List<String> getAllStates() {
		
		List<String> returnList = new ArrayList<String>();
		Session session = getSession();
		
		Criteria crit = session.createCriteria(StateEntity.class);
		List<StateEntity> resultSet =  crit.list();
		
		int noOfresults = 0;
		
		if(resultSet != null)
		{
			noOfresults = resultSet.size();
		}
		
		for(int i=0; i<noOfresults; i++)
		{
			returnList.add(resultSet.get(i).getSTATE_ID());
		}
		return returnList;
	}

}
