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


import com.vidya.teacherServices.entities.TeacherAccount;
import com.vidya.teacherServices.model.Greeting;

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
    	 
    	TeacherAccount tAccount = null;
         try {
        	 tAccount = teacherAccountService.getTeacherDetailsByID(id);
         } catch (Exception e) {
             logger.error(e.getMessage());
            
         }
        return tAccount;
    }
    
    /* functoin to create new teacher account from the first step of teacher registration */
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
