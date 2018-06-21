package com.niit.socialnetworkbackend;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.JobDao;
import com.niit.dao.UserDao;
import com.niit.model.Job;
import com.niit.model.User;

public class Jobtestcases {
	
	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	 static JobDao  jobDao;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get the userDAO from context
				jobDao =  (JobDao) context.getBean("jobDao");
	}
	
	@Test
	public void createJobTestCase(){
	
				
	Job job=new Job();

	job.setCompanyName("tech mahindra");
	job.setJobDescription("programming developer");
	job.setJobTitle("WebTechnology");
	job.setLocation("Bangalore");
	job.setPostedOn(new Date());
	job.setSalary("4.5 Lac");
	job.setSkillsRequired("C,Java,SQL");
	
	job.setYrsOfExp("2.5 Years");
	jobDao.saveJob(job);
	
	assertEquals(job.getId(),job.getId());
	
	
	
	}
}

	
	
	 
	
	
	



