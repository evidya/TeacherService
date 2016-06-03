package com.vidya.teacherServices.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vidya.teacherServices.dao.StateDao;
@Service("stateService")
public class StateServiceImpl implements StateService {

	@Autowired
    private StateDao stateDao;
	
	@Override
	@Transactional
	public List<String> getAllStates() {
		return stateDao.getAllStates();
	}

}
