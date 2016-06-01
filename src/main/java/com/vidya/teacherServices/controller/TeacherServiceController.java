package com.vidya.teacherServices.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.vidya.teacherServices.entities.TeacherAccountEntity;
import com.vidya.teacherServices.model.TeacherAccount;
import com.vidya.teacherServices.services.TeacherAccountService;

@RestController
public class TeacherServiceController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
 
	private TeacherAccountService teacherAccountService;

    
    static final Logger logger = LogManager.getLogger(TeacherServiceController.class.getName());
    

    /* functoin to retrieve teacher account information based on Teacher ID */
    @RequestMapping(value = "/getTeacher", method = RequestMethod.GET)
    @ResponseBody
    public TeacherAccount getTeacherInformation(@RequestParam(value = "id") long id) {
    	 
    	TeacherAccountEntity tAccount = null;
    	TeacherAccount returnData = null;
         try {
        	 tAccount = teacherAccountService.getTeacherDetailsByID(id);
        	 
        	 if(tAccount != null)
        	 {
        		 returnData = populateTeacherDTOFromEntity(tAccount);
        	 }
         } catch (Exception e) {
             logger.error(e.getMessage());
            
         }
        return returnData;
    }
    
    /* functoin to create new teacher account from the first step of teacher registration */
    @RequestMapping(value = "/saveTeacherAccount", method = RequestMethod.POST)
    @ResponseBody
    public long createTeacherAccount(TeacherAccount tAccount) {
    	 
    	long retVal = 0;
    	
    	if(tAccount != null)
    	{
    		TeacherAccountEntity te = populateTeacherEntityFromDTO(tAccount);
    		
    		//add other fields if not default in DB
    		
    		try {
    			retVal = teacherAccountService.saveTeacherDetails(te);
    		} catch (Exception e) {
    			logger.error(e.getMessage());
    		}
         }
        return retVal;
    }
    
    private TeacherAccount populateTeacherDTOFromEntity(TeacherAccountEntity tEntity)
    {
    	TeacherAccount ta = new TeacherAccount();
    	if(tEntity != null)
    	{
    		ta.setTeacherID(tEntity.getTEACHER_ID());
    		ta.setTeacherEmail(tEntity.getTEACHER_EMAIL());
    		ta.setTeacherFirstName(tEntity.getTEACHER_FIRST_NAME());
    		ta.setTeacherIsElementary(tEntity.getSCHOOL_ELEMENTARY_FLAG());
    		ta.setTeacherIsHigh(tEntity.getSCHOOL_HIGH_FLAG());
    		ta.setTeacherIsMiddle(tEntity.getSCHOOL_MIDDLE_FLAG());
    		ta.setTeacherLastName(tEntity.getTEACHER_LAST_NAME());
    		ta.setTeacherLocation(tEntity.getLOCATION());
    		ta.setTeacherPhone(tEntity.getTEACHER_PHONE());
    		ta.setTeacherStatus(tEntity.getSTATUS());
    		ta.setTeacherPassword(tEntity.getTEACHER_PWD_ENCPT());
    	}
    	return ta;
    }
    
    private TeacherAccountEntity populateTeacherEntityFromDTO(TeacherAccount tDTO)
    {
    	TeacherAccountEntity te = new TeacherAccountEntity();
    	if(tDTO != null)
    	{
    		te.setTEACHER_ID(tDTO.getTeacherID());
    		te.setLOCATION(tDTO.getTeacherLocation());
    		te.setSCHOOL_ELEMENTARY_FLAG(tDTO.getTeacherIsElementary());
    		te.setSCHOOL_HIGH_FLAG(tDTO.getTeacherIsHigh());
    		te.setSCHOOL_MIDDLE_FLAG(tDTO.getTeacherIsMiddle());
    		te.setTEACHER_EMAIL(tDTO.getTeacherEmail());
    		te.setTEACHER_FIRST_NAME(tDTO.getTeacherFirstName());
    		te.setTEACHER_LAST_NAME(tDTO.getTeacherLastName());
    		te.setTEACHER_PHONE(tDTO.getTeacherPhone());
    		te.setTEACHER_PWD_ENCPT(tDTO.getTeacherPassword());
    		
    	}
    	return te;
    }
}
