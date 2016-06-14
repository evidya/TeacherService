package com.vidya.teacherServices.controller;

import java.util.ArrayList;
import java.sql.Date;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.vidya.teacherServices.entities.TeacherAccountEntity;
import com.vidya.teacherServices.model.Grade;
import com.vidya.teacherServices.model.Subject;
import com.vidya.teacherServices.model.TeacherAccount;
import com.vidya.teacherServices.services.StateService;
import com.vidya.teacherServices.services.TeacherAccountService;

@RestController
public class TeacherServiceController {

    
    @Autowired
	private TeacherAccountService teacherAccountService;

    @Autowired
	private StateService stateService;
    
    private static final Logger logger = LogManager.getLogger(TeacherServiceController.class.getName());
    

    /* function to retrieve teacher account information based on Teacher ID */
    @RequestMapping(value = "/getTeacherById", method = RequestMethod.GET)
    @ResponseBody
    public TeacherAccount getTeacherInformationByID(@RequestParam(value = "id") long id) {
    	 
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
    
    /* function to retrieve teacher account information based on Teacher email */
    @RequestMapping(value = "/getTeacherByEmail", method = RequestMethod.GET)
    @ResponseBody
    public TeacherAccount getTeacherInformationByEmail(@RequestParam(value = "email") String email) {
    	 
    	TeacherAccountEntity tAccount = null;
    	TeacherAccount returnData = null;
         try {
        	 tAccount = teacherAccountService.getTeacherDetailsByEmail(email);
        	 
        	 if(tAccount != null)
        	 {
        		 returnData = populateTeacherDTOFromEntity(tAccount);
        	 }
         } catch (Exception e) {
             logger.error(e.getMessage());
            
         }
        return returnData;
    }
    @RequestMapping(value = "/getStates", method = RequestMethod.GET)
    @ResponseBody
    public List<String>  getStates() {
    	 
    	List<String> returnStates = new ArrayList<String>();
         try {
        	 returnStates = stateService.getAllStates();
        	 
        	
         } catch (Exception e) {
             logger.error(e.getMessage());
            
         }
        return returnStates;
    }
    /* function to create new teacher account from the first step of teacher registration */
    @RequestMapping(value = "/saveTeacherAccount", method = RequestMethod.POST)
    @ResponseBody
    public long createTeacherAccount(@RequestBody TeacherAccount tAccount) {
    	 
    	long retVal = 0;
    	
    	if(tAccount != null)
    	{
    		
    		System.out.println("in controller : data received is " + tAccount.toString());
    		TeacherAccountEntity te = populateTeacherEntityFromDTO(tAccount);
    		
    		//adding the default values that we are not accepting from User
    		Date currentDate  = new Date(new java.util.Date().getTime());
    		te.setCREATE_DATE(currentDate);
    		te.setUPDATE_DATE(currentDate);
    		te.setPROFILE_EST_DATE(currentDate);
    		te.setCREATE_USER(te.getTEACHER_FIRST_NAME());
    		te.setUPDATE_USER(te.getTEACHER_FIRST_NAME());
    		te.setSTATUS("Active");
    		
    		if (tAccount.getTeacherIsElementary() == null)
    		{
    			te.setSCHOOL_ELEMENTARY_FLAG(0);
    		}
    		if(tAccount.getTeacherIsHigh() == null)
    		{
    			te.setSCHOOL_HIGH_FLAG(0);
    		}
    		if(tAccount.getTeacherIsMiddle() == null)
    		{
    			te.setSCHOOL_MIDDLE_FLAG(0);
    		}
    		//add other fields if not default in DB
    		
    		try {
    			retVal = teacherAccountService.saveTeacherDetails(te);
    			System.out.println("in controller : return value is : " + retVal);
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
    
    @RequestMapping(value = "/getGrades", method = RequestMethod.GET)
    @ResponseBody
    public List<Grade>  getGrades(@RequestParam(value = "teacherID") long teacherID) {
    	 
    	List<Grade> returnGrades = new ArrayList<Grade>();
         try {
        	 returnGrades = teacherAccountService.getGrades(teacherID);
        	 
        	
         } catch (Exception e) {
             logger.error(e.getMessage());
            
         }
        return returnGrades;
    }
    
    
    @RequestMapping(value = "/getMasterSubjects", method = RequestMethod.GET)
    @ResponseBody
    public List<Subject>  getMasterSubjects(@RequestParam(value = "teacherID") long teacherID) {
    	 
    	List<Subject> returnGrades = new ArrayList<Subject>();
         try {
        	 returnGrades = teacherAccountService.getMasterSubjects(teacherID);
        	 
        	
         } catch (Exception e) {
             logger.error(e.getMessage());
            
         }
        return returnGrades;
    }
}
