package com.vidya.teacherServices.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vidya.teacherServices.entities.TeacherAccount;
import com.vidya.teacherServices.services.TeacherAccountService;

@RestController
public class TeacherServiceController {
    
    @Autowired
	private TeacherAccountService teacherAccountService;

    
    private static final Logger logger = LogManager.getLogger(TeacherServiceController.class.getName());
    

    /* function to retrieve teacher account information based on Teacher ID */
    @RequestMapping(value = "/getTeacher", method = RequestMethod.GET)
    @ResponseBody
    public TeacherAccount getTeacherInformation(@RequestParam(value = "id") long id) {
    	 
    	TeacherAccount tAccount = null;
         try {
        	 tAccount = teacherAccountService.getTeacherDetailsByID(id);
         } catch (Exception e) {
             logger.error(e.getMessage());
            
         }
        return tAccount;
    }
    
    /* function to create new teacher account from the first step of teacher registration */
    @RequestMapping(value = "/saveTeacherAccount", method = RequestMethod.POST)
    @ResponseBody
    public long createTeacherAccount(TeacherAccount tAccount) {
    	 
    	long retVal = 0;
         try {
        	 retVal = teacherAccountService.saveTeacherDetails(tAccount);
         } catch (Exception e) {
             logger.error(e.getMessage());
            
         }
        return retVal;
    }
}
